package lesson2.Phones;

public class MainClassPhones {

    public static void main(String[] args) {
        // Phone p = new Phone(); ������ �.�. ����� �����������

		/*Nokia3310 nokia = new Nokia3310();
        System.out.println("Nokia3310 screen size: " + nokia.getScreenSize());
		nokia.call("123-45-67");
		nokia.sendSMS("567-78-89", "text message");
		System.out.println("Calls - " + nokia.getCallCount() + ", Sms - " + nokia.getSmsCount());

		System.out.println("----------------------------------");

		SamsungS4 samsS4 = new SamsungS4();
		System.out.println("SamsungS4 screen size: " + samsS4.getScreenSize());
		samsS4.call("123-45-67");
		samsS4.sendSMS("567-78-89", "text message");
		System.out.println("Calls - " + samsS4.getCallCount() + ", Sms - " + samsS4.getSmsCount());

		System.out.println("----------------------------------");

		IPhone iphone = new IPhone();
		System.out.println("IPhone screen size: " + iphone.getScreenSize());
		iphone.call("123-45-67");
		iphone.sendSMS("567-78-89", "text message");
		System.out.println("Calls - " + iphone.getCallCount() + ", Sms - " + iphone.getSmsCount());

		System.out.println("----------------------------------");

		IPhone5 iphone5 = new IPhone5();
		System.out.println("IPhone screen size: " + iphone5.getScreenSize());
		iphone5.call("123-45-67");
		iphone5.sendSMS("567-78-89", "text message");
		System.out.println("Calls - " + iphone5.getCallCount() + ", Sms - " + iphone5.getSmsCount());

		System.out.println("----------------------------------");*/


        Nokia3310 nokia1 = new Nokia3310();
        nokia1.setPhoneNumber("050-111-11-11");
        SamsungS4 sams1 = new SamsungS4();
        sams1.setPhoneNumber("063-222-22-22");
        IPhone iphone1 = new IPhone();
        iphone1.setPhoneNumber("066-333-33-33");
        IPhone5 iphone51 = new IPhone5();
        iphone51.setPhoneNumber("066-444-44-44");

	//	Phone.printList();

        nokia1.call("066-444-44-44");

    }
}
