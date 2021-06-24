package pak02_equals_hashcode.eq_hc;

public class ArtikelMitEq_HC {
	private String artNr;
	private String name;
	
	public ArtikelMitEq_HC(String artNr, String name) {
		this.artNr = artNr;
		this.name = name;
	}

	@Override
	public String toString() {
		return "ArtikelMitEq_HC [artNr=" + artNr + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artNr == null)? 0 : artNr.hashCode());
		result = prime * result + ((name == null)? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		/**
		 * Reflexive
		 */
		if(this == obj) {
			return true;
		}
		/**
		 * Non-null zu null
		 */
		if(obj == null) {
			return false;			
		}
		/**
		 * Symmetric
		 */
		if(this.getClass() != obj.getClass()) {
			return false;			
		}
		
		ArtikelMitEq_HC other = (ArtikelMitEq_HC) obj;
		/**
		 * Vergleich Artikelnummer
		 */
		if(artNr == null) {
			if(other.artNr != null) {
				return false;
			}
		}else if(!artNr.equals(other.artNr)) {
			return false;			
		}
		/**
		 * Vergleich Name
		 */
		if(name == null) {
			if(other.name != null) {
				return false;
			}
		}else if(!name.equals(other.name)) {
			return false;			
		}
				
		return true;
	}
}
