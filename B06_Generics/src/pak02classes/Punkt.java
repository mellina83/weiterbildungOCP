package pak02classes;

public class Punkt {
	private int x;
	private int y;
	public Number num;
	
	public Punkt(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Punkt(double x, double y) {
		this.setX((int)x);
		this.setY((int)y);
	}
	public Punkt(Number num) {
		this.num = num;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punkt [x=" + x + ", y=" + y + ", num=" + num + "]";
	}
	
	
}
