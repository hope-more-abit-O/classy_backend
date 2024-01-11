package classy.classyapp.BackendApi.service.impl.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import classy.classyapp.BackendApi.model.user.student.Student;
import classy.classyapp.BackendApi.model.user.teacher.Teacher;
import classy.classyapp.BackendApi.repository.teacher.TeacherRepository;
import classy.classyapp.BackendApi.request.UpdateTeacherRequest;
import classy.classyapp.BackendApi.service.teacher.TeacherService;
import classy.classyapp.BackendApi.globalResponse.ResponseObject;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseObject getAllTeachers() {
        try {
            List<Teacher> teachers = teacherRepository.findAll();
            return new ResponseObject(true, "Teachers list successfully", teachers);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject getTeacherById(String id) {
        try {
            Teacher teacher = teacherRepository.findById(id).orElse(null);
            if (teacher == null) {
                return new ResponseObject(false, "Teacher not found", null);
            }
            return new ResponseObject(true, "Teacher get successfully", teacher);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject updateTeacher(String id, UpdateTeacherRequest request) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (!optionalTeacher.isPresent()) {
            return new ResponseObject(false, "Teacher not found", null);
        }

        Teacher teacher = optionalTeacher.get();
        teacher.setEmail(request.email());
        teacher.setPassword(passwordEncoder.encode(request.password()));
        teacher.setName(request.name());
        teacher.setUserName(request.userName());
        teacher.setPhone(request.phone());
        teacher.setAddress(request.address());
        teacher.setDateOfBirth(request.dateOfBirth());

        if (teacher.getInfo() != null && request.info() != null) {
            teacher.getInfo().setSchool(request.info().getSchool());
        }

        Teacher updatedTeacher = teacherRepository.save(teacher);
        return new ResponseObject(true, "Teacher updated successfully", updatedTeacher);
    }

    @Override
    public ResponseObject getTeacherByName(String name) {
        try {
            List<Teacher> teachers = teacherRepository.findByName(name);
            return new ResponseObject(true, "Teachers get successfully", teachers);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject getTeacherByUserName(String userName) {
        try {
            Teacher teacher = teacherRepository.findByUserName(userName);
            if (teacher == null) {
                return new ResponseObject(false, "Teacher not found", null);
            }
            return new ResponseObject(true, "Teacher get successfully", teacher);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject getTeacherByEmail(String email) {
        try {
            Teacher teacher = teacherRepository.findByEmail(email);
            if (teacher == null) {
                return new ResponseObject(false, "Teacher not found", null);
            }
            return new ResponseObject(true, "Teacher get successfully", teacher);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

    @Override
    public ResponseObject getTeacherByPhoneNumber(String phone) {
        try {
            List<Teacher> teachers = teacherRepository.findByPhone(phone);
            return new ResponseObject(true, "Teachers fetched successfully", teachers);
        } catch (Exception e) {
            return new ResponseObject(false, e.getMessage(), null);
        }
    }

}