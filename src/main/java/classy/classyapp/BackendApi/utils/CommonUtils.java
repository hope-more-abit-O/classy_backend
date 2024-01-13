package classy.classyapp.BackendApi.utils;

import classy.classyapp.BackendApi.model.user.User;
import classy.classyapp.BackendApi.model.user.Role;

public class CommonUtils {

    public static boolean hasRole(User user, Role roleToCheck) {
        return user != null && user.getUserRole() == Role.ADMIN;
    }
}
