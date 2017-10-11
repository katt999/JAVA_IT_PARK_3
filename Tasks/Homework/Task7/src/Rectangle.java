/**
 * Created by EVZabinskaya on 11.10.2017.
 */
public class Rectangle extends Square {
    protected double width;

    public Rectangle(String figure, double height, double width) {
        super (figure, height);
        if (this.width >= 0) this.width = width;
        else this.width = 1;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void calculate()  {
        this.perimeter = 2 * (this.height + this.width);
        this.area = this.height * this.width;
    }

}
