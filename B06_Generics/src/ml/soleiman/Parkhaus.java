package ml.soleiman;

import java.util.ArrayList;
import java.util.List;

public class Parkhaus<T extends Fahrzeug> {

	public List<T> fahrzeugePH;

	Parkhaus() {
		fahrzeugePH = new ArrayList<>();
	}
		
	public void parken(List<T>... fahrzeugeWaschstrasse) {
		for (List<T> list : fahrzeugeWaschstrasse) {
			this.fahrzeugePH.addAll(list);
			list.clear();
		}
	}
}
