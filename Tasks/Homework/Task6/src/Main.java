/**
 * Created by user on 09.10.2017.
 */
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

       Channel.programs_ort[0]

        Program listProgram1 = new Program("Новости", LocalTime.of(8, 00, 00), LocalTime.of(8, 30, 00));
        Program listProgram2 = new Program("Поле чудес", LocalTime.of(8, 35, 00), LocalTime.of(9, 00, 00));
        Program listProgram3 = new Program("Пусть говорят", LocalTime.of(9, 05, 00), LocalTime.of(10, 00, 00));
        Program listProgram4 = new Program("Что? Где? Когда?", LocalTime.of(10, 05, 00), LocalTime.of(12, 00, 00));
        Program listProgram5 = new Program("Новости", LocalTime.of(12, 05, 00), LocalTime.of(12, 35, 00));
        Channel.setPrograms();




    }
}
