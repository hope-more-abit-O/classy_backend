package classy.classyapp.BackendApi.controller.student;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.student_info.StudyStatus;
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
    public ResponseEntity<ResponseObject> updateStudent(@PathVariable String id,
            @RequestBody UpdateStudentRequest updateRequest) {
        return ResponseEntity.ok(studentService.updateStudent(id, updateRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getStudentById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/status/study/{studyStatus}")
    public ResponseEntity<ResponseObject> getAllStudentWithStudyStatus(@PathVariable StudyStatus studyStatus) {
        return ResponseEntity.ok(studentService.getAllStudentWithStudyStatus(studyStatus));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseObject> getStudentByName(@PathVariable String name) {
        return ResponseEntity.ok(studentService.getStudentByName(name));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseObject> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }
}
