package lesson3.RectanglePrinter;

/**
 * Created by arpi on 08.02.2016.
 */
public class RightTopCorner extends Element {

    public RightTopCorner() {
        this.elem = "\u2510\n";
    }

    @Override
    public void printElem() {
        System.out.print(elem);
    }
}
