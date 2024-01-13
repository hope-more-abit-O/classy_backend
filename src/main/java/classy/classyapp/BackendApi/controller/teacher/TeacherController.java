package classy.classyapp.BackendApi.controller.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.request.UpdateTeacherRequest;
import classy.classyapp.BackendApi.service.teacher.TeacherService;


@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getTeacherById(@PathVariable String id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateTeacher(@PathVariable String id, @RequestBody UpdateTeacherRequest updatedTeacher) {
        return ResponseEntity.ok(teacherService.updateTeacher(id, updatedTeacher));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseObject> getTeacherByName(@PathVariable String name) {
        return ResponseEntity.ok(teacherService.getTeacherByName(name));
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<ResponseObject> getTeacherByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(teacherService.getTeacherByPhoneNumber(phoneNumber));
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<ResponseObject> getTeacherByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(teacherService.getTeacherByUserName(userName));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseObject> getTeacherByEmail(@PathVariable String email) {
        return ResponseEntity.ok(teacherService.getTeacherByEmail(email));
    }

}
