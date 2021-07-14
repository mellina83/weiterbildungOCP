package demo01;

public class Autor {

	private String name;
	private String vorname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public Autor() {
		this("Inden","Michael");
	}
	
	public Autor(String name,String vorname) {
		this.setName(name);
		this.setVorname(vorname);
	}
	
	@Override
	public String toString() {
		return "Autor [name=" + name + ", vorname=" + vorname + "]";
	}
 
}
