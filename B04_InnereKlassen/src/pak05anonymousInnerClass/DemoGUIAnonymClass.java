package pak05anonymousInnerClass;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoGUIAnonymClass {
	private JFrame frame;
	public String text = "";
	public DemoGUIAnonymClass() {
		frame = new JFrame();
		frame.setBounds(300, 300, 640, 480); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnExit = new JButton("Exit Button");
		JButton btnLeft = new JButton("Linker Button");
		JButton btnright = new JButton("Rechter Button");
		
		ActionListener al = new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Button gedrueckt");
				System.out.println(((JButton)e.getSource()).getText());
			}
		};
		ActionListener al1 = e -> {System.out.println("Lambda ActionListener");};
		
		ButtonController bc = new ButtonController();
		
		btnExit.addActionListener(ButtonController::exit);
		btnLeft.addActionListener(bc::save);
		btnright.addActionListener(bc::load);
		
		
		btnExit.addActionListener(al);
		
		
		panel.add(btnLeft);
		panel.add(btnExit);
		panel.add(btnright);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {			
			@Override
			public void run() {
				new DemoGUIAnonymClass();				
			}
		});
	}
	
}
