package ml.mauerbach.aufgabe_15_4;

interface Obst{
  String getObstname();
  int getAnzahl();
  static class Obstmengenausgabe{
    static void print(Obst obst){
      System.out.println(obst.getObstname()+": "+obst.getAnzahl());
    }
  }
  static void staticPrint(Obst obst){
    System.out.println(obst.getObstname()+": "+obst.getAnzahl());
  }
  default void print(){
    System.out.println(this.getObstname()+": "+this.getAnzahl());
  }
}

class Apfel implements Obst{
  int anzahl;
  public Apfel(int anzahl){this.anzahl=anzahl;}
  public int getAnzahl(){return anzahl;}
  public String getObstname(){return "Apfel";}
}

class Birne implements Obst{
  int anzahl;
  public Birne(int anzahl){this.anzahl=anzahl;}
  public int getAnzahl(){return anzahl;}
  public String getObstname(){return "Birne";}
}
