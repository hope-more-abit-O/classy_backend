package classy.classyapp.BackendApi.controller.student;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.request.UpdateStudentRequest;
import classy.classyapp.BackendApi.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateStudent(@PathVariable String id, @RequestBody UpdateStudentRequest updateRequest) {
        return ResponseEntity.ok(studentService.updateStudent(id, updateRequest));
    }
}
