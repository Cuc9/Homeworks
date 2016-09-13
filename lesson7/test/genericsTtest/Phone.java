package lesson7.test.genericsTtest;

/**
 * Created by arpi on 30.04.2016.
 */
public class Phone extends Product<Phone> {
    String model;

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    int subCompare(Phone p) {
       return 0;
    }
}
