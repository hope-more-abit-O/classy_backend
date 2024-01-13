package classy.classyapp.BackendApi.controller.class_token;

import classy.classyapp.BackendApi.controller.BaseController;
import classy.classyapp.BackendApi.exception.global.BadRequestException;
import classy.classyapp.BackendApi.globalResponse.BadRequestExceptionResponse;
import classy.classyapp.BackendApi.globalResponse.ResponseObject;
import classy.classyapp.BackendApi.model.class_token.ClassToken;
import classy.classyapp.BackendApi.service.class_token.ClassTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/class-token")
@RequiredArgsConstructor
public class ClassTokenController extends BaseController {
    private final ClassTokenService classTokenService;

    @GetMapping("/ad/generate/{number}")
    public ResponseObject<List<ClassToken>> generate(@PathVariable("number") Integer number){
        return ResponseObject.ok(classTokenService.generateNewToken(number));
    }
    @GetMapping("/test")
    public String test(){
        return "hi";
    }
}
