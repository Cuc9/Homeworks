package lesson3.RectanglePrinter;

/**
 * Created by arpi on 08.02.2016.
 */
public class LeftTopCorner extends Element {

    public LeftTopCorner() {
        this.elem = "\u250C";
    }

    @Override
    public void printElem() {
        System.out.print(elem);
    }
}
