package classy.classyapp.BackendApi.controller.student;


import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.user.student.Student;
import classy.classyapp.BackendApi.service.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseObject getAllStudents() {
        return studentService.getAllStudents();
    }
}