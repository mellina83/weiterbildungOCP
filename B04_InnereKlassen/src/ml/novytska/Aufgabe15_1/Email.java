package ml.novytska.Aufgabe15_1;

public class Email {
	
	String empfaenger;
	String absender;
	String betreff;
	String text;
	public Email(String empfaenger, String absender, String betreff, String text) {
		super();
		this.empfaenger = empfaenger;
		this.absender = absender;
		this.betreff = betreff;
		this.text = text;
	}
	void senden(){
		
		class InternetMailAdress{
		private	boolean isValid(String adress){
			if((adress.charAt(0))=='@' || (adress.charAt(0)=='*' || !adress.matches("(.*)@(.*)"))) {
				return false;
			}else {
				char [] adr = adress.toCharArray();
				for(char ch : adr) {
					if(!Character.isAlphabetic(ch) && !Character.isDigit(ch) && ch != '@' && ch != '_'  && ch != '*'  && ch != '.'){
						return false;
					}
				}
				return true;
			}}
		}
		InternetMailAdress ima = new InternetMailAdress();
		if (ima.isValid(getAbsender())) {
			if(getEmpfaenger().charAt(getEmpfaenger().length()-1) == '*'){
				empfaenger = empfaenger.replace("*", "it-designers.de");
			}
			System.out.println("---------------------------------------------");
			System.out.println("Mail von :  " + getAbsender());
			System.out.println("An       :  " + getEmpfaenger());
			System.out.println("Betreff  :  " + getBetreff());
			System.out.println("Text     :  " + getText());
		}else{
			System.out.println("----------------------------------------------");
			System.out.println("Die Email konnte nicht verschickt werden!");
			System.out.println("Die Email-Adresse des Absenders ist ungueltig!");
		}
	}
	
	
	public String getEmpfaenger() {
		return empfaenger;
	}
	
	public String getAbsender() {
		return absender;
	}
	
	public String getBetreff() {
		return betreff;
	}
	
	public String getText() {
		return text;
	}
	

	
}
