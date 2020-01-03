package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;
import rs.ac.uns.ftn.ssluzba.gui.controller.PredmetController;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

@SuppressWarnings("serial")
public class DeletePredmet extends JOptionPane {
	
	public DeletePredmet(String sifra) {
		Predmet p = Data.getListaPredmeta().getPredmet(sifra);
		String message = String.format("Da li \u017eelite obrisati predmet %s sa \u0161ifrom %s?", p.getNaziv(), p.getSifra());
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
		int type = JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(type == JOptionPane.YES_OPTION)
			PredmetController.deletePredmet(p,ModelAction.DELETE);
	}
}
