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
       Boolean search = false;
       Program[] programs = channel.getPrograms();
      for (int i=0;i<programs.length;i++) {
         if (time.compareTo(programs[i].getBeginTime()) > 0 && time.compareTo(programs[i].getEndTime()) < 0) {
            System.out.println("Сейчас идет передача: "+ programs[i].getName() + " (начало - " + programs[i].getBeginTime() + ", конец - " + programs[i].getEndTime() + ")");
            search = true;
         }
         }
      if (!search)
         System.out.println("Профилактика");
   }
}
