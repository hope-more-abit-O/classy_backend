package classy.classyapp.BackendApi.repository.teacher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import classy.classyapp.BackendApi.model.user.teacher.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    List<Teacher> findByName(String name);
    Teacher findByUserName(String userName);
    Teacher findByEmail(String email);
    List<Teacher> findByPhone(String phone);
}