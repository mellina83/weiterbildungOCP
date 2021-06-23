package ml.khalil.generics_01;

import java.util.ArrayList;
import java.util.List;

public class Waschstrasse<T extends Fahrzeug> {
	private List<T> waschstrasse_list;
	private Parkhaus< Fahrzeug> p;
	
	public Waschstrasse(Parkhaus< Fahrzeug> p) {
		waschstrasse_list=new ArrayList<>();	
		this.p=p;
	}
	void add(T fahrzeug) {
		if(fahrzeug.isZustand()==true)
			waschstrasse_list.add(fahrzeug);
		
		else p.add(fahrzeug);	
	

	}
	public T get(int index) {
		return waschstrasse_list.get(index);
	}

	public void waschen() {
		T x;
		for(int i=waschstrasse_list.size()-1;i>=0;i--)
		{ 
		      x =get(i);
		      x.setZustand(false);
		      p.add(x);
		      }
	}
	@Override
	public String toString() {
		return "Waschstrasse [waschstrasse_list=" + waschstrasse_list + "]";
	}

}
