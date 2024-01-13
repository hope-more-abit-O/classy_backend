package classy.classyapp.BackendApi.service_impl.classes;

import classy.classyapp.BackendApi.exception.global.BadRequestException;
import classy.classyapp.BackendApi.model.class_token.ClassToken;
import classy.classyapp.BackendApi.model.classes.Class;
import classy.classyapp.BackendApi.model.classes.ClassStatus;
import classy.classyapp.BackendApi.repository.classes.ClassRepository;
import classy.classyapp.BackendApi.service.class_token.ClassTokenService;
import classy.classyapp.BackendApi.service.classes.ClassService;
import classy.classyapp.BackendApi.utils.classes.ClassUtils;
import classy.classyapp.BackendApi.utils.duration.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {
    private final ClassTokenService classTokenService;
    private final ClassRepository classRepository;

    public Class getById(String id){
        return classRepository.findById(id).orElseThrow(() -> new BadRequestException("Class not found with id: " + id));
    }
    public String getInviteId(String classId){
        Class cls = getById(classId);
        if (cls.getInviteIdExpire().isBefore(Instant.now().atZone(ZoneId.of("Asia/Bangkok")).toLocalDateTime()))
            throw new BadRequestException("Invite Id is expired!");
        return cls.getInviteId();
    }
    public String getNewInviteIdByClassId(String classId, Duration duration){
        Class cls = getById(classId);
        duration.makeValid();
        String inviteId = ClassUtils.getInviteId();

        cls.setInviteId(inviteId);
        cls.setInviteIdExpire(Instant.now().atZone(ZoneId.of("Asia/Bangkok")).toLocalDateTime()
                .plusSeconds(duration.getSeconds())
                .plusMinutes(duration.getMinutes())
                .plusHours(duration.getHours())
                .plusDays(duration.getDays())
                .plusMonths(duration.getMonths())
        );

        //Save to database
        classRepository.save(cls);

        return inviteId;
    }
    public Class activateClass(String classId, String classTokenId){
        ClassToken token = classTokenService.getById(classTokenId);
        Class cls = getById(classId);
        LocalDateTime currentTime = Instant.now().atZone(ZoneId.of("Asia/Bangkok")).toLocalDateTime();

        //update class
        cls.setClassTokenId(classTokenId);
        cls.setStatus(ClassStatus.ACTIVE);
        cls.setInvalidTime(currentTime.plusMonths(10));

        classTokenService.activateTokenById(classTokenId, currentTime);

        return classRepository.save(cls);
    }
    public Class deactivateClass(String classId){
        Class cls = getById(classId);

        cls.setClassTokenId(null);
        cls.setStatus(ClassStatus.INACTIVE);

        return classRepository.save(cls);
    }

}
