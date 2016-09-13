package lesson4.urlFormating;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by arpi on 06.02.2016.
 */
public class MainUrlFormating {

    private static Map<String,String> parameters;

    public static boolean isFormatOk (String str) {
        parameters = new LinkedHashMap<>();
        if ( (!str.toLowerCase().startsWith("url:")) || (str.lastIndexOf('&') == str.length()-1) || (str.indexOf(' ') != -1)) {
            return false;
        } else {
            String onlyParameters = str.substring(4);
            String[] tmpEQ = onlyParameters.split("&");
            for (String tempSting:tmpEQ){
                int first = tempSting.indexOf('=');
                int last = tempSting.lastIndexOf('=');
                if ( (first != last) ||
                     (first < 1) ||
                     (first == tempSting.length()-1)) {
                        return false;
                }
                String key = tempSting.substring(0, last);
                String value = tempSting.substring(last + 1);
                parameters.put(key,value);
            }
            return true;
        }
    }


    public static void main(String[] args) {
        String url = "Url:name=name1&size=size2&font3=font3&color=color123";
        if(!isFormatOk(url)) {
            try {
                throw new WrongUrlFormatException("URL format is not correct!");
            } catch (WrongUrlFormatException e){
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("All is OK.");
            System.out.println(parameters);
        }
    }
}
