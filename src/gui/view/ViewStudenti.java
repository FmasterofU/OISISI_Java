package gui.view;

import java.awt.Component;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class ViewStudenti extends JPanel {
	private static Component instance = null;
	public static Component getInstance() {
		if(instance == null)	instance = new ViewStudenti();
		return (Component) instance;
	}
	private ViewStudenti() {}
}