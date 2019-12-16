package gui.view;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class StatusBar extends JPanel {
	private static StatusBar instance = null;
	public static StatusBar getInstance() {
		if(instance==null) instance = new StatusBar();
		return instance;
	}
	private StatusBar() {}
}
