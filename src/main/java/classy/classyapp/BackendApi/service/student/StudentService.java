package classy.classyapp.BackendApi.service.student;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.user.student.Student;
import classy.classyapp.BackendApi.request.UpdateStudentRequest;

public interface StudentService {

    ResponseObject getAllStudents();
    Student updateStudent(String id, UpdateStudentRequest updateRequest);
}