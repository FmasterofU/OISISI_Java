package gui.view;

import javax.swing.JPanel;

@SuppressWarnings("serial")
class ToolBar extends JPanel{
	private static ToolBar instance = null;
	public static ToolBar getInstance() {
		if(instance==null) instance = new ToolBar();
		return instance;
	}
	private ToolBar() {}
}
