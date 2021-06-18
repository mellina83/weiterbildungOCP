package ml.mauerbach.aufgabe_15_3;
import java.util.List;
import java.util.ArrayList;
public class CdListe{
	String archivTitel;
	int maxAnzahl;
	List<Cd> cdList;
	public CdListe (String archivTitel, int maxAnzahl){
		this.archivTitel=archivTitel;
		this.maxAnzahl=maxAnzahl;
		cdList = new ArrayList<Cd>();
	} 
	public void cdHinzufuegen (String cdTitel, String kuenstler,int jahr){
		if(cdList.size()<maxAnzahl){
			cdList.add(new Cd(cdTitel,kuenstler,jahr));
		}
	} 
	public void listeAnzeigen(){
		System.out.println(archivTitel);
		System.out.println();
		for(Cd cd:cdList){
			System.out.println(cd);
		}
		System.out.println();
	}
	class Cd{
		String cdTitel;
		String kuenstler;
		int jahr;
		public Cd(String cdTitel,String kuenstler,int jahr){
			this.cdTitel=cdTitel;
			this.kuenstler=kuenstler;
			this.jahr=jahr;
		}
		public String toString(){
			return cdTitel+", "+kuenstler+", "+jahr;
		}
	}
}
