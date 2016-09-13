package lesson8.test;

import java.util.Comparator;

/**
 * Created by arpi on 28.05.2016.
 */
public class QueueComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1 = (Integer)o1;
        Integer i2 = (Integer)o2;

        if ( (i1%2==0) && (i2%2!=0) ){
            return -1;
        } else if ((i1%2!=0) && (i2%2==0)){
            return 1;
        } else {
            return i1-i2;
        }
    }
}

/*
public class QueueComparator<T extends Number> implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        T i1 = (T)o1;
        T i2 = (T)o2;

        if ( (i1%2==0) && (i2%2!=0) ){
            return -1;
        } else if ((i1%2!=0) && (i2%2==0)){
            return 1;
        } else {
            return i1-i2;
        }
    }
}*/
