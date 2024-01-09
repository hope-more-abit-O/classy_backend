package classy.classyapp.BackendApi.globalResponse.student;

import classy.classyapp.BackendApi.model.student_info.StudyStatus;
import java.util.Objects;

public class StudentInfoDTO {
    private String school;
    private StudyStatus studyStatus;


    public StudentInfoDTO() {
    }

    public StudentInfoDTO(String school, StudyStatus studyStatus) {
        this.school = school;
        this.studyStatus = studyStatus;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public StudyStatus getStudyStatus() {
        return this.studyStatus;
    }

    public void setStudyStatus(StudyStatus studyStatus) {
        this.studyStatus = studyStatus;
    }

    public StudentInfoDTO school(String school) {
        setSchool(school);
        return this;
    }

    public StudentInfoDTO studyStatus(StudyStatus studyStatus) {
        setStudyStatus(studyStatus);
        return this;
    }
}
