/**
 * Created by user on 09.10.2017.
 */
public class Tv {
    public Channel channels[];

    public Tv(Channel[] channels) {
        this.channels = channels;
    }

    public static void showProgram(Tv tv,int numChannel){
        for(int i=0; i<tv.channels.length;i++) {
            if (i == numChannel){
                Channel.searchProgram(Channel tv.channels[i]);
            }
        }

    }
}
