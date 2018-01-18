package component.figure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by EVZabinskaya on 18.01.2018.
 */

@Component
public class Circle extends Figure {

    private int radius;
    public static double PI = 3.14;

    @Autowired
    public Circle(@Value("circle") String name,@Value("5") int radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double square() {
        return PI * this.radius * this.radius;
    }
}
