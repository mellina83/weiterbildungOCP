package pattern.adapter;

import pattern.adapter.csv.CSV_Lib;
import pattern.adapter.json.Json_Lib;
import pattern.adapter.xml.XML_Lib;

enum EProvider {
	XML, JSON, CSV
}

public class DataProvider {
	private XML_Lib xmlProvider;
	private Json_Lib jsonProvider;
	private CSV_Lib csvProvider;

	public DataProvider(EProvider provider) {
		switch (provider) {
		case XML:
			this.xmlProvider = new XML_Lib();
			break;
		case JSON:
			this.jsonProvider = new Json_Lib();
			break;
		case CSV:
			this.csvProvider = new CSV_Lib();
			break;
		}
	}
	
	public String readFromFile() {
		if(this.xmlProvider != null) {
			return this.xmlProvider.readFromXMLFile();
		}else if(this.jsonProvider != null) {
			return this.jsonProvider.readFromJsonFile();
		}else {
			return this.csvProvider.readFromCSVFile();
		}
	}
	
	public boolean writeToFile(String tmp) {
		if(this.xmlProvider != null) {
			return this.xmlProvider.writeToXMLFile(tmp);
		}else if(this.jsonProvider != null) {
			return this.jsonProvider.writeToJsonFile(tmp);
		}else {
			return this.csvProvider.writeToCSVFile(tmp);
		}
	}

}
