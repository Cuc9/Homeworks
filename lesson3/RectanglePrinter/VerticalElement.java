package lesson3.RectanglePrinter;

/**
 * Created by arpi on 08.02.2016.
 */
public class VerticalElement extends Element {

    public VerticalElement (boolean isRight){
        if (isRight){
            this.elem = "\u2502\n";
        } else {
            this.elem = "\u2502";
        }
    }

    @Override
    public void printElem() {
        System.out.print(elem);
    }
}
