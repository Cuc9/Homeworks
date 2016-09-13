package lesson3.Figures;

/**
 * Created by arpi on 02.02.2016.
 */
public class Rectangle extends Figure {

    private double length;
    private double height;

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Rectangle(double length, double height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public double square() {
        return length * height;
    }
}
