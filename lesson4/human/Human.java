package lesson4.human;

/**
 * Created by arpi on 11.02.2016.
 */
class Human implements Comparable {
    private int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int compareTo(Object human2){
        Human h = (Human) human2;
        return age - h.age;
    }

}
