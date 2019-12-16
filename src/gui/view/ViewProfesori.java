package gui.view;

import java.awt.Component;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class ViewProfesori extends JPanel {
	private static Component instance = null;
	public static Component getInstance() {
		if(instance==null) instance = new ViewProfesori();
		return (Component) instance;
	}
	private ViewProfesori() {}
}