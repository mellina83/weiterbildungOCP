package pak01_functional;

class Apfel {
	private int kerne;

	public int getKerne() {
		return kerne;
	}

	public void setKerne(int kerne) {
		this.kerne = kerne;
	}

	public Apfel(int kerne) {
		this.setKerne(kerne);
	}
	
	public void entferneKerne(int kerne) {
		System.out.println("Apfel");
		this.kerne -= kerne;
	}
	
	public void entferneAlleKerne() {
		System.out.println("Apfel");
		this.kerne = 0;
	}

	@Override
	public String toString() {
		return "Apfel [kerne=" + kerne + "]";
	}
	
}

interface Apfelentkerner {
	void entkernen(Apfel apfel, int kerne);
}

public class Demo08_MethodenReferenzUnbestimmtesObjekt {
	public static void main(String[] args) {
		Apfel a1 = new Apfel(200);
		Apfel a2 = new Apfel(500);
		
		Apfelentkerner aeMethode = Apfel::entferneKerne;
		aeMethode.entkernen(a1, 100);
		aeMethode.entkernen(a2, 100);
		
		System.out.println(a1);
		System.out.println(a2);
				
	}
}
