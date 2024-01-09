package classy.classyapp.BackendApi.service.impl.admin;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.user.User;
import classy.classyapp.BackendApi.repository.admin.AdminRepository;
import classy.classyapp.BackendApi.service.admin.AdminService;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public ResponseObject getAllUsers() {
        List<User> users = adminRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseObject(false, "No users found", null);
        }
        return new ResponseObject(true, "All users retrieved successfully", users);
    }

    @Override
    public ResponseObject getUsersByStatus(AccountStatus status) {
        List<User> users = adminRepository.findByStatus(status);
        if (users.isEmpty()) {
            return new ResponseObject(false, "No users found with status: " + status, null);
        }
        return new ResponseObject(true, "Users retrieved by status successfully", users);
    }

    @Override
    public ResponseObject getUsersByRole(Role role) {
        List<User> users = adminRepository.findByUserRole(role);
        if (users.isEmpty()) {
            return new ResponseObject(false, "No users found with role: " + role, null);
        }
        return new ResponseObject(true, "Users retrieved by role successfully", users);
    }
}