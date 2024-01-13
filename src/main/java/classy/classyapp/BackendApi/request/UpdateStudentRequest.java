package classy.classyapp.BackendApi.request;

import java.util.Date;
import classy.classyapp.BackendApi.globalResponse.student.StudentInfoResponse;

public record UpdateStudentRequest(
    String email,
    String password,
    String name,
    String userName,
    String phone,
    String address,
    Date dateOfBirth,
    StudentInfoResponse info
) {}
