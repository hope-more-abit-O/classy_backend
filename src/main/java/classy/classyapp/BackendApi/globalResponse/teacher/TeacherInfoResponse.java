package classy.classyapp.BackendApi.globalResponse.teacher;

public class TeacherInfoResponse {
    private String school;


    public TeacherInfoResponse() {
    }

    public TeacherInfoResponse(String school) {
        this.school = school;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public TeacherInfoResponse school(String school) {
        setSchool(school);
        return this;
    }

}
