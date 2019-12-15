package gui.view;

import java.awt.Component;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class MenuBar extends JPanel {
	private static Component instance = null;
	public static Component getInstance() {
		if(instance==null) instance =  new MenuBar();
		return (Component) instance;
	}
	private MenuBar() {}
}
