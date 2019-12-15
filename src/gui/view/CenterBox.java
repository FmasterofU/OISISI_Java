package gui.view;

import java.awt.Component;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class CenterBox extends JPanel{
	private static Component instance = null;
	public static Component getInstance() {
		if(instance==null) instance = new CenterBox();
		return (Component) instance;
	}
	private CenterBox() {}
}
