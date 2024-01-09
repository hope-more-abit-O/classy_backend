package classy.classyapp.BackendApi.service.admin;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;

public interface AdminService {
    ResponseObject getAllUsers();

    ResponseObject getUsersByStatus(AccountStatus status);

    ResponseObject getUsersByRole(Role role);
}
