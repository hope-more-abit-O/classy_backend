package classy.classyapp.BackendApi.exception.global;

import java.io.Serial;

public class BadRequestException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -7034897190745766939L;
    public BadRequestException() {
        super();
    }
    public BadRequestException(String message) {super(message);}
    public BadRequestException(String message, Throwable throwable) {super(message, throwable);}
}
