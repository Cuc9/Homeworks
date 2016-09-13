package lesson7.sumCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by arpi on 26.04.2016.
 */
public class ThreadArrSum {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[100000000];
        int procCount = Runtime.getRuntime().availableProcessors();
        List<Calc> list = new ArrayList<>();
        Calc calc;
        int p = 0;
        int partSize = arr.length / procCount;

        // #1
        Arrays.fill(arr, 1);
        long tm1 = System.currentTimeMillis();

        for (int i = 0; i < procCount; i++) {
            calc = new Calc(arr, p, p += partSize);
            list.add(calc);
            calc.start();
        }

        long sum = 0;
        for (Calc c : list) {
            c.join();
            sum += c.getSum();
        }

        System.out.println("Sum1 = " + sum);
        System.out.println("Time1 = " + (System.currentTimeMillis() - tm1));

        // #2
        tm1 = System.currentTimeMillis();
        sum = 0;

        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        System.out.println("Sum2 = " + sum);
        System.out.println("Time2 = " + (System.currentTimeMillis() - tm1));
    }
}
