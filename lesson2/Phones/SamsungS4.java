package lesson2.Phones;

/**
 * Created by arpi on 01.02.2016.
 */
public class SamsungS4 extends Phone {

    public SamsungS4() {
        System.out.println("SamsungS4 constructor");

        touch = true;
        hasWifi = true;
        screenSize = 5;
    }

    @Override
    public void sendSMS(String number, String message) {
        message += " Hello ";
        System.out.println("SamsungS4 class is sending sms " + message + " to " + number);
        incSmsCount();
    }

    @Override
    public void call(String number) {
        System.out.println("SamsungS4 class is calling " + number);
        incCallCount();
    }
}
