package classy.classyapp.BackendApi.repository.class_token;

import classy.classyapp.BackendApi.model.class_token.ClassToken;
import classy.classyapp.BackendApi.model.class_token.ClassTokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassTokenRepository extends JpaRepository<ClassToken, String> {
    List<ClassToken> findByStatus(ClassTokenStatus status);
}
