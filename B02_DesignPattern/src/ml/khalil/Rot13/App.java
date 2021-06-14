package ml.khalil.Rot13;

import java.util.Scanner;

public class App {
	char[] orginalB=new char [] {'A','B','C','D','E' ,'F','G', 'H', 'I' ,'J', 'K' ,'L','M', 'N','O',
			'P','Q' ,'R','S' ,'T', 'U', 'V', 'W' ,'X', 'Y' ,'Z', 'a', 'b', 'c' ,'d' ,'e', 'f', 'g' ,'h', 'i', 'j', 'k','l' ,
			'm', 'n', 'o', 'p', 'q','r' ,'s', 't', 'u' ,'v' ,'w', 'x' ,'y' ,'z'  };
	char[] verschlüesseltB=new char [] {'N','O', 'P', 'Q', 'R', 'S' ,'T','U', 'V', 'W', 'X',
			'Y', 'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L' ,'M', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 
			'z', 'a', 'b', 'c' ,'d', 'e', 'f', 'g', 'h' ,'i', 'j', 'k', 'l','m'};
	public static void main(String[] args) {
		//new App().grossVER();
		new App().kleinUndGrosVER();
	}
	public void grossVER() {
		Scanner sc=new Scanner(System.in);
		
		String s=sc.nextLine();
		char[] ausgabe=new char [s.length()];
		for(int i=0;i<s.length();i++)
		      {char c=s.charAt(i);
		      
			   if (c>='A'&& c<='Z') {
			         for(int j=0;j<orginalB.length;j++)
			             {
			        	 if(c==orginalB[j])
				            ausgabe[i]=verschlüesseltB[j];
			              }
		       }else {ausgabe[i]=c;continue;}
			}
		for(int i=0;i<s.length();i++)
			System.out.print(ausgabe[i]);
		sc.close();
	}
	public void kleinVER() {
Scanner sc=new Scanner(System.in);
		
		String s=sc.nextLine();
		char[] ausgabe=new char [s.length()];
		for(int i=0;i<s.length();i++)
		      {char c=s.charAt(i);
		      
			   if (c>='a'&& c<='z') {
			         for(int j=0;j<orginalB.length;j++)
			             {
			        	 if(c==orginalB[j])
				            ausgabe[i]=verschlüesseltB[j];
			              }
		       }else {ausgabe[i]=c;continue;}
			}
		for(int i=0;i<s.length();i++)
			System.out.print(ausgabe[i]);
		sc.close();
}
	public void kleinUndGrosVER() {
Scanner sc=new Scanner(System.in);
		
		String s=sc.nextLine();
		char[] ausgabe=new char [s.length()];
		for(int i=0;i<s.length();i++)
		      {char c=s.charAt(i);
	
			     for(int j=0;j<orginalB.length;j++)
			             {
			        	 if(c==orginalB[j])
				            ausgabe[i]=verschlüesseltB[j];
			              }
		     
			}
		for(int i=0;i<s.length();i++)
			System.out.print(ausgabe[i]);
		sc.close();
		
	}}
