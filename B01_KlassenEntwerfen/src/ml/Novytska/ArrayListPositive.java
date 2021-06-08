package ml.Novytska;
import java.util.*;

public class ArrayListPositive extends ArrayList{
	
	  public boolean add(Object e) throws RuntimeException{
	       if(e == null) {
	    	   throw new NullArgumentExeption("Alarm!!! Die Werte duerfen nich null sein!!!");
	       }else if(e instanceof Integer) {
	    	   if((Integer)e==0) {
	    		  throw new NotPositiveArgumentExeption("Alarm!!! Sie duerfen keine 0(Zero)-Werte in einer ArrayList hinzufuegen."); 
	    	   }else if((Integer)e < 0) {
	    		   throw new NotPositiveArgumentExeption("Alarm!!! Sie duerfen keine negative-Werte in einer ArrayList hinzufuegen.");  
	    	   }
	    	   return super.add(e);
	       }
	       return false;
	        
	    }

	
}
