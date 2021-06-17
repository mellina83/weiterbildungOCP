package ml.soleiman;

public class Email {
	private String betreff, text, empfaenger, absender;

	Email(String empfaenger, String absender, String betreff, String text) {
		this.empfaenger = empfaenger;
		this.absender = absender;
		this.betreff = betreff;
		this.text = text;
	}

	public String toString() {
		String str = "------------------------------------";
		str += "\nMail von: " + this.absender;
		str += "\nAn: " + this.empfaenger;
		str += "\nBetreff: " + this.betreff;
		str += "\nText:\n" + this.text;
		str += "\n------------------------------------";
		return str;
	}

	void senden() {

		class InternetMailAddress {
			
			private boolean isValid(String address) {

				boolean b1 = address.matches("^[a-zA-Z0-9_.]+[@]{1}[a-zA-Z0-9_.]+$"); 	// nur gültige Zeichen und genau ein @-Zeichen
				boolean b2 = address.matches("[a-zA-Z0-9_.]+[*]$"); 					// nur gültige Zeichen und das letztes Zeichen ein *

				if (b2) {
					if (address.equals(absender)) {
						Email.this.absender = address.replaceAll("\\*", "@it-designers.de");
					} else if (address.equals(empfaenger)) {
						Email.this.empfaenger = address.replaceAll("\\*", "@it-designers.de");
					}
				}

				return b1 || b2;
			}
		}

		InternetMailAddress ima = new InternetMailAddress();

		if (ima.isValid(absender)) {
			if (ima.isValid(empfaenger)) {
				System.out.println(this.toString());
			} else {
				System.out.println("Die Email konnte nicht verschickt werden!");
				System.out.println("Die Email-Adresse des Empfänger ist ungültig.\n");
			}
		} else {
			System.out.println("Die Email konnte nicht verschickt werden!");
			System.out.println("Die Email-Adresse des Absenders ist ungültig.\n");
		}
	}
}
