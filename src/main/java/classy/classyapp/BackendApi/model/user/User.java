package classy.classyapp.BackendApi.model.user;

import classy.classyapp.BackendApi.converter.ZonedDateTimeConverter;
import classy.classyapp.BackendApi.model.student_info.StudentInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String userName;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    @JsonIgnore
    private String resetToken;
    @Convert(converter = ZonedDateTimeConverter.class)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Role userRole;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String updateBy;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Convert(converter = ZonedDateTimeConverter.class)
    private LocalDateTime updateTime;
    private String createBy;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Convert(converter = ZonedDateTimeConverter.class)
    private LocalDateTime createTime;


    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StudentInfo studentInfo;
}
