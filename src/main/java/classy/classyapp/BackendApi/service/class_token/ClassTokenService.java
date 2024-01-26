package classy.classyapp.BackendApi.service.class_token;

import classy.classyapp.BackendApi.model.class_token.ClassToken;
import org.apache.coyote.BadRequestException;

import java.time.LocalDateTime;
import java.util.List;

public interface ClassTokenService {
    ClassToken getById(String classTokenId);
    List<ClassToken> getValidTokens();
    List<ClassToken> getAllToken();
    ClassToken addTeacher(String teacherId, String classTokenId);
    ClassToken activateTokenById(String classTokenId, LocalDateTime currentTime);
    List<ClassToken> generateNewToken(int tokensCount);
    ClassToken reset(String classTokenId);
}
