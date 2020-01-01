package rs.ac.uns.ftn.ssluzba.gui.view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.ThisAbstractAction;

@SuppressWarnings("serial")
public class ExpandedToolBarPanel extends JPanel {
	
	private static ExpandedToolBarPanel panel = null;
	
	public static ExpandedToolBarPanel getInstance() {
		if(panel == null) panel = new ExpandedToolBarPanel();
		return panel;
	}
	
	private ExpandedToolBarPanel() {
		BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(box);
		this.setBackground(Color.WHITE);
		
		ThisAbstractAction actAddProf = new ThisAbstractAction("addProf");
		JButton buttonAddProf = new JButton(actAddProf);
		buttonAddProf.setText("Dodaj Prof.");
		buttonAddProf.setBackground(Color.WHITE);
		buttonAddProf.setBorderPainted(false);
		buttonAddProf.setIcon(new ImageIcon("Slike/add-teacher-24.png"));
		this.add(buttonAddProf);
		
		ThisAbstractAction actRemProf = new ThisAbstractAction("remProf");
		JButton buttonRemProf = new JButton(actRemProf);
		buttonRemProf.setText("Ukloni Prof.");
		buttonRemProf.setBackground(Color.WHITE);
		buttonRemProf.setBorderPainted(false);
		buttonRemProf.setIcon(new ImageIcon("Slike/remove-reacher-24.png"));
		this.add(buttonRemProf);
	}
	
}
