package pattern.adapter;

public class App {
	public static void main(String[] args) {
		DataProvider prov1 = new DataProvider(EProvider.CSV);
		DataProvider prov2 = new DataProvider(EProvider.JSON);
		DataProvider prov3 = new DataProvider(EProvider.XML);
		
		prov1.writeToFile("CSV Provider text");
		prov2.writeToFile("JSON text");
		prov3.writeToFile("XML Text");
		
		System.out.println(prov1.readFromFile());
		System.out.println(prov2.readFromFile());
		System.out.println(prov3.readFromFile());
		
	}
}
