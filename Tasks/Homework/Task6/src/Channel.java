import java.time.LocalTime;

/**
 * Created by user on 09.10.2017.
 */

public class Channel {
    public Program programs[];

    public Channel(Program[] programs) {
        this.programs = programs;
    }

    public Program[] getPrograms() {
        return programs;
    }

    public static void showChannel(Channel channel){
        for (int i=0;i < channel.;)
        Program.showProgram(channel[i]);
    }




}
