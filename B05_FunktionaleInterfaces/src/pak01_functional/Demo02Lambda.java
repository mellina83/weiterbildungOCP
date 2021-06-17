package pak01_functional;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

interface I02Functional01 {
	public abstract int berechne(int i);
}

interface I02Functional02 {
	public abstract int berechne(int i, int j);
}

interface I02Functional03 extends I02Functional01{
//	void go();
}
public class Demo02Lambda {
	public static void main(String[] args) {
		demoAnonyme();
		demoLambda();		
		
		takesFunctional(zahl->zahl+zahl, 100);
		takesFunctional(zahl->zahl*zahl, 200);
		
		takesAL(e->{System.out.println("Lambda Al");});
		takesAL(e->{System.out.println("Lambda Al die zweite");});
		
		System.out.println(returnsLambda(100).berechne(10));
	}

	private static void demoLambda() {
		System.out.println("Lambda Beispiele");

		I02Functional01 calc01;
		I02Functional02 calc02;
		
		calc01 = (int i) -> {return i + i;};
		calc01 = i -> i + i;
				
		System.out.println(calc01);
		int ergebnis = calc01.berechne(10);
		System.out.println(calc01.berechne(10));
		
		calc02 = (int i, int j) -> {return i + j;};
		System.out.println(calc02.berechne(10, 20));
		
		I02Functional03 calc03 = i -> 10;
		
	}

	private static void demoAnonyme() {
		System.out.println("Anonyme Beispiele");

		I02Functional01 calc01;
		I02Functional02 calc02;

		calc01 = new I02Functional01() {
			@Override
			public int berechne(int i) {
				return i + i;
			}
		};

		calc02 = new I02Functional02() {
			@Override
			public int berechne(int i, int j) {
				return i + j;
			}
		};
		System.out.println(calc01.berechne(10));
		System.out.println(calc02.berechne(10, 20));
	}
	
	
	public static void takesFunctional(I02Functional01 func, int wert) {
		System.out.println(func.berechne(wert));
	}
	
	public static void takesAL(ActionListener al) {
		//Wird ausgefuehrt, wenn der Button gedrueckt wird
		al.actionPerformed(new ActionEvent(new JButton(), 1, ""));
	}
	
	public static I02Functional01 returnsLambda(int wert) {
		return i -> i+wert;
	}

}
