package ml.duerbeck.basics;

public class RethrowException {
	  
	   
	   public static void main(String[] args) throws Throwable {
	      try {
	    	  throw new Exception("Bla");
	      } catch(Exception e) {
	         System.out.println("Caught in main");
	         throw e;
	      }
	   }
	}