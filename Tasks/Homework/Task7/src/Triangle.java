/**
 * Created by EVZabinskaya on 11.10.2017.
 */
public class Triangle  extends Rectangle {
    private double side;

    public Triangle(String figure, double height, double width, double side) {
        super (figure, height, width);
        if (this.side >= 0) this.side = side;
        else this.side = 1;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void calculate()  {
        this.perimeter = this.height + this.width + this.side;
        this.area = Math.rint(100.0 * Math.sqrt(this.perimeter/2 * (this.perimeter/2 - this.height) * (this.perimeter/2 - this.width) * (this.perimeter/2 - this.side))) / 100.0;;
    }

}
