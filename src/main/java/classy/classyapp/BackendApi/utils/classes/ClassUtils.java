package classy.classyapp.BackendApi.utils.classes;

import classy.classyapp.BackendApi.utils.duration.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ClassUtils {
    public static String getInviteId(){
        return UUID.randomUUID().toString().substring(0,7) + (new SimpleDateFormat("ssmmHH")).format(new Date().toInstant());
    }
}
