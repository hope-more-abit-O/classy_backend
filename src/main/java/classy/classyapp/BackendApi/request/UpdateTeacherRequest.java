package classy.classyapp.BackendApi.request;

import java.util.Date;

import classy.classyapp.BackendApi.globalResponse.teacher.TeacherInfoResponse;

public record UpdateTeacherRequest(
        String email,
        String password,
        String name,
        String userName,
        String phone,
        String address,
        Date dateOfBirth,
        TeacherInfoResponse info) {

}
