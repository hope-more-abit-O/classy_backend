package classy.classyapp.BackendApi.service.impl.student;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.student_info.StudyStatus;
import classy.classyapp.BackendApi.model.user.AccountStatus;
import classy.classyapp.BackendApi.model.user.student.Student;
import classy.classyapp.BackendApi.repository.student.StudentRepository;
import classy.classyapp.BackendApi.request.UpdateStudentRequest;
import classy.classyapp.BackendApi.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseObject getAllStudents() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            return new ResponseObject(false, "No students found", null);
        }
        return new ResponseObject(true, "All students displayed", students);
    }

    @Override
    public ResponseObject getStudentById(String id) {
        try {
            Optional<Student> student = studentRepository.findById(id);
            if (!student.isPresent()) {
                return new ResponseObject(false, "Student not found", null);
            }
            return new ResponseObject(true, "Student retrieved successfully", student.get());
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject getStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email);
        if (student.isEmpty()) {
            return new ResponseObject(false, "No student found with the email: " + email, null);
        }
        return new ResponseObject(true, "Student found", student);
    }

    @Override
    public ResponseObject getStudentByName(String name) {
        List<Student> students = studentRepository.findStudentsByName(name);
        if (students.isEmpty()) {
            return new ResponseObject(false, "No students found with the name: " + name, null);
        }
        return new ResponseObject(true, "Students found", students);
    }

    @Override
    public ResponseObject getAllStudentWithStudyStatus(StudyStatus studyStatus) {
        List<Student> students = studentRepository.findByStudyStatus(studyStatus);
        if (students.isEmpty()) {
            return new ResponseObject(false, "No students found with study status: " + studyStatus, null);
        }
        return new ResponseObject(true, "Students found", students);
    }

    @Override
    public ResponseObject updateStudent(String id, UpdateStudentRequest updateRequest) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (!optionalStudent.isPresent()) {
            return new ResponseObject(false, "Student not found", null);
        }

        Student student = optionalStudent.get();
        student.setEmail(updateRequest.email());
        student.setPassword(passwordEncoder.encode(updateRequest.password()));
        student.setName(updateRequest.name());
        student.setUserName(updateRequest.userName());
        student.setPhone(updateRequest.phone());
        student.setAddress(updateRequest.address());
        student.setDateOfBirth(updateRequest.dateOfBirth());

        if (student.getInfo() != null && updateRequest.info() != null) {
            student.getInfo().setSchool(updateRequest.info().getSchool());
        }

        Student updatedStudent = studentRepository.save(student);
        return new ResponseObject(true, "Student updated successfully", updatedStudent);
    }



}
