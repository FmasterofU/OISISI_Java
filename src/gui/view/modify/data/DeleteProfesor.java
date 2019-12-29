package gui.view.modify.data;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import gui.controller.ProfesorController;
import gui.model.Data;
import gui.model.Profesor;
import gui.view.MainWindow;

@SuppressWarnings("serial")
public class DeleteProfesor extends JOptionPane{

	public DeleteProfesor(String id) {
		Profesor p = Data.data.listaProfesora.getProfesor(id);
		String message = String.format("Da li želite obrisati profesora %s %s sa br. LK %s?", p.getIme(), p.getPrezime(), p.getBrojLK());
		UIManager.put("OptionPane.yesButtonText", "Da");
		UIManager.put("OptionPane.noButtonText", "Ne");
		int type = JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(type == JOptionPane.YES_OPTION)
			ProfesorController.deleteProfesor(p);
	}
}
