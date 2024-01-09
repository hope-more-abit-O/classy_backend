package classy.classyapp.BackendApi.globalResponse.user;

import java.util.Date;

import classy.classyapp.BackendApi.globalResponse.student.StudentInfoDTO;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;
import java.util.Objects;

public class UserRegisterDTO {
     private String email;
    private String password;
    private String name;
    private String userName;
    private String phone;
    private String address;
    private Role userRole;
    private Date dateOfBirth;
    private AccountStatus status;
    private StudentInfoDTO studentInfo;


    public UserRegisterDTO() {
    }

    public UserRegisterDTO(String email, String password, String name, String userName, String phone, String address, Role userRole, Date dateOfBirth, AccountStatus status, StudentInfoDTO studentInfo) {
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

    public StudentInfoDTO getStudentInfo() {
        return this.studentInfo;
    }

    public void setStudentInfo(StudentInfoDTO studentInfo) {
        this.studentInfo = studentInfo;
    }

    public UserRegisterDTO email(String email) {
        setEmail(email);
        return this;
    }

    public UserRegisterDTO password(String password) {
        setPassword(password);
        return this;
    }

    public UserRegisterDTO name(String name) {
        setName(name);
        return this;
    }

    public UserRegisterDTO userName(String userName) {
        setUserName(userName);
        return this;
    }

    public UserRegisterDTO phone(String phone) {
        setPhone(phone);
        return this;
    }

    public UserRegisterDTO address(String address) {
        setAddress(address);
        return this;
    }

    public UserRegisterDTO userRole(Role userRole) {
        setUserRole(userRole);
        return this;
    }

    public UserRegisterDTO dateOfBirth(Date dateOfBirth) {
        setDateOfBirth(dateOfBirth);
        return this;
    }

    public UserRegisterDTO status(AccountStatus status) {
        setStatus(status);
        return this;
    }

    public UserRegisterDTO studentInfo(StudentInfoDTO studentInfo) {
        setStudentInfo(studentInfo);
        return this;
    }
}
