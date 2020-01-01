package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;
import rs.ac.uns.ftn.ssluzba.gui.controller.PredmetController;
import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

@SuppressWarnings("serial")
public class DeleteProfesorFromPredmet extends JOptionPane{

	public DeleteProfesorFromPredmet(String sifra) {
		Predmet p = Data.data.listaPredmeta.getPredmet(sifra);
		String message = String.format("Da li želite ukloniti profesora %s sa predmeta %s?", p.getProfesor().getIme()+ " "+ p.getProfesor().getPrezime()+" PK"+p.getProfesor().getBrojLK(), p.getNaziv());
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
		int type = JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(type == JOptionPane.YES_OPTION) {
			Predmet novi = new Predmet(p.getSifra(), p.getNaziv(), p.getSemestar(), p.getGodinaStudija(), null, p.getStudenti());
			PredmetController.editPredmet(sifra,novi,ModelAction.DELETE_P);
		}
	}
}
