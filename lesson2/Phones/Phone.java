package lesson2.Phones;

public abstract class Phone {

    private String phoneNumber;
    protected boolean touch;
    protected boolean hasWifi;
    protected int screenSize;
    //������� �������
    protected int callCount;
    //������� ���
    protected int smsCount;
    private static Phone[] list = new Phone[100];
    private static int i = 0;

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    protected void incCallCount() {
        callCount++;
    }

    protected void incSmsCount() {
        smsCount++;
    }

    public int getCallCount() {
        return callCount;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public Phone() {
        System.out.println("Phone constructor");
        list[i++] = this;
    }

    public boolean isTouch() {
        return touch;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void call(String number) {
        System.out.println(this.getClass() + " is calling " + number);
        for (int r = 0; r < i; r++) {
            if (list [r].getPhoneNumber().equals(number)) {
                list [r].answer();
                return;
            }
        }
        System.out.println("No such number");
    }

/*
    public static void printList (){
        System.out.println("Quantity of numbers " + i);
        for (Phone phone : list) {
            System.out.println(phone.getPhoneNumber());
        }
    }
*/

    public void answer() {
        System.out.println("Connection established");
        System.out.println("Hello, I am " + this.getClass());
    }

    public abstract void sendSMS(String number, String message);
}
