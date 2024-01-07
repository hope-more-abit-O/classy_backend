package classy.classyapp.BackendApi.repository.student;

import classy.classyapp.BackendApi.model.user.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByName(String name);
    Student findByEmail(String email);
}