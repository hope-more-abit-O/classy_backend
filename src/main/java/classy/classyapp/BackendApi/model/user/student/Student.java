package classy.classyapp.BackendApi.model.user.student;

import classy.classyapp.BackendApi.model.student_info.StudentInfo;
import classy.classyapp.BackendApi.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {
    private StudentInfo info;
}
