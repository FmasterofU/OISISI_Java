package gui.view;

import java.awt.Component;

@SuppressWarnings("serial")
class ViewProfesori extends ViewTableCenter {
	private static Component instance = null;
	public static Component getInstance() {
		if(instance==null) instance = new ViewProfesori();
		return (Component) instance;
	}
	private ViewProfesori() {}
}