package classy.classyapp.BackendApi.model.teacher_info;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import classy.classyapp.BackendApi.model.user.student.Student;
import classy.classyapp.BackendApi.model.user.teacher.Teacher;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher_info")
public class TeacherInfo {
    @Id
    @JsonIgnore
    private String teacherId;

    private String school;
    
    @JsonIgnore
    private String aboutMe;

    @OneToOne
    @MapsId
    @JoinColumn(name = "teacher_id")
    @JsonBackReference
    private Teacher teacher;
}
