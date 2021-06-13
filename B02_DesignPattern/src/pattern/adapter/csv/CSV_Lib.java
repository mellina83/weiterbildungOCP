package pattern.adapter.csv;

public class CSV_Lib {
	
	public String readFromCSVFile() {
		return "CSV from File";
	}
	
	public boolean writeToCSVFile(String...strings) {
		System.out.println(strings[0] + " wurde in CSV gespeichert");
		return true;
	}
}
