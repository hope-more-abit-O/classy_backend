package classy.classyapp.BackendApi.model.student_info;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import classy.classyapp.BackendApi.model.user.User;
import classy.classyapp.BackendApi.model.user.student.Student;
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
    @Column(name = "student_id")
    @JsonIgnore
    private String studentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;
    private String school;
    @Enumerated(EnumType.STRING)
    private StudyStatus studyStatus;
}
