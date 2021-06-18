package ml.mauerbach.aufgabe_15_1;

class Email{
  String empfaenger;
  String absender;
  String betreff;
  String text;

  public Email(String empfaenger,String absender,String betreff,String text){
    this.empfaenger = empfaenger;
    this.absender   = absender;
    this.betreff    = betreff;
    this.text       = text;
  }

  public void senden(){
    class InternetMailAddress{
      private boolean isValid(String adresse){
        return adresse.matches("[^@]+[@][^@]+");
      }
    }
    if(new InternetMailAddress().isValid(this.empfaenger)) {
    	print();
    }else{
    	System.out.println(this.empfaenger);
    	error();
    }
  }

  private void print(){
    System.out.println("-----------------------------------------------");
    System.out.println("Mail von: "+absender);
    System.out.println("An: "+empfaenger);
    System.out.println("Betreff: "+betreff);
    System.out.println("Text:");
    System.out.println(text);
    System.out.println("-----------------------------------------------"); 
  }

  private void error(){
    System.out.println("Die Email konnte nicht verschickt werden!");
    System.out.println("Die Email-Adresse des Absenders ist ungueltig.");
  }
  }