package lesson2.Figures;

/**
 * Created by arpi on 02.02.2016.
 */
public class Triangle extends Figure {
    private double aSide;
    private double bSide;
    private double cSide;

    public void setaSide(double aSide) {
        this.aSide = aSide;
    }

    public void setbSide(double bSide) {
        this.bSide = bSide;
    }

    public void setcSide(double cSide) {
        this.cSide = cSide;
    }

    public double getaSide() {
        return aSide;
    }

    public double getbSide() {
        return bSide;
    }

    public double getcSide() {
        return cSide;
    }

    public Triangle(double aSide, double bSide, double cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    @Override
    public double square () {
        double p = (aSide + bSide + cSide) / 2;
        return Math.sqrt(p * (p - aSide) * (p - bSide) * (p - cSide));
    }
}
