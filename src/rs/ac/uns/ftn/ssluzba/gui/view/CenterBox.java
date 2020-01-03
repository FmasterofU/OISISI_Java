package rs.ac.uns.ftn.ssluzba.gui.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewStudenti;

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
		this.setBackground(new Color(165, 199, 245)); //active tab color is new Color(165, 199, 245) - color picked, and this is for other tabs and background
		addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(((JTabbedPane) e.getSource()).getSelectedIndex()!=3) 
					ToolBar.dynamicChange(((JTabbedPane) e.getSource()).getSelectedIndex());
				if(((JTabbedPane) e.getSource()).getSelectedIndex()!=3 && ViewSearch.instanceIfExists()!=null)
					ViewSearch.removeInstance();
			}
		});
	}
	
	@Override
	public void addTab(String title, Component component) {
		addTab(title, null, component);
	}

	public static void redraw() {
		instance.revalidate();
		instance.repaint();
	}
}
