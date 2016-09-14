package lesson4.student;

import javax.management.BadAttributeValueExpException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by arpi on 07.02.2016.
 */
public abstract class KeyboardInput {

    public static String inputStr (String pole) throws BadAttributeValueExpException {
        String data = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите " + pole + " студента: ");
        if (sc.hasNextLine()){
             data = sc.nextLine();
        }
        if (data.matches("[\\w\\s]*")){
            throw new BadAttributeValueExpException(data);
        }
        return data;
    }

    public static Date inputDate () throws BadAttributeValueExpException {
        Date date = new Date();
        System.out.print("Введите дату рождения студента в формате \"dd.MM.yyyy\": ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()){
            String birthDateStr = sc.nextLine();
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("dd.MM.yyyy");
            try{
               date = format.parse(birthDateStr);
            } catch (ParseException e){
                System.out.println(e.getMessage());
            }
        }
        return date;
    }
}
