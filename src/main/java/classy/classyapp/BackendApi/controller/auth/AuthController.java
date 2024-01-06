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
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;
import classy.classyapp.BackendApi.model.user.User;
import classy.classyapp.BackendApi.repository.user.UserRepository;
import classy.classyapp.BackendApi.service.impl.user_info.UserAccountServiceImpl;
import classy.classyapp.BackendApi.utils.email.EmailUtils;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

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

    public AuthController(UserRepository userRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder,
            UserAccountServiceImpl userAccountService) {
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.userAccountService = userAccountService;
    }

    @PostMapping("register")
    public ResponseEntity<ResponseObject> createUserHandler(@RequestBody User user) {
        try {

            String email = user.getEmail();
            String password = user.getPassword();
            String name = user.getName();
            String username = user.getUserName();
            String phone = user.getPhone();
            String address = user.getAddress();
            Role userRole = user.getUserRole();
            Date dateOfBirth = user.getDateOfBirth();
            AccountStatus accountStatus = user.getStatus();

            User isEmailExist = userRepository.findByEmail(email);

            if (isEmailExist != null) {
                throw new RuntimeException("Email is already used");
            }

            User existingUserByUsername = userRepository.findByUserName(username);
            if (existingUserByUsername != null) {
                throw new RuntimeException("Username is already used");
            }

            User createdUser = new User();
            createdUser.setEmail(email);
            createdUser.setPassword(passwordEncoder.encode(password));
            createdUser.setName(name);
            createdUser.setAddress(address);
            createdUser.setUserName(username);
            createdUser.setPhone(phone);
            createdUser.setUserRole(Role.STUDENT);
            createdUser.setDateOfBirth(dateOfBirth);
            createdUser.setStatus(AccountStatus.ACTIVE);

            User savedUser = userRepository.save(createdUser);

            Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
                    savedUser.getPassword());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtProvider.generateToken(authentication);

            AuthResponse authResponse = new AuthResponse();
            authResponse.setJwt(token);
            authResponse.setMessage("Register Successfully");
            authResponse.setUser(savedUser);

            ResponseObject responseObject = new ResponseObject(true, "User registered successfully", authResponse);
            return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseObject responseObject = new ResponseObject(false, e.getMessage(), null);
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
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
