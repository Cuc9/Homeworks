package lesson4.ownException;

/**
 * Created by arpi on 02.04.2016.
 */
public class MyStrangeException extends Exception {

    public MyStrangeException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "Strange Message: " + super.getMessage();
    }
}
