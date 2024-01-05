package classy.classyapp.BackendApi.model.user.teacher;

import classy.classyapp.BackendApi.model.teacher_info.TeacherInfo;
import classy.classyapp.BackendApi.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends User {
    private TeacherInfo info;
}
