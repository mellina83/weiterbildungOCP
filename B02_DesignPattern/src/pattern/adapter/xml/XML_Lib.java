package pattern.adapter.xml;

public class XML_Lib {
	
	public String readFromXMLFile() {
		return "From XML File";
	}
	
	public boolean writeToXMLFile(String...strings) {
		System.out.println(strings[0] + " wurde in XML gespeichert");
		return true;
	}
}
