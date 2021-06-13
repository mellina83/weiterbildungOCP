package pattern.adapter.json;

public class Json_Lib {
	public String readFromJsonFile() {
		return "From Json File";
	}
	
	public boolean writeToJsonFile(String...strings) {
		System.out.println(strings[0] + " wurde in Json gespeichert");
		return true;
	}
}
