package pattern.mvc_observer;

import java.awt.EventQueue;

public class MVC_Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			new Controller();
		});
	}
}
