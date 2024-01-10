package classy.classyapp.BackendApi.globalRequest.user;

import java.util.Date;

import classy.classyapp.BackendApi.globalResponse.student.StudentInfoResponse;
import classy.classyapp.BackendApi.model.teacher_info.TeacherInfo;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserRegisterRequest {
     private String email;
    private String password;
    private String name;
    private String userName;
    private String phone;
    private String address;
    private Role userRole;
    private Date dateOfBirth;
    private AccountStatus status;
    private StudentInfoResponse studentInfo;
    @JsonIgnoreProperties(value = { "teacherId" })
    private TeacherInfo teacherInfo;




    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String email, String password, String name, String userName, String phone, String address, Role userRole, Date dateOfBirth, AccountStatus status, StudentInfoResponse studentInfo, TeacherInfo teacherInfo) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userName = userName;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.studentInfo = studentInfo;
        this.teacherInfo = teacherInfo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AccountStatus getStatus() {
        return this.status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public StudentInfoResponse getStudentInfo() {
        return this.studentInfo;
    }

    public void setStudentInfo(StudentInfoResponse studentInfo) {
        this.studentInfo = studentInfo;
    }

    public TeacherInfo getTeacherInfo() {
        return this.teacherInfo;
    }

    public void setTeacherInfo(TeacherInfo teacherInfo) {
        this.teacherInfo = teacherInfo;
    }

    public UserRegisterRequest email(String email) {
        setEmail(email);
        return this;
    }

    public UserRegisterRequest password(String password) {
        setPassword(password);
        return this;
    }

    public UserRegisterRequest name(String name) {
        setName(name);
        return this;
    }

    public UserRegisterRequest userName(String userName) {
        setUserName(userName);
        return this;
    }

    public UserRegisterRequest phone(String phone) {
        setPhone(phone);
        return this;
    }

    public UserRegisterRequest address(String address) {
        setAddress(address);
        return this;
    }

    public UserRegisterRequest userRole(Role userRole) {
        setUserRole(userRole);
        return this;
    }

    public UserRegisterRequest dateOfBirth(Date dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public UserRegisterRequest status(AccountStatus status) {
        setStatus(status);
        return this;
    }

    public UserRegisterRequest studentInfo(StudentInfoResponse studentInfo) {
        setStudentInfo(studentInfo);
        return this;
    }

    public UserRegisterRequest teacherInfo(TeacherInfo teacherInfo) {
        setTeacherInfo(teacherInfo);
        return this;
    }
}
