package lesson1;

import java.util.FormatFlagsConversionMismatchException;

/**
 * Created by arpi on 30.01.2016.
 */
public class Circle {
    // �� �� ������ math ����� ������������ ������ ��������� ��� ���� ������
    // ������ ������ ������ ��� ������������ ������ ������ �����
    public static final double PI = Math.PI;
    private double radius;

    private Circle() {
        this.radius = 0;
    }

    private Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 0;
        }
    }

    public double getRadius (){
        return radius;
    }

    public void setRadius (double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            this.radius = 0;
        }
    }

    public double circleSquare (){
        return PI * this.radius * this.radius;
        // return Math.pow(this.radius,2) * Math.PI;
    }

    public static class CircleCounter {
        private static int counter = 0;

        public static int getCounter (){
            return counter;
        }

        public static Circle circleCreation (){
            Circle c = new Circle();
            counter ++;
            return c;
        }

        public static Circle circleCreation (double radius){
            Circle c = new Circle(radius);
            counter ++;
            return c;
        }
    }

    public static void main(String[] args) {
        Circle circle1 = CircleCounter.circleCreation(); // Circle circle1 = new Circle();
        System.out.println("Hello, default circle radius is " + circle1.getRadius() + ", square is " + circle1.circleSquare() + ".");
        System.out.println("Number of circles is " + CircleCounter.getCounter() + ".");
        System.out.println("Changing radius to -5 (supposed 0 value)");
        circle1.setRadius(-5);
        System.out.println("New circle radius is " + circle1.getRadius() + ", square is " + circle1.circleSquare() + ".");
        System.out.println("Number of circles is " + CircleCounter.getCounter() + ".");
        Circle circle2 = CircleCounter.circleCreation(5.0); // Circle circle2 = new Circle(5.0);
        System.out.println("Second circle. Radius is " + circle2.getRadius() + ", square is " + circle2.circleSquare() + ".");
        System.out.println("Number of circles is " + CircleCounter.getCounter() + ".");
        do {
            CircleCounter.circleCreation();
        } while (CircleCounter.getCounter() < 10);
        System.out.println();
        System.out.println(CircleCounter.getCounter() + " circles was created.");
    }
}
