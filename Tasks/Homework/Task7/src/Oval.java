/**
 * Created by EVZabinskaya on 11.10.2017.
 */
public class Oval  extends Circle{
    private String figure;

    private double radiusBig;

    public Oval(String figure, double radius, double radiusBig) {
        super (figure, radius);
        if (this.radiusBig >= 0) this.radiusBig = radiusBig;
        else this.radiusBig = 1;
    }

    public double getRadiusBig() {
        return radiusBig;
    }

    public void setRadiusBig(double radiusBig) {
        this.radiusBig = radiusBig;
    }

    public void calculate()  {
        this.perimeter = Math.rint(100.0 * Math.PI * (this.radius + this.radiusBig))/100.0;
        this.area = Math.rint(100.0 * Math.PI * this.radius * this.radiusBig)/100.0;
    }

}
