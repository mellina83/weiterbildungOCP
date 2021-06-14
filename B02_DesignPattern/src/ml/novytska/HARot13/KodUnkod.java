package ml.novytska.HARot13;
import java.util.*;
public class KodUnkod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Geben Sie einen Text um den zu verschluesseln :  ");
		
		String text = sc.nextLine();
		sc.close();	
		System.out.println("Text :  " + text);
		
	     char [] verschluess = text.toCharArray();
	     StringBuilder vertext = new StringBuilder();
	     for(char  ver :  verschluess) {
	    	 int code = rot13(ver);
	    	 vertext.append((char)code);
	    	 
	     }
	     System.out.println("Text wurde verschluesselt:  " + vertext);
		
	}
	public static int rot13 ( int c ) { 
		  if ( (c >= 'A') && (c <= 'Z') ) 
		    c=(((c-'A')+13)%26)+'A';

		  if ( (c >= 'a') && (c <= 'z') )
		    c=(((c-'a')+13)%26)+'a';

		  return c; 
		}

}
