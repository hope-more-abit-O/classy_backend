package classy.classyapp.BackendApi.model.user.student;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import classy.classyapp.BackendApi.model.student_info.StudentInfo;
import classy.classyapp.BackendApi.model.student_info.StudyStatus;
import classy.classyapp.BackendApi.model.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
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
@Table(name = "students")
@JsonIgnoreProperties(value = { "updateBy", "updateTime", "createBy", "createTime", "empty" })
public class Student extends User {
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private StudentInfo info;

    @Enumerated(EnumType.STRING)
    private StudyStatus studyStatus;

    public boolean isEmpty() {
        return false;
    }
}
