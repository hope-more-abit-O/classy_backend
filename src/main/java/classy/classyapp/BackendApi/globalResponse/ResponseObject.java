package classy.classyapp.BackendApi.globalResponse;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
@Builder
public class ResponseObject<T> {
    private boolean status;
    private String message;
    private T data;

    public ResponseObject() {
    }

    public ResponseObject(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public <T> ResponseObject<T> body(@Nullable T data){
        return new ResponseObject<T>(this.status, this.message, data);
    }
    public static <T> ResponseObject<T> ok(@Nullable T data){
        return new ResponseObject<T>(true, "Success", data);
    }
    public static <T> ResponseObject<T> ok(@Nullable T data, String message){
        return new ResponseObject<>(true, message, data);
    }
    public static <T> ResponseObject<T> failed(@Nullable T data){
        return new ResponseObject<>(false, "Failed", data);
    }
    public static <T> ResponseObject<T> failed(@Nullable T data, String message){
        return new ResponseObject<>(false, message, data);
    }

}
