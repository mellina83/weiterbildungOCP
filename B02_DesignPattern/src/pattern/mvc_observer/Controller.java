package pattern.mvc_observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	private Model model;
	private MainView mainView;

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

	public Controller() {
		this.setMainView(new MainView());
		this.setModel(new Model());
		this.getMainView().getBtnCountUp().addActionListener(this::actionCountUp);
		this.getMainView().getBtnCountDown().addActionListener(this::actionCountDown);
//		this.getMainView().addActionListenersToButtons(this);
		new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		};
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Up":
			this.getModel().countUp();
			break;
		case "Down":
			this.getModel().countDown();
			break;
		}
	}

	public void actionCountUp(ActionEvent e) {
		int erg = this.getModel().countUp();
		System.out.println("Ergebnis vom Model erhalten : " + erg);
		this.getMainView().updateLabelText(erg);
	}

	public void actionCountDown(ActionEvent e) {
		int erg = this.getModel().countDown();
		System.out.println("Ergebnis vom Model erhalten : " + erg);
		this.getMainView().updateLabelText(erg);		
	}

}
