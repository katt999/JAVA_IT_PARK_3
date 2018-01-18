package component;

import component.figure.Figure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by EVZabinskaya on 18.01.2018.
 */
@Component
public class Print {

    @Autowired
    @Qualifier("circle")
    private Figure figure;

    public Print() {
        System.out.println("Bean print is being created");
    }


    public void showSquare() {
        System.out.println("Square of " + this.figure.getName() + " is " + this.figure.square());
    }
}
