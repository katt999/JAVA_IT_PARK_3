/**
 * Created by user on 09.10.2017.
 */
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Program Program1 = new Program("Новости", LocalTime.of(8, 00, 00), LocalTime.of(9, 00, 00));
        Program Program2 = new Program("Поле чудес", LocalTime.of(9, 01, 00), LocalTime.of(10, 00, 00));
        Program Program3 = new Program("Пусть говорят", LocalTime.of(11, 01, 00), LocalTime.of(12, 00, 00));
        Program Program4 = new Program("Что? Где? Когда?", LocalTime.of(12, 01, 00), LocalTime.of(13, 00, 00));
        Program Program5 = new Program("Новости", LocalTime.of(13, 01, 00), LocalTime.of(14, 00, 00));
        Program[] ort = {Program1,Program2,Program3,Program4,Program5};

        Program Program6 = new Program("Орел и решка", LocalTime.of(8, 00, 00), LocalTime.of(9, 00, 00));
        Program Program7 = new Program("На ножах", LocalTime.of(9, 01, 00), LocalTime.of(10, 00, 00));
        Program Program8 = new Program("Битва ресторанов", LocalTime.of(11, 01, 00), LocalTime.of(12, 00, 00));
        Program Program9 = new Program("Пацанки", LocalTime.of(12, 01, 00), LocalTime.of(13, 00, 00));
        Program Program10 = new Program("Битва салонов", LocalTime.of(13, 01, 00), LocalTime.of(14, 00, 00));
        Program[] friday = {Program6,Program7,Program8,Program9,Program10};

        Program Program11 = new Program("Интерны", LocalTime.of(8, 00, 00), LocalTime.of(10, 00, 00));
        Program Program12 = new Program("Физрук", LocalTime.of(10, 01, 00), LocalTime.of(11, 00, 00));
        Program Program13 = new Program("Холостяк", LocalTime.of(12, 01, 00), LocalTime.of(13, 00, 00));
        Program Program14 = new Program("Новости", LocalTime.of(13, 01, 00), LocalTime.of(13, 30, 00));
        Program Program15 = new Program("Дом2", LocalTime.of(13, 31, 00), LocalTime.of(14, 00, 00));
        Program[] tnt = {Program11,Program12,Program13,Program14,Program15};

        Channel channel1 = new Channel(ort);
        Channel channel2 = new Channel(friday);
        Channel channel3 = new Channel(tnt);

        Channel[] channels = {channel1,channel2,channel3};

        Tv tv = new Tv(channels);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер канала: ");
        int numChannel = scanner.nextInt();
        Tv.showProgram(tv,numChannel);

    }
}
