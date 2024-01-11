package classy.classyapp.BackendApi.service.student;

import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.student_info.StudyStatus;
import classy.classyapp.BackendApi.request.UpdateStudentRequest;

public interface StudentService {

    ResponseObject getAllStudents();
    ResponseObject getStudentById(String id);
    ResponseObject getStudentByEmail(String email);
    ResponseObject getStudentByName(String name);
    ResponseObject getAllStudentWithStudyStatus(StudyStatus studyStatus);
    ResponseObject updateStudent(String id, UpdateStudentRequest updateRequest);
}
