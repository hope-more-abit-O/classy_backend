package classy.classyapp.BackendApi.service.teacher;


import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.request.UpdateTeacherRequest;

public interface TeacherService {
    ResponseObject getAllTeachers();
    ResponseObject getTeacherById(String id);
    ResponseObject updateTeacher(String id, UpdateTeacherRequest request);
    ResponseObject getTeacherByName(String name);
    ResponseObject getTeacherByUserName(String userName);
    ResponseObject getTeacherByEmail(String email);
    ResponseObject getTeacherByPhoneNumber(String phone);
}