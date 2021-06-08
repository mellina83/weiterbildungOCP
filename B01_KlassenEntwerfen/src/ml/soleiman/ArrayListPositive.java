package ml.soleiman;

import java.util.ArrayList;

public class ArrayListPositive extends ArrayList {

	@Override
	public boolean add(Object o) {

		if (o == null) {
			throw new NullArgumentException("NULL ist nicht erlaubt!");
		}
		if (o instanceof Integer) {
			if (((Integer) o).intValue() <= 0) {
				throw new NotPositiveArgumentException("Die Zahl muss größer als 0 sein!");
			}
			super.add(o);
			return true;
		}
		System.out.println("Es sind nur Integer erlaubt, \"" + o + "\" ist kein Integer!");
		return false; // kein Integer Objekt
	}
	
	@Override
	public void add(int index, Object o) {
		
		if(this.add(o)) {
			super.add(index,o);
		} 
	}

	public static void main(String[] args) {
		
		ArrayListPositive arr1 = new ArrayListPositive();
		
		for(int i = 1; i < 10; i++) {
			arr1.add( i );
		}
//		arr1.add(-1);
//		arr1.add(0);
//		arr1.add(null);
//		arr1.add(25.1);
//		arr1.add("hallo");
//		arr1.add(3, 55.1);
		arr1.add(2, 100);
		System.out.println(arr1);
	
	}
}




