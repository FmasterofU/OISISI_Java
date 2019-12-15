package gui.view;


import javax.swing.JMenuBar;
@SuppressWarnings("serial")
class MenuBar extends JMenuBar {
	private static JMenuBar instance = null;
	public static JMenuBar getInstance() {
		if(instance==null) instance =  new MyMenuBar();
		return instance;
	}
	//private MenuBar() {}
}
