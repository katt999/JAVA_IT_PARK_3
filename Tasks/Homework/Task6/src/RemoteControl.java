/**
 * Created by EVZabinskaya on 09.10.2017.
 */
import java.time.LocalTime;

public class RemoteControl {
   public Tv tv;
   public Channel channel;

   public RemoteControl(Tv tv) {
      this.tv = tv;
   }

   LocalTime time = LocalTime.now();

   public void swichChannel (Channel channel) {
       Program[] programs = channel.getPrograms();
      for (int i=0;i<programs.length;i++) {
         if (time.compareTo(programs[i].getBeginTime()) > 0 && time.compareTo(programs[i].getEndTime()) < 0)
            System.out.println(programs[i].getName() + " " + programs[i].getBeginTime() + " " + programs[i].getEndTime());
      }
      System.out.println("Профилактика");
   }
}
