package lesson3.RectanglePrinter;

/**
 * Created by arpi on 08.02.2016.
 */
public class EmptyElement extends Element {

    public EmptyElement() {
        this.elem = " ";
    }

    @Override
    public void printElem() {
        System.out.print(elem);
    }
}
