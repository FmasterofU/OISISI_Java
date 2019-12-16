package gui.view;

import java.awt.Component;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class ViewPredmeti extends JPanel {
	private static Component instance = null;
	public static Component getInstance() {
		if(instance==null) instance = new ViewPredmeti();
		return (Component) instance;
	}
	private ViewPredmeti() {}
}