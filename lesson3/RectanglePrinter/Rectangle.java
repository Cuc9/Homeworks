package lesson3.RectanglePrinter;

import java.util.Scanner;

/**
 * Created by arpi on 06.02.2016.
 */
public class Rectangle {
    private Element[][] rect;


    public Rectangle() {
        int width = 0, height = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter width");
        if (sc.hasNextInt()) {
            width = sc.nextInt();
            if (width < 2) {
                throw new RuntimeException("Неверный ввод, ширина не может быть меньше 2!");
            }
        }
        System.out.println("Enter height");
        if (sc.hasNextInt()) {
            height = sc.nextInt();
            if (height < 2) {
                throw new RuntimeException("Неверный ввод, длина не может быть меньше 2!");
            }
        }

        this.rect = new Element[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0) && (j == 0)) rect[i][j] = new LeftTopCorner();
                if ((i == height - 1) && (j == width - 1)) rect[i][j] = new RightBottomCorner();
                if ((i == 0) && (j == width - 1)) rect[i][j] = new RightTopCorner();
                if ((i == height - 1) && (j == 0)) rect[i][j] = new LeftBottomCorner();
                if ((j == 0) && (i > 0) && (i < height - 1)) rect[i][j] = new VerticalElement(false);
                if ((j == width - 1) && (i > 0) && (i < height - 1)) rect[i][j] = new VerticalElement(true);
                if (((i == 0) && (j > 0) && (j < width - 1)) || ((i == height - 1) && (j > 0) && (j < width - 1)))
                    rect[i][j] = new GorizontalElement();
                if ((i > 0) && (i < height - 1) && (j > 0) && (j < width - 1)) rect[i][j] = new EmptyElement();
            }
        }
        /*System.out.println('\u250C'); // - lefttop
        System.out.println('\u2510'); // - righttop
        System.out.println('\u2514'); // - leftbottom
        System.out.println('\u2518'); // - rightbottom
        System.out.println('\u2500'); // - horizont
        System.out.println('\u2502'); // - vertical*/
    }

    public void printRectangle() {
        Element[][] rectangle = rect;
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i].length; j++) {
                rectangle[i][j].printElem();
            }
        }

    }
}

