package classy.classyapp.BackendApi.repository.admin;

import classy.classyapp.BackendApi.model.user.User;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdminRepository extends JpaRepository<User, String> {
    List<User> findByStatus(AccountStatus status);
    List<User> findByUserRole(Role role);
}
