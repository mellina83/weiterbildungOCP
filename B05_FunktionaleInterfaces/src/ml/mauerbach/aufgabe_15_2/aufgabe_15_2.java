package ml.mauerbach.aufgabe_15_2;

class Tank{
  private int maxVolumen;
  private int tankinhalt=0;
  private FuellstandSensor fs;

  public Tank(int volumen){
    this.maxVolumen = volumen;
  }

  public void anmeldenFuellstandSensor(FuellstandSensor fs){
    this.fs = fs;
  }

  public int fuellen(){
    tankinhalt++;
    fs.meldeFuellstand(tankinhalt,maxVolumen);
    return tankinhalt;
  }

}

class Tanksaeule{
  private Tank tank;
  private boolean stopFuellen=false;

  public Tanksaeule(){}
  public void tankstutzenEntnehmen(Tank tank){
    this.tank=tank;
  }
  public void startTanken(){
    FuellstandSensor fs = new FuellstandSensor(){
      private boolean voll = true;
      public void meldeFuellstand(int fuellstand,int maxVolumen){
        voll = fuellstand >= maxVolumen;
        System.out.println("Fuellstand: " + fuellstand);
      }
      public boolean voll(){return voll;}
    };
    tank.anmeldenFuellstandSensor(fs);
    while(!stopFuellen){
      tank.fuellen();
      stopFuellen = fs.voll();
    }
  }

}

interface FuellstandSensor{
  public boolean voll();
  public void meldeFuellstand(int fuellstand, int maxVolumen);
}

class TestTanken{
  public static void main (String[] args){
    Tanksaeule tanksaeule = new Tanksaeule();
    Tank tank = new Tank (50);
    tanksaeule.tankstutzenEntnehmen (tank);
    tanksaeule.startTanken();
  }
}
