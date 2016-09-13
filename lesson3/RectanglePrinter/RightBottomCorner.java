package lesson3.RectanglePrinter;

/**
 * Created by arpi on 08.02.2016.
 */
public class RightBottomCorner extends Element {

    public RightBottomCorner() {
        this.elem = "\u2518\n";
    }

    @Override
    public void printElem() {
        System.out.print(elem);
    }
}
