package smallTests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arpi on 13.07.2016.
 */
public class ForList<T> {

    public List<T> arrayToList (T[] array){
        List<T> list = new ArrayList();
        for (T elem:array){
            list.add(elem);
        }
        return list;
    }
}
