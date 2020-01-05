package rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import com.sun.glass.events.KeyEvent;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaPredmeta;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaProfesora;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaStudenata;
import rs.ac.uns.ftn.ssluzba.gui.view.CenterBox;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;
import rs.ac.uns.ftn.ssluzba.gui.view.ToolBar;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ThisTableModel;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewStudenti;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.HTMLMessageWithLink;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.AddPredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.AddProfesor;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.AddProfesorToPredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.AddStudent;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.AddStudentToPredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.DeletePredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.DeleteProfesor;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.DeleteProfesorFromPredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.DeleteStudent;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.DeleteStudentFromPredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.EditPredmet;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.EditProfesor;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.EditStudent;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.InvalidAction;

/**
 * this class is literally brain of our app
 */
public class ThisAbstractAction extends AbstractAction{

	private static final long serialVersionUID = 4889011984599408652L;
	private String name;
	
	/**
	 * gives mnemonics, icons and names to {@link Component}s
	 * @param s name of {@link Component} in application
	 */
	public ThisAbstractAction(String s) {
		String rez = s.trim();
		rez = s.toLowerCase();
		name = rez;
		switch(rez){
			case "new":
				putValue(NAME, "New");
				putValue(MNEMONIC_KEY, KeyEvent.VK_N);
				putValue(SMALL_ICON, new ImageIcon("Slike/new.png"));
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
				break;
			case "close":
				putValue(NAME, "Close");
				putValue(MNEMONIC_KEY, KeyEvent.VK_Q);
				putValue(SMALL_ICON, new ImageIcon("Slike/close.png"));
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
				break;
			case "edit":
				putValue(NAME, "Edit");
				putValue(MNEMONIC_KEY, KeyEvent.VK_E);
				putValue(SMALL_ICON, new ImageIcon("Slike/edit.png"));
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
				break;
			case "delete":
				putValue(NAME, "Delete");
				putValue(MNEMONIC_KEY, KeyEvent.VK_D);
				putValue(SMALL_ICON, new ImageIcon("Slike/delete.png"));
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
				break;
			case "search":
				putValue(NAME, "Search");
				//putValue(SMALL_ICON, new ImageIcon("Slike/search-24.png"));
				putValue(MNEMONIC_KEY, KeyEvent.VK_S);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_DOWN_MASK));
				break;
			case "help":
				putValue(NAME, "Help");
				putValue(MNEMONIC_KEY, KeyEvent.VK_H);
				putValue(SMALL_ICON, new ImageIcon("Slike/help.png"));
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
				break;
			case "about":
				putValue(NAME, "About");
				putValue(MNEMONIC_KEY, KeyEvent.VK_I);
				putValue(SMALL_ICON, new ImageIcon("Slike/about.png"));
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
				break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(name.equals("close")) 
			MainWindow.exit();
		else if(name.equals("new"))
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
				case 3:
					switch(ViewSearch.getRootTab()){
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
			}
		else if(name.equals("delete")) 
			switch(CenterBox.getInstance().getSelectedIndex()) {
				case 0:
					String idx = ViewStudenti.getInstance().getSelectedKey();
					if(idx != null)		DeleteStudent.getNew(idx).setVisible(true);
					else new InvalidAction("Niste izabrali studenta za brisanje!");
					break;
				case 1: 
					String id = ViewProfesori.getInstance().getSelectedKey();
					if(id!=null) (new DeleteProfesor(id)).setVisible(true);
					else new InvalidAction("Niste izabrali profesora za brisanje!");
					break;
				case 2:
					String sifra = ViewPredmeti.getInstance().getSelectedKey();
					if(sifra!=null) (new DeletePredmet(sifra)).setVisible(true);
					else new InvalidAction("Niste izabrali predmet za brisanje!");
					break;
				case 3:
					switch(ViewSearch.getRootTab()) {
						case 0:
							String idx1 = ViewSearch.instanceIfExists().getSelectedKey();
							if(idx1 != null)		DeleteStudent.getNew(idx1).setVisible(true);
							else new InvalidAction("Niste izabrali studenta za brisanje!");
							break;
						case 1: 
							String id1 = ViewSearch.instanceIfExists().getSelectedKey();
							if(id1!=null) (new DeleteProfesor(id1)).setVisible(true);
							else new InvalidAction("Niste izabrali profesora za brisanje!");
							break;
						case 2:
							String sifra1 = ViewSearch.instanceIfExists().getSelectedKey();
							if(sifra1!=null) (new DeletePredmet(sifra1)).setVisible(true);
							else new InvalidAction("Niste izabrali predmet za brisanje!");
							break;
					}
			}
		else if(name.equals("edit"))
			switch(CenterBox.getInstance().getSelectedIndex()){
				case 0:
					String idx = ViewStudenti.getInstance().getSelectedKey();
					if(idx != null)		EditStudent.getInstance(idx).setVisible(true);
					else new InvalidAction("Niste izabrali studenta za izmenu!");
					break;
				case 1:
					String id = ViewProfesori.getInstance().getSelectedKey();
					if(id != null)	EditProfesor.getInstance(id).setVisible(true);
					else new InvalidAction("Niste izabrali profesora za izmenu!");
					break;
				case 2:
					String sifra = ViewPredmeti.getInstance().getSelectedKey();
					if(sifra!=null) EditPredmet.getInstance(sifra).setVisible(true);
					else new InvalidAction("Niste izabrali predmet za izmenu!");
					break;
				case 3:
					switch(ViewSearch.getRootTab()){
					case 0:
						String idx1 = ViewSearch.instanceIfExists().getSelectedKey();
						if(idx1 != null)		EditStudent.getInstance(idx1).setVisible(true);
						else new InvalidAction("Niste izabrali studenta za izmenu!");
						break;
					case 1:
						String id1 = ViewSearch.instanceIfExists().getSelectedKey();
						if(id1 != null)	EditProfesor.getInstance(id1).setVisible(true);
						else new InvalidAction("Niste izabrali profesora za izmenu!");
						break;
					case 2:
						String sifra1 = ViewSearch.instanceIfExists().getSelectedKey();
						if(sifra1!=null) EditPredmet.getInstance(sifra1).setVisible(true);
						else new InvalidAction("Niste izabrali predmet za izmenu!");
						break;
					}
			}
		else if(name.equals("search")){
			if(ViewSearch.instanceIfExists()!=null) {
				ViewSearch.instanceIfExists().updateTable(); 
				return;
			}
			int tab = CenterBox.getInstance().getSelectedIndex();
			if(CheckValidation.checkSearchQuery(ToolBar.getSearchQuery(),tab))
			{
				switch(tab)
				{
					case 0:
						ViewStudenti.inSearchMode=true;
						ViewSearch.getInstance(0, ViewStudenti.getKeyColumn(), new ThisTableModel<ListaStudenata>((new ListaStudenata(Data.getListaStudenata())).mutableSearch(ToolBar.getSearchQuery())));
						break;
					case 1:
						ViewProfesori.inSearchMode=true;
						ViewSearch.getInstance(1, ViewProfesori.getKeyColumn(), new ThisTableModel<ListaProfesora>((new ListaProfesora(Data.getListaProfesora())).mutableSearch(ToolBar.getSearchQuery())));
						break;
					case 2:
						ViewPredmeti.inSearchMode=true;
						ViewSearch.getInstance(2, ViewPredmeti.getKeyColumn(), new ThisTableModel<ListaPredmeta>((new ListaPredmeta(Data.getListaPredmeta())).mutableSearch(ToolBar.getSearchQuery())));
						break;
				}
			}
		}else if(name.equals("help"))
			JOptionPane.showConfirmDialog(MainWindow.getInstance(), new HTMLMessageWithLink("See this link:<br><a href=\"https://fmasterofu.github.io/OISISI_Java/HelpSS.html\">HELP (Product page)</a><br>or contact the developers (mails in About section)."), "Help", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Slike/help.png"));
		else if(name.equals("about"))
			JOptionPane.showConfirmDialog(MainWindow.getInstance(), new HTMLMessageWithLink("OISISI_Java - Studentska Slu\u017eba v1.0.0 <a href=\"https://fmasterofu.github.io/OISISI_Java/\">Product page</a><br>~ Igor \u0160ikuljak - RA117/2017 - igorsikuljak@uns.ac.rs<br>~ Rado\u0161 Mili\u0107ev - RA121/2017 - rados280698@yahoo.com"), "About", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("Slike/about.png"));
		else if(name.equals("addprof")) {
			String sifra;
			if(ViewSearch.getRootTab()==-1) sifra = ViewPredmeti.getInstance().getSelectedKey();
			else sifra = ViewSearch.instanceIfExists().getSelectedKey();
			if(sifra!=null && Data.getListaPredmeta().getPredmet(sifra).getProfesor()==null) AddProfesorToPredmet.getInstance(sifra).setVisible(true);
			else if(sifra==null)	new InvalidAction("Niste izabrali predmet kojem \u017eelite dodeliti profesora!");
		} else if(name.equals("remprof")) {
			String sifra;
			if(ViewSearch.getRootTab()==-1) sifra = ViewPredmeti.getInstance().getSelectedKey();
			else sifra = ViewSearch.instanceIfExists().getSelectedKey();
			if(sifra!=null && Data.getListaPredmeta().getPredmet(sifra).getProfesor()!=null) (new DeleteProfesorFromPredmet(sifra)).setVisible(true);
			else if(sifra==null)	new InvalidAction("Niste izabrali predmet sa kojeg \u017eelite ukloniti profesora!");
			else new InvalidAction("Predmet koji ste izabrali nema raspore\u0111enog profesora!");
		}else if(name.equals("addstud")) {
			String id;
			if(ViewSearch.getRootTab()==-1) id = ViewPredmeti.getInstance().getSelectedKey();
			else id = ViewSearch.instanceIfExists().getSelectedKey();
			if(id != null && Data.getListaPredmeta().getStudentIndexesNotListeningPredmet(Data.getListaPredmeta().getPredmet(id)).isEmpty())		AddStudentToPredmet.error(id);
			else if(id != null)		AddStudentToPredmet.getInstance(id).setVisible(true);
			else if(id==null)	new InvalidAction("Niste izabrali predmet kojem \u017eelite dodati studenta!");
		}else if(name.equals("remstud")){
			String id;
			if(ViewSearch.getRootTab()==-1) id = ViewPredmeti.getInstance().getSelectedKey();
			else id = ViewSearch.instanceIfExists().getSelectedKey();
			if(id != null && Data.getListaPredmeta().getPredmet(id).getStudenti().isEmpty())		DeleteStudentFromPredmet.error(id);
			else if(id != null)		DeleteStudentFromPredmet.getInstance(id).setVisible(true);
			else if(id==null)	new InvalidAction("Niste izabrali predmet sa kojeg \u017eelite ukloniti studenta!");
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
