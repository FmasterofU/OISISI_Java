package gui.view.centerdata;

import java.awt.Color;
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
		this.setOpaque(true);
		//this.setBackgroundAt(0, Color.WHITE);
		//this.setBackground(Color.WHITE);
		addTab("Profesori", ViewProfesori.getInstance());
		addTab("Predmeti", ViewPredmeti.getInstance());
		this.setBackground(new Color(165, 199, 245)); //active tab color is new Color(165, 199, 245), and this is for other tabs
	}
	
	@Override
	public void addTab(String title, Component component) {
		addTab(title, null, component);
	}
}
