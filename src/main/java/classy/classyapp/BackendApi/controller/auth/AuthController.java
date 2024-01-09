package classy.classyapp.BackendApi.controller.auth;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import classy.classyapp.BackendApi.config.JwtProvider;
import classy.classyapp.BackendApi.globalRequest.ConfirmResetPasswordRequest;
import classy.classyapp.BackendApi.globalRequest.LoginRequest;
import classy.classyapp.BackendApi.globalRequest.ResetPasswordRequest;
import classy.classyapp.BackendApi.globalResponse.AuthResponse;
import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.globalResponse.user.UserRegisterDTO;
import classy.classyapp.BackendApi.model.student_info.StudentInfo;
import classy.classyapp.BackendApi.model.student_info.StudyStatus;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;
import classy.classyapp.BackendApi.model.user.User;
import classy.classyapp.BackendApi.model.user.student.Student;
import classy.classyapp.BackendApi.repository.student.StudentRepository;
import classy.classyapp.BackendApi.repository.user.UserRepository;
import classy.classyapp.BackendApi.service.impl.user_info.UserAccountServiceImpl;
import classy.classyapp.BackendApi.utils.email.EmailUtils;

@RestController

@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAccountServiceImpl userAccountService;

    @Autowired
    private EmailUtils emailUtils;

    public AuthController() {
    }

    public AuthController(StudentRepository studentRepository, UserRepository userRepository, JwtProvider jwtProvider,
            PasswordEncoder passwordEncoder, UserAccountServiceImpl userAccountService, EmailUtils emailUtils) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.userAccountService = userAccountService;
        this.emailUtils = emailUtils;
    }

    @PostMapping("/register/user")
    public ResponseEntity<ResponseObject> createUser(@RequestBody UserRegisterDTO userDTO) {
        try {
            if (userRepository.findByEmail(userDTO.getEmail()) != null) {
                throw new RuntimeException("Email is already used");
            }
            if (userRepository.findByUserName(userDTO.getUserName()) != null) {
                throw new RuntimeException("Username is already used");
            }

            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setName(userDTO.getName());
            user.setUserName(userDTO.getUserName());
            user.setPhone(userDTO.getPhone());
            user.setAddress(userDTO.getAddress());
            user.setUserRole(userDTO.getUserRole());
            user.setDateOfBirth(userDTO.getDateOfBirth());
            user.setStatus(userDTO.getStatus().ACTIVE);

            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),
                    user.getPassword());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtProvider.generateToken(authentication);

            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(new ResponseObject(true, "User registered successfully",
                    new AuthResponse(token, "Register Successfully", savedUser)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseObject(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register/student")
    public ResponseEntity<ResponseObject> createStudent(@RequestBody UserRegisterDTO userDTO) {
        try {
            if (userRepository.findByEmail(userDTO.getEmail()) != null) {
                throw new RuntimeException("Email is already used");
            }
            if (userRepository.findByUserName(userDTO.getUserName()) != null) {
                throw new RuntimeException("Username is already used");
            }

            Student student = new Student();
            student.setEmail(userDTO.getEmail());
            student.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            student.setName(userDTO.getName());
            student.setUserName(userDTO.getUserName());
            student.setPhone(userDTO.getPhone());
            student.setAddress(userDTO.getAddress());
            student.setUserRole(userDTO.getUserRole());
            student.setDateOfBirth(userDTO.getDateOfBirth());
            student.setStatus(userDTO.getStatus().ACTIVE);

            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setSchool(userDTO.getStudentInfo().getSchool());
            studentInfo.setStudyStatus(userDTO.getStudentInfo().getStudyStatus());
            studentInfo.setStudent(student);
            student.setInfo(studentInfo);

            Authentication authentication = new UsernamePasswordAuthenticationToken(student.getEmail(),
                    student.getPassword());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtProvider.generateToken(authentication);

            Student savedStudent = studentRepository.save(student);
            return new ResponseEntity<>(new ResponseObject(true, "Student registered successfully",
                    new AuthResponse(token, "Register Successfully", savedStudent)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseObject(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseObject> loginUserHandler(@RequestBody LoginRequest loginRequest) {
        try {
            String login = loginRequest.getLogin();
            String password = loginRequest.getPassword();

            Authentication authentication = authenticate(login, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtProvider.generateToken(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            User user = userRepository.findByUserName(userDetails.getUsername());
            if (user == null) {
                user = userRepository.findByEmail(userDetails.getUsername());
            }

            AuthResponse authResponse = new AuthResponse();
            authResponse.setJwt(token);
            authResponse.setMessage("Login Successfully");
            authResponse.setUser(user);

            ResponseObject responseObject = new ResponseObject(true, "User logged in successfully", authResponse);

            return new ResponseEntity<>(responseObject, HttpStatus.OK);
        } catch (Exception e) {
            ResponseObject responseObject = new ResponseObject(false, e.getMessage(), null);
            return new ResponseEntity<>(responseObject, HttpStatus.UNAUTHORIZED);
        }
    }

    private Authentication authenticate(String login, String password) {
        UserDetails userDetails = null;

        try {
            userDetails = userAccountService.loadUserByUsername(login);
        } catch (UsernameNotFoundException e) {
            userDetails = userAccountService.loadUserByEmail(login);
        }

        if (userDetails == null) {
            throw new BadCredentialsException("Login failed with Username or Email.");
        }
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid Password or Password does not match with any account.");
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @PostMapping("/password/reset")
    public ResponseEntity<ResponseObject> requestPasswordReset(@RequestBody ResetPasswordRequest request) {

        User foundUser = userRepository.findByEmail(request.email());
        UUID resetToken = UUID.randomUUID();
        foundUser.setResetToken(resetToken.toString());
        userRepository.save(foundUser);
        String resetPasswordLink = "localhost:8080/resetpassword/" + resetToken;

        String message = "Click here to reset your password" + resetPasswordLink;
        String subject = "[ClassY] Reset Password Request for User:" + foundUser.getId();
        emailUtils.sendEmail(resetPasswordLink, subject, message);

        ResponseObject responseObject = new ResponseObject(true, "An email has send to your box, please check.", true);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @PostMapping("/password/confirm")
    public ResponseEntity<ResponseObject> confirmResetPassword(@RequestBody ConfirmResetPasswordRequest request) {

        ResponseObject responseObject = new ResponseObject(true, "Successfully", true);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);

    }

}
