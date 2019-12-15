package gui.view;

import java.awt.Component;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class ToolBar extends JPanel{
	private static Component instance = null;
	public static Component getInstance() {
		if(instance==null) instance = new ToolBar();
		return (Component) instance;
	}
	private ToolBar() {}
}
