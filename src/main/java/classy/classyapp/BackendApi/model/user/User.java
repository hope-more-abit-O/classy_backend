package classy.classyapp.BackendApi.model.user;

import classy.classyapp.BackendApi.converter.ZonedDateTimeConverter;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;
    private String userName;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Convert(converter = ZonedDateTimeConverter.class)
    private LocalDateTime dateOfBirth;
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
}
