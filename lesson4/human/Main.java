package lesson4.human;

import java.util.Arrays;

/**
 * Created by arpi on 11.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Human[] list = {
                new Human(40), new Human(20), new Human(3), new Human(7)
        };
        Arrays.sort(list, (h1,h2) -> h2.getAge() - h1.getAge()); // lambda expression
        for (Human h : list)
            System.out.println(h.getAge());
    }
}
