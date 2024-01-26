package classy.classyapp.BackendApi.utils.duration;

import lombok.Data;

@Data
public class Duration {
    private Integer seconds;
    private Integer minutes;
    private Integer hours;
    private Integer days;
    private Integer months;
    private Integer years;

    public Duration() {
        this.seconds = 0;
        this.minutes = 0;
        this.hours = 0;
        this.days = 0;
        this.months = 0;
    }

    public void makeValid(){
        if (seconds == null)
            seconds = 0;
        if (minutes == null)
            minutes = 0;
        if (hours == null)
            hours = 0;
        if (days == null)
            days = 0;
        if (months == null)
            months = 0;
    }

    public long toLong(){
        return 0;
    }
}
