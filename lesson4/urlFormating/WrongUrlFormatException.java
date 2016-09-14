package lesson4.urlFormating;

/**
 * Created by arpi on 06.02.2016.
 */
public class WrongUrlFormatException extends Exception {
    public WrongUrlFormatException (String message){
        super(message);
    }

    @Override
    public String getMessage () {
        return "WrongUrlFormatException: " + super.getMessage();
    }

    public static void main(String[] args) throws WrongUrlFormatException {
        throw new WrongUrlFormatException("URL format is not correct!");
    }
}
