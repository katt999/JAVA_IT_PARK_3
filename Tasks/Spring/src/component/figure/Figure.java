package component.figure;

/**
 * Created by EVZabinskaya on 18.01.2018.
 */
public abstract class Figure {
    private String name;

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double square();
}
