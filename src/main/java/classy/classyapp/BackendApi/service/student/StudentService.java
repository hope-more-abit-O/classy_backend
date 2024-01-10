package classy.classyapp.BackendApi.service.student;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.request.UpdateStudentRequest;

public interface StudentService {

    ResponseObject getAllStudents();
    ResponseObject updateStudent(String id, UpdateStudentRequest updateRequest);
}
