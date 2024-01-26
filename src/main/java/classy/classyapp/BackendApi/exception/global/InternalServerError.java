package classy.classyapp.BackendApi.exception.global;

import java.io.Serial;

public class InternalServerError extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -7034897190745766939L;
    public InternalServerError() {
        super();
    }
    public InternalServerError(String message) {super(message);}
    public InternalServerError(String message, Throwable throwable) {super(message, throwable);}
}
