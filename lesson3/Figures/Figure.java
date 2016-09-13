package lesson3.Figures;

/**
 * Created by arpi on 02.02.2016.
 */
public abstract class Figure {
    private String name;

    public void setNmae (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public abstract double square ();

}
