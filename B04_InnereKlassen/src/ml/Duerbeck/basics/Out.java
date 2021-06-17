package ml.Duerbeck.basics;

import java.awt.Point;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

class Out {
		
	Point myPoint = new Point(10,20) {
		

		
		@Override
		public String toString() {
			return getClass().getName() + " y= " + y + ", x= " + x;
		}
//		public Point() {
//			
//		}
		@Override
		public double getX() {
	        return x*2;
	    }
		
		public double quote() {
			return(double)x/y;
		}
		
	};
	
	public void useAnoClass() {
		System.out.println(myPoint);
	}
	public static void main(String[] args) {
		Testen.testen();
		Out out = new Out();
		out.useAnoClass();
		System.out.println(out.myPoint.x);
		System.out.println(out.myPoint.getX());
		
//		The method quote() is undefined for the type Point
//		out.myPoint.quote();
		
		//Zugriff auf quote() mit Hilfe eines anonymen Objektes
		double zahl = new Point(10,20) {
			public double quote() {
				return(double)x/y;
			}
		}.quote();
		System.out.println(zahl);
		
		//----------------------Nicht Pruefungsrelevant-----------------------------
		Class c = out.myPoint.getClass();
		Method[] methods = c.getDeclaredMethods();
		for(Method m : methods) {
			try {
				System.out.println("Invoke the Method: " + m.getName() + " = " + m.invoke(out.myPoint));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		
	}
}

class Testen {
	
	static void testen() {
		Out out1 = new Out();
		System.out.println(out1.myPoint);
		
	}
}
