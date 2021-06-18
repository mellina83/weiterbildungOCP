package ml.mauerbach.aufgabe_15_4;

public class TestObst{
  public static void main(String[] args){
    Obst obst1 = new Apfel(9);
    Obst.Obstmengenausgabe.print (obst1);
    Obst.staticPrint(obst1);
    obst1.print();
    
    Obst obst2 = new Birne(7);
    Obst.Obstmengenausgabe.print (obst2);
    Obst.staticPrint(obst2);
    obst2.print();
    
    Object o = new Apfel(13);
    ((Obst)o).print();
  }
}
