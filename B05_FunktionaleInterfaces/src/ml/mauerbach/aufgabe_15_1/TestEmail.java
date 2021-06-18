package ml.mauerbach.aufgabe_15_1;
public class TestEmail{
  public static void main (String[] args){
    Email e1 = new Email("Klaus.Gross*","Lotte.Klein@gmz.de","Hallo","Hallo Welt");
    e1.senden();
    Email e2 = new Email("Klaus.Gross*","Lotte.Kleingmz.de","Hallo","Hallo Welt");
    e2.senden();
    Email e3 = new Email("Klaus.Gross@bla.de","Lotte.Kleingmz.de","Hallo","Hallo Welt");
    e3.senden();
  }
}
