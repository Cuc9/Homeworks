package lesson3.Figures;

/**
 * Created by arpi on 02.02.2016.
 */
public class Circle extends Figure {

    private double radius;

    public Circle (double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double square (){
        return Math.PI*Math.pow(radius,2);
    }
}
