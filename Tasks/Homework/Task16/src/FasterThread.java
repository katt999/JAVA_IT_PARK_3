/**
 * Created by EVZabinskaya on 21.11.2017.
 */
public class FasterThread extends Thread {
    @Override
    public void run() {
        System.out.println("Пока тот тормозит, я сделаю свои грязные делишки");
    }
}
