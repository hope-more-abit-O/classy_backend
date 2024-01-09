package classy.classyapp.BackendApi.repository.user;

import java.util.List;


import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import classy.classyapp.BackendApi.model.user.Role;
import classy.classyapp.BackendApi.model.user.User;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
