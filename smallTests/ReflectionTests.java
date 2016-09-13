package smallTests;

import lesson2.Figures.Circle;
import playcards.domain.Event;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Created by arpi on 20.07.2016.
 */
public class ReflectionTests {

    public static void main(String[] args) {
        //int [] a = {1,2,3};
        Class <?> c = null;
        try {
            c = Class.forName("lesson2.Figures.Circle");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }
        if (null != c){
            try {

                Constructor<?> con = c.getConstructor(double.class);
                Object obj = con.newInstance(10);
                //Object obj = c.newInstance();
                Circle test = (Circle) obj;
                Method setRadius = c.getDeclaredMethod("setRadius", double.class);
                setRadius.setAccessible(true);
                setRadius.invoke(test, 10.0);
                Method getRadius = c.getMethod("getRadius");
                System.out.println(getRadius.invoke(test));
                Field radius = c.getDeclaredField("radius");
                radius.setAccessible(true);
                radius.setDouble(test, 20.0);
                System.out.println(getRadius.invoke(test));
            }catch (Exception e){
                System.out.println("Instance problems");
            }
        }
        /*Field [] carFields = c.getDeclaredFields();
        for (Field f : carFields){
            System.out.println(f.getName());
        }*/
        /*Method [] carMeth = c.getMethods();
        for (Method f : carMeth){
            System.out.println(f.getName());
        }*/
    }
}
