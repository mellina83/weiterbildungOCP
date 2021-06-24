package pak02_equals_hashcode.interfaces.comparator;

import java.util.Comparator;

import pak02_equals_hashcode.interfaces.Artikel;

public class CompareArtikelNachAlles implements Comparator<Artikel>{

	@Override
	public int compare(Artikel o1, Artikel o2) {
		int i = o1.getArtNr().compareToIgnoreCase(o2.getArtNr());
		if(i == 0) {
			return o1.getName().compareToIgnoreCase(o2.getName());
		}else {
			return i;
		}
	}

}
