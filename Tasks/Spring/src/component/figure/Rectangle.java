package component.figure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by EVZabinskaya on 18.01.2018.
 */

@Component
public class Rectangle extends Figure {
    private int width;
    private int height;

    @Autowired
    public Rectangle(@Value("rectangle") String name, @Value("3")  int width, @Value("5")  int height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double square() {
        return this.height*this.width;
    }
}
