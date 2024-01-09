package classy.classyapp.BackendApi.controller.admin;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.Role;
import classy.classyapp.BackendApi.service.admin.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<ResponseObject> getAllUsers() {
        try {
            ResponseObject responseObject = adminService.getAllUsers();
            return ResponseEntity.ok(responseObject);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseObject(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/status/{status}")
    public ResponseEntity<ResponseObject> getUsersByStatus(@PathVariable AccountStatus status) {
        try {
            ResponseObject responseObject = adminService.getUsersByStatus(status);
            return ResponseEntity.ok(responseObject);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseObject(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/role/{role}")
    public ResponseEntity<ResponseObject> getUsersByRole(@PathVariable Role role) {
        try {
            ResponseObject responseObject = adminService.getUsersByRole(role);
            return ResponseEntity.ok(responseObject);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseObject(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}