package classy.classyapp.BackendApi.repository.classes;

import classy.classyapp.BackendApi.model.classes.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class, String> {
}
