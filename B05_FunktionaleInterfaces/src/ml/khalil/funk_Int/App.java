package ml.khalil.funk_Int;

import java.util.Arrays;
import java.util.Comparator;

public class App {
public static void main(String[] args) {
		
		
		String[] arr = { "achtzehnbuchstaben", "dry", "vier", "1", "fuenf",
				"neunzehn Buchstaben", };
		sortMitlambda(arr);
		sortMitAnonym(arr);
		
	}
public static void sortMitlambda(String [] arr)
{Comparator<String> cI=(x,y)->{if(x.length()<y.length())
                                         return -1;
                              else return x.length()-y.length();};
Arrays.sort(arr, cI );
for(String s:arr)
System.out.println(s);}

public static void sortMitAnonym(String [] arr)
{Comparator<String> c=new Comparator<String>() {
	
	@Override
	public int compare(String o1, String o2) {
		if(o1.length()<o2.length())
            return -1;
     else return o1.length()-o2.length();
	}
}; 
Arrays.sort(arr, c);
System.out.println("----------------------------------------------------");
for(String s:arr)
System.out.println(s);}

}

