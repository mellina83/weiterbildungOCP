package ml.khalil.Kaffeeautomat;
import java.util.Scanner;
public class App {
	Kaffeesorten sort;
	public static void main(String[] args) {
		new App().verkaufen();
	}
	public void verkaufen() {
		double sum=0;String  geld;
		Kaffeesorten [] sorten=Kaffeesorten.values();
		for(Kaffeesorten k:sorten) {
			System.out.println(k + " : "+ k.getPreis()+"Euro. Die Nummer ist: "+k.getNum());
		}
		System.out.println("Bitte die Nummer von der gew�nschten Sorte ausw�hlen");	
		Scanner sc=new Scanner(System.in);
		String getraenk=sc.nextLine();
		switch(getraenk.toUpperCase())
		{case "1":sort=Kaffeesorten.KAFFEE; System.out.println("Bitte die M�nzen einwerfen: "+ "1 Euro");break;
		case "2":sort=Kaffeesorten.CAPPUCCINO; System.out.println("Bitte die M�nzen einwerfen: "+ "1.20 Euro");break;
		case "3": sort=Kaffeesorten.ESPRESSO;System.out.println("Bitte die M�nzen einwerfen: "+ "1.13 Euro");break;
		default:System.out.println("Sie haben eine falsche Nummer eingegeben");
		}
		
		System.out.println("Wenn Sie bezahlen m�chten ,dr�cken Sie auf ja");
		if(sc.next().equalsIgnoreCase("ja"))

{
		M�nzentypen[] muenzen=M�nzentypen.values();
		for(M�nzentypen x:muenzen)
		{System.out.println(x +"  dr�cken Sie bitte auf "+ x.getNum());}
	}
		geld=sc.next();
		while(!geld.equalsIgnoreCase("ende"))
			{// sum +=Integer.parseInt(geld);
			switch(geld) {
			case "1":sum+=1;break;
			case "2":sum+=2;break;
			case "3":sum+=5;break;
			case "4":sum+=10;break;
			case "5":sum+=20;break;
			case "6":sum+=50;break;
			case "7":sum+=100;break;
			case "8":sum+=200;break;
			
			};
			geld=sc.next();}
	if(sum<sort.getPreis()*100)
	{System.out.println("Das reicht nicht "); }
	else if(sum == sort.getPreis()*100)
		System.out.println("Sie haben "+ sort +"bestellt .Das R�ckgeld ist 0");
	else System.out.println("Das R�ckgeld ist "+(sum -sort.getPreis()*100)/100);
sc.close();
}
} 
