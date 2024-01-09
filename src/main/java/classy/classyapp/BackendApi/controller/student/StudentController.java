package classy.classyapp.BackendApi.controller.student;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.user.student.Student;
import classy.classyapp.BackendApi.request.UpdateStudentRequest;
import classy.classyapp.BackendApi.service.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseObject getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateStudent(@PathVariable String id,
            @RequestBody UpdateStudentRequest updateRequest) {
        try {
            Student updatedStudent = studentService.updateStudent(id, updateRequest);
            return ResponseEntity.ok(new ResponseObject(true, "Student updated successfully", updatedStudent));
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseObject(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }
}