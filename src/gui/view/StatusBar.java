package gui.view;

import java.awt.Component;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class StatusBar extends JPanel {
	private static Component instance = null;
	public static Component getInstance() {
		if(instance==null) instance = new StatusBar();
		return (Component) instance;
	}
	private StatusBar() {}
}
