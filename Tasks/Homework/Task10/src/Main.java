/**
 * Created by EVZabinskaya on 23.10.2017.
 */
public class Main {

    public static void main(String[] args) {
        Car car = Car.builder()
                .name("Opel Astra")
                .engineCapacity(1796)
                .maximumSpeed(210)
                .wheelRadius(17)
                .doors(3)
                .build();
    }
}
