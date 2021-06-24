package pak02_equals_hashcode.interfaces;

public class Artikel implements Comparable<Artikel>{
//public class Artikel{
	private String artNr;
	private String name;

	public Artikel(String artNr, String name) {
		this.artNr = artNr;
		this.name = name;
	}

	public String getArtNr() {
		return artNr;
	}

	public void setArtNr(String artNr) {
		this.artNr = artNr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artikel [artNr=" + artNr + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Artikel o) {		
		return this.getName().compareTo(o.getName());
//		return this.getArtNr().compareTo(o.getArtNr());
	}
	
	
}
