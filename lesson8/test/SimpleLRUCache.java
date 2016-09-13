package lesson8.test;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by arpi on 27.05.2016.
 */
public class SimpleLRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public SimpleLRUCache(int capacity){
        super(capacity+1,1.1f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }
}
