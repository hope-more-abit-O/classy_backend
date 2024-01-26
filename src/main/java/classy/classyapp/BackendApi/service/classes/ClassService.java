package classy.classyapp.BackendApi.service.classes;

import classy.classyapp.BackendApi.model.classes.Class;
import classy.classyapp.BackendApi.utils.duration.Duration;

public interface ClassService {
    Class getById(String id);
    String getInviteId(String classId);
    String getNewInviteIdByClassId(String classId, Duration duration);
    Class activateClass(String classId, String classTokenId);
    Class deactivateClass(String classId);
}
