package classy.classyapp.BackendApi.service_impl.class_token;

import classy.classyapp.BackendApi.exception.global.BadRequestException;
import classy.classyapp.BackendApi.model.class_token.ClassToken;
import classy.classyapp.BackendApi.model.class_token.ClassTokenStatus;
import classy.classyapp.BackendApi.repository.class_token.ClassTokenRepository;
import classy.classyapp.BackendApi.repository.user.UserRepository;
import classy.classyapp.BackendApi.service.class_token.ClassTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassTokenServiceImpl implements ClassTokenService {
    private final ClassTokenRepository classTokenRepository;
    private final UserRepository userRepository;

    @Override
    public ClassToken getById(String classTokenId) {
        return classTokenRepository.findById(classTokenId).orElseThrow(() -> new BadRequestException("Class token with id " + classTokenId + " not found"));
    }

    @Override
    public List<ClassToken> getValidTokens() {
        return classTokenRepository.findByStatus(ClassTokenStatus.VALID);
    }

    @Override
    public List<ClassToken> getAllToken() {
        return classTokenRepository.findAll();
    }

    @Override
    public ClassToken addTeacher(String teacherId, String classTokenId) {
        //Check class token exist
        ClassToken classToken = getById(classTokenId);

        //Set teacher id to owner id
        classToken.setOwnedBy(teacherId);
        return classTokenRepository.save(classToken);
    }

    @Override
    public ClassToken activateTokenById(String classTokenId, LocalDateTime currentTime) {
        //Check class token exist
        ClassToken classToken = getById(classTokenId);
        //Set teacher id to owner id
        classToken.setActivatedTime(currentTime.plusMonths(10));
        classToken.setStatus(ClassTokenStatus.ACTIVATE);
        return classToken;
    }

    @Override
    public ClassToken reset(String classTokenId) {
        //Check class token exist
        ClassToken classToken = getById(classTokenId);

        //Set teacher id to owner id
        classToken.setStatus(ClassTokenStatus.VALID);
        return null;
    }

    @Override
    public List<ClassToken> generateNewToken(int tokensCount) {
        if (tokensCount <= 0)
            throw new BadRequestException("The amount of token must be bigger than 0");
        ArrayList<ClassToken> result = new ArrayList<>();
        for (int i = 0; i < tokensCount; i++) {
            result.add(classTokenRepository.save(new ClassToken()));
        }
        return result;
    }
}
