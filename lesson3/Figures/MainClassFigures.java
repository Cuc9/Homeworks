package lesson3.Figures;

/**
 * Created by arpi on 02.02.2016.
 */
public class MainClassFigures {
    public static void main(String[] args) {

        Figure[] list = {
                new Circle(2.5),
                new Rectangle(10,5),
                new Triangle(10,5,11),
                new Circle(7),
                new Rectangle(12,3),
                new Triangle(10,8,11),
                new Circle(6.5),
                new Rectangle(2,15),
                new Triangle(8,5,11),
        };

        for (Figure figura:list){
            if (figura instanceof Circle){
                figura.setNmae("KPYG");
            } else if (figura instanceof Rectangle){
                figura.setNmae("PRAMOUG");
            } else if (figura instanceof Triangle){
                figura.setNmae("TPEYG");
            }
            System.out.print(figura.getName() + " square is ");
            System.out.printf("%.2f", figura.square());
            System.out.println();
        }
    }
}
