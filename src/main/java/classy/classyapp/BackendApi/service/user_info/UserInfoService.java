package classy.classyapp.BackendApi.service.user_info;


import classy.classyapp.BackendApi.exception.user_info.UserException;
import classy.classyapp.BackendApi.model.user.User;

public interface UserInfoService {
    public User findUserById(String userId) throws UserException;
    
}
