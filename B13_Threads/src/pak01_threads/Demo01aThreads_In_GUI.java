package pak01_threads;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo01aThreads_In_GUI {
	private JFrame frame;

	public static void main(String[] args) {
		Demo01aThreads_In_GUI window = new Demo01aThreads_In_GUI();
		window.frame.setVisible(true);
	}

	public Demo01aThreads_In_GUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btn = new JButton("Test");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread() {
					public void run() {
						int i = 0;
						while (i < 100_000_000) {
							System.out.println(i++);
						}
					}
				}.start();
			}
		});
		frame.getContentPane().add(btn, BorderLayout.WEST);
	}

}
