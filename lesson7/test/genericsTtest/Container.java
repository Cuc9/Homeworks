package lesson7.test.genericsTtest;

import java.util.List;

/**
 * Created by arpi on 30.04.2016.
 */
public class Container <T extends Product> {
    T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    void copy(List<? extends Product> src, List<? super Product> dest){
        for (Product p:src){
            dest.add(p);
        }
    }

    public static void main(String[] args) {
        Container <Product> cp = new Container<>();
        //cp.setItem(new Product());
        cp.setItem(new Camera());
        cp.setItem(new Phone());
        Product p = cp.getItem();


        //cp.setItem();
    }
}
