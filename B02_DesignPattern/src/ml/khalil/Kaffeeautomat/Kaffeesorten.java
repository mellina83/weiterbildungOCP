package ml.khalil.Kaffeeautomat;

public enum Kaffeesorten {
	KAFFEE (1 ,1), CAPPUCCINO (1.20,2), ESPRESSO (1.13,3 );
private double preis;
private int num;
	
 Kaffeesorten(double preis,int num) {
	this.preis=preis;
	this.num=num;
	}
 public double getPreis() {
	 return this.preis;
 }
public int getNum() {
	return this.num;
}
}
