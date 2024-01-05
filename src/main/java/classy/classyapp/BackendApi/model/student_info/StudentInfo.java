package classy.classyapp.BackendApi.model.student_info;

import classy.classyapp.BackendApi.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_info")
public class StudentInfo {
    @Id
    private String studentId;
    private String school;
    @Enumerated(EnumType.STRING)
    private StudyStatus studyStatus;
}
