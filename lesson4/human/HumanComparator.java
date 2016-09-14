package lesson4.human;

import java.util.Comparator;

/**
 * Created by arpi on 11.02.2016.
 */
public class HumanComparator implements Comparator{
    public int compare (Object h1, Object h2){
        Human first = (Human) h1;
        Human second = (Human) h2;
        //return second.getAge()-first.getAge(); // down
        return first.getAge()-second.getAge(); // up
    }
}
