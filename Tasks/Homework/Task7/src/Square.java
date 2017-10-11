/**
 * Created by EVZabinskaya on 11.10.2017.
 */
public class Square {
    private String figure;

    protected double height;
    protected double perimeter;
    protected double area;

    public Square(String figure, double height) {
        this.figure = figure;
        if (this.height >= 0) this.height = height;
        else this.height = 1;
    }

    public double getHeight() {
        return height;
    }


    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public void calculate()  {
        this.perimeter = 4 * this.height;
        this.area = Math.pow(this.height,2);
    }


}
