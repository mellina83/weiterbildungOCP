package pak02_equals_hashcode.interfaces.comparator;

import java.util.Comparator;

import pak02_equals_hashcode.interfaces.Artikel;

public class CompareArtikelNachArtNr implements Comparator<Artikel>{

	@Override
	public int compare(Artikel o1, Artikel o2) {		
		return o1.getArtNr().compareTo(o2.getArtNr());
	}

}
