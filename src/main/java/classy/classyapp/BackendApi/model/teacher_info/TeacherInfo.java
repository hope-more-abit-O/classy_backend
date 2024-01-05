package classy.classyapp.BackendApi.model.teacher_info;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String teacherId;
    private String school;
    private String aboutMe;
}
