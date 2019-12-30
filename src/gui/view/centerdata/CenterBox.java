package gui.view.centerdata;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;

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
		this.setBackground(new Color(165, 199, 245)); //active tab color is new Color(165, 199, 245), and this is for other tabs
	}
	
	@Override
	public void addTab(String title, Component component) {
		addTab(title, null, component);
	}
}
