package annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by arpi on 02.06.2016.
 */
public class MainClass {
    static Map<String,Object> map = new HashMap<>();

    public static void main(String[] args) {
        /*inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);*/
        startServices(SimpleService.class);
        startServices(LazyService.class);
        startServices(String.class);
        System.out.println(map.get("simple"));
        System.out.println(map.get("lazy"));
    }

    static void inspectService(Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            Service annS = service.getAnnotation(Service.class);
            System.out.println(service.getSimpleName() + " have annotation: " + annS.name());

            Method[] methods = service.getMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(Init.class)) {
                    Init annI = m.getAnnotation(Init.class);
                    System.out.print(m.getName() + " method has Init annotation.");
                    System.out.println(" SuppressException state is: " + annI.suppressException());
                } else System.out.println(m.getName() + " NO Init annotation");
            }

        } else System.out.println(service.getName() + " does not have annotations");
    }

    static void startServices (Class<?> service) {
        if (service.isAnnotationPresent(Service.class)) {
            Object obj = new Object();
            try {
                Class<?> c = Class.forName(service.getName());
                obj = c.newInstance();
                map.put(service.getAnnotation(Service.class).name(),obj);
            } catch (Exception e){
                e.printStackTrace();
            }
            Method[] methods = service.getDeclaredMethods();
            for (Method m : methods){
                if (m.isAnnotationPresent(Init.class)){
                    try {
                        m.invoke(obj);
                    }catch (Exception e){
                        Init annI = m.getAnnotation(Init.class);
                        if (annI.suppressException()){
                            e.printStackTrace();
                        } else {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
