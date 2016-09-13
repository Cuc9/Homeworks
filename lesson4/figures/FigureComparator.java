package lesson4.figures;

import java.util.Comparator;

public class FigureComparator implements Comparator {
	
	@Override
	public int compare(Object o1, Object o2){
		Figure f1 = (Figure)o1;
		Figure f2 = (Figure)o2;
				
		if (f1.square()>f2.square()){
    		return 1;
    	} else if (f1.square()<f2.square()){
    		return -1;
    	} else return 0;
   
	}
}
