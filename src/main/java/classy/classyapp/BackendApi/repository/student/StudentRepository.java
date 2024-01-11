package classy.classyapp.BackendApi.repository.student;

import classy.classyapp.BackendApi.model.student_info.StudyStatus;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.student.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByName(String name);

    Student findByEmail(String email);

    List<Student> findByStudyStatus(StudyStatus studyStatus);

    List<Student> findStudentsByName(String name);

    List<Student> findStudentsByEmail(String email);

}