/**
 * Created by user on 09.10.2017.
 */
import java.time.LocalTime;

public class Program {
    public String name;
    public LocalTime beginTime;
    public LocalTime endTime;

    public Program(String name, LocalTime beginTime, LocalTime endTime) {
        this.name = name;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public LocalTime getEndTime() {return endTime; }

}
