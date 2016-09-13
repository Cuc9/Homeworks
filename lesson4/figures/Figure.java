package lesson4.figures;

/**
 * Created by arpi on 02.02.2016.
 */
public abstract class Figure implements Comparable<Figure>  {
    private String name;

    public void setNmae (String name) {
        this.name = name;
    }

    public String getName () {
        return this.name;
    }

    public abstract double square ();

    @Override
    public int compareTo (Figure x ){
    	
    	if (this.square()>x.square()){
    		return 1;
    	} else if (this.square()<x.square()){
    		return -1;
    	} else return 0;
    }
}
