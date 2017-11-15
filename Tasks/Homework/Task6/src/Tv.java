/**
 * Created by user on 09.10.2017.
 */
public class Tv {
    public Channel channels[];

    public Tv(Channel[] channels) {
        this.channels = channels;
    }

    public static void showChannel(Channel channel){
         Channel.showProgram(channel[0]);
    }


}
