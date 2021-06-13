package pattern.mvc_observer;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainView extends JFrame{

	private JPanel mainPanel;
	private JPanel centerPanel;
	private JLabel zahlenLabel;
	private JPanel southPanel;
	private JButton btnCountUp, btnCountDown;

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
	}

	public JLabel getZahlenLabel() {
		return zahlenLabel;
	}

	public void setZahlenLabel(JLabel zahlenLabel) {
		this.zahlenLabel = zahlenLabel;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

	public JButton getBtnCountUp() {
		return btnCountUp;
	}

	public void setBtnCountUp(JButton btnCountUp) {
		this.btnCountUp = btnCountUp;
	}

	public JButton getBtnCountDown() {
		return btnCountDown;
	}

	public void setBtnCountDown(JButton btnCountDown) {
		this.btnCountDown = btnCountDown;
	}

	public MainView() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(600, 400, 640, 480);
		
		this.setZahlenLabel(new JLabel());
		this.setSouthPanel(new JPanel());
		this.setMainPanel(new JPanel());
		this.setCenterPanel(new JPanel());
		
		this.getMainPanel().setLayout(new BorderLayout(5,2));
		
		this.setBtnCountUp(new JButton("Up"));
		this.setBtnCountDown(new JButton("Down"));
		this.getBtnCountUp().setActionCommand("Up");
		this.getBtnCountDown().setActionCommand("Down");
		
		this.getSouthPanel().add(this.getBtnCountDown());
		this.getSouthPanel().add(this.getBtnCountUp());
		
		this.getZahlenLabel().setFont(new Font("Arial", Font.PLAIN, 35));
		this.getZahlenLabel().setHorizontalAlignment(SwingConstants.CENTER);
		this.getZahlenLabel().setVerticalAlignment(SwingConstants.CENTER);
		this.getZahlenLabel().setText("Hier kommt eine Zahl rein");
		
		this.getCenterPanel().add(this.getZahlenLabel());
		this.getMainPanel().add(this.getCenterPanel(), BorderLayout.CENTER);
		this.getMainPanel().add(this.getSouthPanel(), BorderLayout.SOUTH);
		
		this.setContentPane(this.getMainPanel());
		this.setVisible(true);
	}

	public void addActionListenersToButtons(ActionListener controller) {
		this.getBtnCountUp().addActionListener(controller);
		this.getBtnCountDown().addActionListener(controller);
	}

	public void updateLabelText(int erg) {
		System.out.println("Updating View");
		this.getZahlenLabel().setText("" + erg);		
	}

}
