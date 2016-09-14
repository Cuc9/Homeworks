package lesson4.ownException;

/**
 * Created by arpi on 02.04.2016.
 */
public class Main {
    public static void action() throws MyStrangeException {
        throw new MyStrangeException("Very strange exception");
    }

    public static void main(String[] args) {
        try {
            action();
        } catch (MyStrangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
