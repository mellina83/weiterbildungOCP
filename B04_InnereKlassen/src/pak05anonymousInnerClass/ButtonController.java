package pak05anonymousInnerClass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener{
	
	public static void exit(ActionEvent e) {
		System.exit(0);
	}

	public void save(ActionEvent e) {
		System.out.println("Hier soll gespeichert werden");
	}

	public void load(ActionEvent e) {
		System.out.println("Hier soll geladen werden");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
