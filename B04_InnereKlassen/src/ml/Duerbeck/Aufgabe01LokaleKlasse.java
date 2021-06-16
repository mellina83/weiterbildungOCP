package ml.Duerbeck;

public class Aufgabe01LokaleKlasse {

	public static void main(String[] args) {
		Email e1 = new Email ("Klaus.Gross*","Lotte.Klein@gmz.de",
				"Hallo","Hallo Welt");
				e1.senden();
				Email e2 = new Email ("Klaus.Gross*","Lotte.Kleingmz.de",
				"Hallo","Hallo Welt");
				e2.senden();
				
				

	}

}

class Email {
	
	String betreff;
	String text;
	String empfaenger;
	String absender;
	
	public String getBetreff() {
		return betreff;
	}
	public void setBetreff(String betreff) {
		this.betreff = betreff;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getEmpfaenger() {
		return empfaenger;
	}
	public void setEmpfaenger(String empfaenger) {
		this.empfaenger = empfaenger;
	}
	public String getAbsender() {
		return absender;
	}
	public void setAbsender(String absender) {
		this.absender = absender;
	}

	public Email(String betreff, String text, String empfaenger, String absender) {
		this.setBetreff(betreff);
		this.setText(text);
		this.setEmpfaenger(empfaenger);
		this.setAbsender(absender);
	}
	
	public void senden() {
		
		class InternetMailAdress {
			
			private boolean isValid(String address) {
				if (address.matches("@")){
					
				}
				
				return true;
			}
			
		}
		

		
	}
}
