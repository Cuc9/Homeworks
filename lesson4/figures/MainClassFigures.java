package lesson4.figures;

import java.util.Arrays;

/**
 * Created by arpi on 02.02.2016.
 */
public class MainClassFigures {
    public static void main(String[] args) {
        Circle circle = new Circle(2.5);
        circle.setNmae("KPYG");
        Rectangle rect = new Rectangle(10,5);
        rect.setNmae("PRAMOUG");
        Triangle trian = new Triangle(10,5,11);
        trian.setNmae("TPEYG");

        System.out.println(circle.getName() + " square is " + circle.square());
        System.out.println(rect.getName() + " square is " + rect.square());
        System.out.println(trian.getName() + " square is " + trian.square());
        System.out.println("Sorted:");
        Figure [] list = {circle, rect, trian};
        Arrays.sort(list, new FigureComparator());
        for (Figure elem:list){
        	System.out.println(elem.getName() + " square is " + elem.square());
        }
    }
}
