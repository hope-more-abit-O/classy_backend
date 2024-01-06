package classy.classyapp.BackendApi.globalRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class LoginRequest {
    private String login;
    private String password;

}
