package gui.view.modify.data;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import gui.controller.StudentController;
import gui.model.Student;
import gui.view.MainWindow;
import persistence.Data;

public class DeleteStudent extends JOptionPane{

		private static final long serialVersionUID = 8706916055932739479L;
		private static DeleteStudent instance = null;
		
		public static DeleteStudent getNew(int idx)
		{
			instance = new DeleteStudent(idx);
			return instance;
		}
		
		private DeleteStudent(int idx)
		{
			String index = getIndex(idx);
			String message = "Da li želite obrisati studenta sa indeksom ";
			message += index + "?";
			UIManager.put("OptionPane.yesButtonText", "Naravno");
			UIManager.put("OptionPane.noButtonText", "Nikako");
			int type = JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(type == JOptionPane.YES_OPTION)
			{
				StudentController.getInstance().izbrisiStudenta(index);
			}
		}
		
		private String getIndex(int i)
		{
			int temp = 0;
			for(Student s: Data.data.listaStudenata.getStudenti())
			{
				if(i == temp)
					return s.getBrIndeksa();
				temp++;
			}
			return "";
		}

}
