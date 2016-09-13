package lesson7.test.genericsTtest;

/**
 * Created by arpi on 30.04.2016.
 */
public abstract class Product <T extends Product<T>> implements Comparable<T> {
    String name;
    Integer price;

    @Override
    public int compareTo(T o) {
        return this.price-o.price;
    }

    abstract int subCompare (T p);

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
