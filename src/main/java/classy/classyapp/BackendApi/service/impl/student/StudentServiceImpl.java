package classy.classyapp.BackendApi.service.impl.student;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.user.student.Student;
import classy.classyapp.BackendApi.repository.student.StudentRepository;
import classy.classyapp.BackendApi.service.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    
    @Override
    public ResponseObject getAllStudents() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            return new ResponseObject(false, "No students found", null);
        }
        return new ResponseObject(true, "All students has bên displayed", students);
    }
}