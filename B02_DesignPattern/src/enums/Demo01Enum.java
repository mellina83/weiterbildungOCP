package enums;

public class Demo01Enum {

	enum Resolution{
		VGA(640, 480), SVGA(800,600), HD(1920, 1080);
		//public static final Resolution VGA = new Resolution(640, 480);
		
		public static int staticInt= 10;
		
		private int x;
		private int y;
		
		public int getX() {
			return this.x;
		}
		
		public static void staticGo() {
			
		}
		private Resolution(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void go(Resolution res) {
		System.out.println(res.name());
		System.out.println(res.ordinal());
	}
	public static void main(String[] args) {
		System.out.println(Resolution.staticInt);
		System.out.println(Resolution.VGA.getX());
		System.out.println(Resolution.SVGA.getX());
		System.out.println(Resolution.HD.getX());
		System.out.println("--------------------------");
		go(Resolution.VGA);
		go(Resolution.SVGA);
		go(Resolution.HD);
		
		
	}
	
}
