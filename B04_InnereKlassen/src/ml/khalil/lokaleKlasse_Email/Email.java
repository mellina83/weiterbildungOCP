package ml.khalil.lokaleKlasse_Email;

public class Email {
	 String empfaenger;
     String absender;
	 String betreff;
	 String text;
	 
	public Email(String empfaenger, String absender, String betreff, String text) {

		this.empfaenger = empfaenger;
		this.absender = absender;
		this.betreff = betreff;
		this.text = text;
	}
	void senden() {
		class InternetMailAddress{
			private boolean isValid (String address) {

				  if (address.matches("[a-z A-Z 0-9_\\.]+[@][a-z]+[\\.][a-z]{2,3}"))
					  return true;
				    
				  else if(address.matches("[a-z A-Z 0-9_\\.]+[*]")) 
				  {if(address.matches(absender)) 
					  absender=absender.substring(0, absender.length()-1).concat("@it-designers.de");
				  else empfaenger=empfaenger.substring(0, empfaenger.length()-1).concat("@it-designers.de");
				     return true;}
				
				    else
				    return false;}}
		InternetMailAddress in =new InternetMailAddress();
		
		if(in.isValid(empfaenger))
		{	if(in.isValid(absender))
			    System.out.println("Mail von: "+absender +" \n"+"An: "+empfaenger+"\nBetreff: "+betreff+"\nText: "
					+ text);
		      else {System.out.println("Die Email konnte nicht verschickt werden!");
				  System.out.println("Die Email-Adresse des Absenders ist ungültig.");}
		}
		else {System.out.println("Die Email konnte nicht verschickt werden!");
		System.out.println("Die Email-Adresse des Empfängers ist ungültig.");}
	}

}
