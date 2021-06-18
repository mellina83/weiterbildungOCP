package pak01_functional;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

class Controller /*implements ActionListener*/ {

	JButton saveBtn = new JButton("save");
	JButton loadBtn = new JButton("load");

	public Controller() {
		saveBtn.setActionCommand("save");
		loadBtn.setActionCommand("load");

		saveBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button gedrueckt");
			}
		});
		
		saveBtn.addActionListener(this::save);
		loadBtn.addActionListener(Controller::load);
	}

	public void save(ActionEvent e) {

	}

	public static void load(ActionEvent e) {

	}
//	//Urspruenglicher Weg
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		switch (e.getActionCommand()) {
//		case "save":
//			System.out.println("gespeichert");
//			break;
//		case "load":
//			System.out.println("geladen");
//			break;
//		}
//	}

}

public class Demo07a_GUI {

}
