package pak03memberclass.pak01_zugriff_attribute;

public class App {
	public static void main(String[] args) {
		Out out = new Out();
		Out.In in = out.new In();
		
		in.see();
	}
}
