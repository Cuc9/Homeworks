package lesson4.student;

import javax.management.BadAttributeValueExpException;
import java.util.Date;

public class MyClass {

    public static void main(String[] args) {
        StudentList sl = new StudentList();

        sl.add(new Student("Seva", "Evgienko", new Date(1986, 1, 1)));
        sl.add(new Student("Vasya", "Pupkin", new Date(1970, 3, 28)));

        //Adding student from the keyboard
        int i = 2; //Enter 2 students
        do {
            i--;
            String name = "";
            String surname = "";
            Date birthDate = new Date();
            boolean flag;
            int j = 1;

                try {
                    name = KeyboardInput.inputStr("имя");
                    surname = KeyboardInput.inputStr("фамилию");
                    birthDate = KeyboardInput.inputDate();
                } catch (BadAttributeValueExpException e){
                    System.out.println("Неверный ввод!");
                }
            sl.add(new Student(name,surname,birthDate));
        } while (i > 0);



		int n = sl.find("Seva");
        System.out.println(sl.get(0).getBirth().toString());

    }
}
