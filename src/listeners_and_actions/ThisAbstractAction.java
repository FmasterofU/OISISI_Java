package listeners_and_actions;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import gui.view.MainWindow;
import gui.view.centerdata.CenterBox;
import gui.view.centerdata.ViewPredmeti;
import gui.view.centerdata.ViewProfesori;
import gui.view.centerdata.ViewStudenti;
import gui.view.modify.data.AddPredmet;
import gui.view.modify.data.AddProfesor;
import gui.view.modify.data.AddStudent;
import gui.view.modify.data.DeletePredmet;
import gui.view.modify.data.DeleteProfesor;
import gui.view.modify.data.DeleteStudent;
import gui.view.modify.data.EditPredmet;
import gui.view.modify.data.EditProfesor;
import gui.view.modify.data.EditStudent;

public class ThisAbstractAction extends AbstractAction{

	private static final long serialVersionUID = 4889011984599408652L;
	private String name;
	
	public ThisAbstractAction(String s) {
		String rez = s.trim();
		rez = s.toLowerCase();
		name = rez;
		switch(rez)
		{
			case "new":
				{
					putValue(NAME, "New");
					putValue(MNEMONIC_KEY, KeyEvent.VK_N);
					putValue(SMALL_ICON, new ImageIcon("Slike/new.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
					break;
				}
			case "close":
				{
					putValue(NAME, "Close");
					putValue(MNEMONIC_KEY, KeyEvent.VK_Q);
					putValue(SMALL_ICON, new ImageIcon("Slike/close.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
					break;
				}
			case "edit":
				{
					putValue(NAME, "Edit");
					putValue(MNEMONIC_KEY, KeyEvent.VK_E);
					putValue(SMALL_ICON, new ImageIcon("Slike/edit.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
					break;
				}
			case "delete":
				{
					putValue(NAME, "Delete");
					putValue(MNEMONIC_KEY, KeyEvent.VK_D);
					putValue(SMALL_ICON, new ImageIcon("Slike/delete.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
					break;
				}
			case "search":
				putValue(NAME, "Search");
				putValue(SMALL_ICON, new ImageIcon("Slike/search-24.png"));
				break;
			case "help":
				{
					putValue(NAME, "Help");
					putValue(MNEMONIC_KEY, KeyEvent.VK_H);
					putValue(SMALL_ICON, new ImageIcon("Slike/help.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
					break;
				}
			case "about":
				{
					putValue(NAME, "About");
					putValue(MNEMONIC_KEY, KeyEvent.VK_I);
					putValue(SMALL_ICON, new ImageIcon("Slike/about.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
					break;
				}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(name.equals("close")) 
			MainWindow.exit();
		
		if(name.equals("new"))
			switch(CenterBox.getInstance().getSelectedIndex()){
				case 0:
					AddStudent.getInstance().setVisible(true);
					break;
				case 1:
					AddProfesor.getInstance().setVisible(true);
					break;
				case 2:
					AddPredmet.getInstance().setVisible(true);
					break;
			}
		
		if(name.equals("delete"))
			switch(CenterBox.getInstance().getSelectedIndex()) {
				case 0:
					String idx = ViewStudenti.getInstance().getSelectedKey();
					if(idx != null)		DeleteStudent.getNew(idx).setVisible(true);
					break;
				case 1: 
					String id = ViewProfesori.getInstance().getSelectedKey();
					if(id!=null) (new DeleteProfesor(id)).setVisible(true);
					break;
				case 2:
					String sifra = ViewPredmeti.getInstance().getSelectedKey();
					if(sifra!=null) (new DeletePredmet(sifra)).setVisible(true);
					break;
			}
		
		if(name.equals("edit"))
		{
			switch(CenterBox.getInstance().getSelectedIndex())
			{
				case 0:
					String idx = ViewStudenti.getInstance().getSelectedKey();
					if(idx != null)		EditStudent.getInstance(idx).setVisible(true);
					break;
				case 1:
					String id = ViewProfesori.getInstance().getSelectedKey();
					if(id != null)	EditProfesor.getInstance(id).setVisible(true);
					break;
				case 2:
					String sifra = ViewPredmeti.getInstance().getSelectedKey();
					if(sifra!=null) EditPredmet.getInstance(sifra).setVisible(true);
					break;
			}
		}
		if(name.equals("search")) {
			System.out.println("TODO: Search");
		}
		if(name.equals("about")) {
			JOptionPane.showConfirmDialog(MainWindow.getInstance(), "OISISI_Java - Studentska Služba\n~ Igor Šikuljak - igorsikuljak@uns.ac.rs\n~ Radoš Milićev - rados280698@yahoo.com", "About", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Slike/about.png"));
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
