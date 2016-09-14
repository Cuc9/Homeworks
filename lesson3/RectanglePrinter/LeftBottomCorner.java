package lesson3.RectanglePrinter;

/**
 * Created by arpi on 08.02.2016.
 */
public class LeftBottomCorner extends Element {
    public LeftBottomCorner() {
        this.elem = "\u2514";
    }

    @Override
    public void printElem() {
        System.out.print(elem);
    }
}
