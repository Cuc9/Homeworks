package lesson7.test.genericsTtest;

/**
 * Created by arpi on 30.04.2016.
 */
public class Camera extends Product<Camera> {
    Integer pixel;

    public Integer getPixel() {
        return pixel;
    }

    public void setPixel(Integer pixel) {
        this.pixel = pixel;
    }

    @Override
    int subCompare(Camera p) {
        return 0;
    }
}
