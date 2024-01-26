package classy.classyapp.BackendApi.repository.exam;

import classy.classyapp.BackendApi.model.exam.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, String> {
}
