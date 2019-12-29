package gui.view.modify.data;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import gui.controller.PredmetController;
import gui.model.Data;
import gui.model.Predmet;
import gui.view.MainWindow;

@SuppressWarnings("serial")
public class DeletePredmet extends JOptionPane {
	
	public DeletePredmet(String sifra) {
		Predmet p = Data.data.listaPredmeta.getPredmet(sifra);
		String message = String.format("Da li želite obrisati predmet %s sa šifrom %s?", p.getNaziv(), p.getSifra());
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
		int type = JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(type == JOptionPane.YES_OPTION)
			PredmetController.deletePredmet(p);
	}
}
