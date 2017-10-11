/**
 * Created by EVZabinskaya on 11.10.2017.
 */
public class Circle {
    private String figure;

    protected double radius;
    protected double perimeter;
    protected double area;

    public Circle(String figure, double radius) {
        this.figure = figure;
        if (this.radius >= 0) this.radius = radius;
        else this.radius = 1;
    }

    public double getRadius() {
        return radius;
    }


    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public void calculate()  {
        this.perimeter = Math.rint(100.0 * 2 * Math.PI * this.radius)/100.0;
        this.area = Math.rint(100.0 * Math.PI * Math.pow(this.radius,2))/100.0;
    }


}
