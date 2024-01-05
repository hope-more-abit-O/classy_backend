package classy.classyapp.BackendApi.globalResponse;


import classy.classyapp.BackendApi.model.user.User;


public class AuthResponse {
    private String jwt;
    private String message;
    private User user;


    public AuthResponse() {
    }

    public AuthResponse(String jwt, String message, User user) {
        this.jwt = jwt;
        this.message = message;
        this.user = user;
    }

    public String getJwt() {
        return this.jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AuthResponse jwt(String jwt) {
        setJwt(jwt);
        return this;
    }

    public AuthResponse message(String message) {
        setMessage(message);
        return this;
    }

    public AuthResponse user(User user) {
        setUser(user);
        return this;
    }

}