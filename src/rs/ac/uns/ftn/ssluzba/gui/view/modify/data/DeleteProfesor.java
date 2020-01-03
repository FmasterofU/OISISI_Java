package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.controller.ProfesorController;
import rs.ac.uns.ftn.ssluzba.gui.model.Profesor;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

@SuppressWarnings("serial")
public class DeleteProfesor extends JOptionPane{

	public DeleteProfesor(String id) {
		Profesor p = Data.getListaProfesora().getProfesor(id);
		String message = String.format("Da li \u017eelite obrisati profesora %s %s sa br. LK %s?", p.getIme(), p.getPrezime(), p.getBrojLK());
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
		int type = JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Brisanje profesora", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(type == JOptionPane.YES_OPTION)
			ProfesorController.deleteProfesor(p);
	}
}
