package lesson8.test;

import lesson6.test.ThreadTest;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by arpi on 27.05.2016.
 */
public class TestClass {
    NavigableSet<Integer> sortedSet;

    //Uses NavigableSet preferences
    Integer getNextElem(Integer elem) {
        return sortedSet.higher(elem);
        /*Iterator<Integer> iterator = sortedSet.iterator();
        Integer e;
        do {
            e = iterator.next();
        } while (!e.equals(elem));
        return iterator.next();*/
    }

    Set<Integer> getPrevElems(Integer elem) {
        return sortedSet.headSet(elem);
    }

    public static void main(String[] args) throws Exception{
//TreeSet compare elements with COMPARATOR (NOT EQUALS!!!)

        /*Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set);*/

//Sorted set TreeSet NAVIGABLESET

        /*TestClass t = new TestClass();
        t.sortedSet = new TreeSet<>();
        for (int i = 1; i < 11; i++) {
            t.sortedSet.add(i);
        }
        System.out.println(t.getNextElem(9));

        System.out.println(t.getPrevElems(5));*/

//HashMap elements sorts by key hash (if Integer we get sorted map)
//LinkedHashMap elements sorts by adding order
//access order
        /*HashMap<Integer,String> hm = new HashMap<>();
        HashMap<Integer,String> lhm = new LinkedHashMap<>(5,1,true);
        hm.put(5, "a"); lhm.put(5, "a");
        hm.put(4, "b"); lhm.put(4, "b");
        hm.put(3, "c"); lhm.put(3, "c");
        hm.put(2, "d"); lhm.put(2, "d");
        hm.put(1, "e"); lhm.put(1, "e");
        lhm.get(5); lhm.get(3); lhm.get(2); lhm.get(5);
        System.out.println(hm);
        System.out.println(lhm);*/
//LRU
        /*HashMap<Integer,String> cash = new SimpleLRUCache<>(2);
        cash.put(1, "a");
        cash.put(2, "b");
        cash.put(3, "c");
        cash.get(2);
        cash.put(9, "e");
        System.out.println(cash);*/

//WeakHashMap
        /*Map<Data,String> map = new WeakHashMap<>();
        Data data = new Data();
        map.put(data,"information");

        data = null;
        System.gc();

        for (int i = 1; i < 10000; i++) {
            if (map.isEmpty()){
                System.out.println("Empty! on " + i);
                break;
            }
        }*/

//Queue Deque PriorityQueue - sorts elements
       /* Queue<Integer> q = new PriorityQueue<>(new QueueComparator());
        q.add(5);
        q.add(2);
        q.add(1);
        q.add(4);
        q.add(6);
        q.add(3);
        q.add(8);
        *//*for (int i = 5; i > 0; i--) {
            q.add(i);
        }*//*
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }*/

//Concurrent collections
/*        List<Integer> list = new ArrayList<>(100);
        for (int i = 1; i < 101; i++) {
            list.add(i);
        }
        List<Integer> syncList = Collections.synchronizedList(list);
        List<Integer> copyOnWriteList = new CopyOnWriteArrayList<>(list);

        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService ex = Executors.newFixedThreadPool(4);
        Future<Long> time1 = ex.submit(new Runner(syncList, 0, 50, latch));
        Future<Long> time2 = ex.submit(new Runner(syncList, 51, 100, latch));
        Future<Long> time3 = ex.submit(new Runner(syncList, 20, 70, latch));
        Future<Long> time4 = ex.submit(new Runner(syncList, 0, 100, latch));
        latch.countDown();
        Long time = time1.get() + time2.get() + time3.get() + time4.get();
        System.out.println("Synchronized collection done in: " + time/1000);

        CountDownLatch latch2 = new CountDownLatch(1);
        time1 = ex.submit(new Runner(copyOnWriteList, 0, 50, latch2));
        time2 = ex.submit(new Runner(copyOnWriteList, 50, 100, latch2));
        time3 = ex.submit(new Runner(copyOnWriteList, 20, 70, latch2));
        time4 = ex.submit(new Runner(copyOnWriteList, 0, 100, latch2));
        latch2.countDown();
        time = time1.get() + time2.get() + time3.get() + time4.get();
        System.out.println("CopyOnWriteCollection collection done in: " + time/1000);
        ex.shutdown();*/

//Blocking Queue
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Thread th1 = new Thread(new Producer(queue));
        Thread th2 = new Thread(new Consumer(queue));
        th1.start();
        th2.start();
    }
}
