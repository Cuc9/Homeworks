package lesson2.Phones;

public class Nokia3310 extends Phone {

    public Nokia3310() {
        System.out.println("Nokia3310 constructor");

        touch = false;
        hasWifi = false;
        screenSize = 2;
    }

    @Override
    public void call(String number) {
        super.call(number);
        incCallCount();
        System.out.println("Nokia3310 class is calling " + number);
    }

    @Override
    public void sendSMS(String number, String message) {
        incSmsCount();
        System.out.println("Nokia3310 class is sending sms " + message + " to " + number);
    }
}
