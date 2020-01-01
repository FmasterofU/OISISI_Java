package rs.ac.uns.ftn.ssluzba.gui.view.centerdata;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import rs.ac.uns.ftn.ssluzba.gui.view.ExpandedToolBarPanel;
import rs.ac.uns.ftn.ssluzba.gui.view.ToolBar;

@SuppressWarnings("serial")
public class CenterBox extends JTabbedPane {
	
	private static CenterBox instance = null;
	private int lastSelectedIndex = -1;
	
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
		lastSelectedIndex = getSelectedIndex();
		this.setBackground(new Color(165, 199, 245)); //active tab color is new Color(165, 199, 245) - color picked, and this is for other tabs and background
		addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				CenterBox.reset(lastSelectedIndex);
				lastSelectedIndex = ((JTabbedPane) e.getSource()).getSelectedIndex();
				ToolBar.getInstance().remove(ToolBar.currentExpandedToolbarPanel);
				switch(lastSelectedIndex) {
					case 2:
						ToolBar.currentExpandedToolbarPanel = ExpandedToolBarPanel.getInstance();
						break;
					default:
						ToolBar.currentExpandedToolbarPanel = new JPanel();
						ToolBar.currentExpandedToolbarPanel.setMaximumSize(new Dimension());
				}
				ToolBar.getInstance().add(ToolBar.currentExpandedToolbarPanel, 4);
				ToolBar.getInstance().validate();
				ToolBar.getInstance().repaint();
			}
		});
	}
	
	@Override
	public void addTab(String title, Component component) {
		addTab(title, null, component);
	}
	
	public static void reset(int pane) {
		switch(pane) {
			case 0: ViewStudenti.getInstance().updateTable(); break;
			case 1: ViewProfesori.getInstance().updateTable(); break;
			case 2: ViewPredmeti.getInstance().updateTable(); break;
			default:
				ViewStudenti.getInstance().updateTable(); 
				ViewProfesori.getInstance().updateTable(); 
				ViewPredmeti.getInstance().updateTable(); 
		}
		ToolBar.resetSearch();
	}
	public int getLastSelectedIndex() {
		return lastSelectedIndex;
	}
}
