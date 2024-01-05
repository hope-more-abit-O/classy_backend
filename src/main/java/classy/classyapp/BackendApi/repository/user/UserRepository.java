package classy.classyapp.BackendApi.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import classy.classyapp.BackendApi.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
