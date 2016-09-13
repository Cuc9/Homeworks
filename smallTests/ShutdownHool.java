package smallTests;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpi on 11.07.2016.
 */
public class ShutdownHool {

    private static void listWork(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            list.add(i);
        }
        System.out.println(list);

        list.subList(0,2).clear();
        list.remove(list.size() - 1);
        System.out.println(list);
    }

    public static void main(String[] args) {
        String[] arrayStrings = new String[] {"qwe","asd","zxc"};
        Integer[] arrayInts = new Integer[] {1,2,3};

        ForList<String> forListStrings = new ForList<>();
        System.out.println(forListStrings.arrayToList(arrayStrings));

        ForList<Integer> forListIntegers = new ForList<>();
        System.out.println(forListIntegers.arrayToList(arrayInts));

        listWork();
    }
}
