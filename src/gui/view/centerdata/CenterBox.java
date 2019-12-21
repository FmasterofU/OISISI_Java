package gui.view.centerdata;

import java.awt.Component;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class CenterBox extends JTabbedPane {
	private static CenterBox instance = null;
	public static CenterBox getInstance() {
		if(instance==null) instance = new CenterBox();
		return instance;
	}
	private CenterBox() {
		super();
		addTab("Studenti", ViewStudenti.getInstance());
		addTab("Profesori", ViewProfesori.getInstance());
		addTab("Predmeti", ViewPredmeti.getInstance());
	}
	
	@Override
	public void addTab(String title, Component component) {
		addTab(title, null, component);
	}
}
