package lesson2.Sumka;

/**
 * Created by arpi on 01.02.2016.
 */
public class Bag {
    protected int leng;
    protected int wide;
    protected int deep;
    protected String material;

    public Bag(int leng, int wide, int deep, String material){
        this.leng = leng;
        this.wide = wide;
        this.deep = deep;
        this.material = material;
    }

    public double volume (){
        return leng*wide*deep;
    }
}
