package rs.ac.uns.ftn.ssluzba.gui.view;

import java.awt.Color;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import resources.Resource;
import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.ThisAbstractAction;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;

/**
 * @author fmaster
 * @implNote extended {@link JButton} visible on tab {@link ViewPredmeti} or {@link ViewSearch} (when search is {@link ViewPredmeti} related), singleton
 */
@SuppressWarnings({ "serial" })
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
		actAddProf.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_P);
		actAddProf.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		JButton buttonAddProf = new JButton(actAddProf);
		if(ToolBar.nameValues) buttonAddProf.setText("Add Prof.");
		buttonAddProf.setToolTipText("Dodaj Profesora na Predmet");
		buttonAddProf.setBackground(Color.WHITE);
		buttonAddProf.setBorderPainted(false);
		buttonAddProf.setIcon(new ImageIcon(Resource.get("add-teacher-32.png")));
		this.add(buttonAddProf);
		
		ThisAbstractAction actRemProf = new ThisAbstractAction("remProf");
		actRemProf.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_R);
		actRemProf.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
		JButton buttonRemProf = new JButton(actRemProf);
		if(ToolBar.nameValues) buttonRemProf.setText("Remove Prof.");
		buttonRemProf.setToolTipText("Ukloni Profesora sa Predmeta");
		buttonRemProf.setBackground(Color.WHITE);
		buttonRemProf.setBorderPainted(false);
		buttonRemProf.setIcon(new ImageIcon(Resource.get("remove-teacher-32.png")));
		this.add(buttonRemProf);
		
		ThisAbstractAction actAddStud = new ThisAbstractAction("addStud");
		actAddStud.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_T);
		actAddStud.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_DOWN_MASK));
		JButton buttonAddStud = new JButton(actAddStud);
		if(ToolBar.nameValues) buttonAddStud.setText("Add Stud.");
		buttonAddStud.setToolTipText("Dodaj Studenta na Predmet");
		buttonAddStud.setBackground(Color.WHITE);
		buttonAddStud.setBorderPainted(false);
		buttonAddStud.setIcon(new ImageIcon(Resource.get("add-student-32.png")));
		this.add(buttonAddStud);
		
		ThisAbstractAction actDelStud = new ThisAbstractAction("remStud");
		actDelStud.putValue(AbstractAction.MNEMONIC_KEY, KeyEvent.VK_U);
		actDelStud.putValue(AbstractAction.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));
		JButton buttonDelStud = new JButton(actDelStud);
		if(ToolBar.nameValues) buttonDelStud.setText("Remove Stud.");
		buttonDelStud.setToolTipText("Ukloni Studenta sa Predmeta");
		buttonDelStud.setBackground(Color.WHITE);
		buttonDelStud.setBorderPainted(false);
		buttonDelStud.setIcon(new ImageIcon(Resource.get("delete-student-32.png")));
		this.add(buttonDelStud);
	}
	
}
