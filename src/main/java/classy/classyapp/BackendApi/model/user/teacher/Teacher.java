package classy.classyapp.BackendApi.model.user.teacher;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import classy.classyapp.BackendApi.model.student_info.StudentInfo;
import classy.classyapp.BackendApi.model.teacher_info.TeacherInfo;
import classy.classyapp.BackendApi.model.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
@JsonIgnoreProperties(value = { "updateBy", "updateTime", "createBy", "createTime", "empty" })
public class Teacher extends User {
    @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private TeacherInfo info;
}
