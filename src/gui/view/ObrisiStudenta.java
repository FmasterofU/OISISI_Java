package gui.view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import gui.controller.StudentController;
import gui.model.Student;
import persistence.Data;

public class ObrisiStudenta extends JOptionPane{

		private static final long serialVersionUID = 8706916055932739479L;
		private static ObrisiStudenta instance = null;
		
		public static ObrisiStudenta getNew(int idx)
		{
			instance = new ObrisiStudenta(idx);
			return instance;
		}
		
		private ObrisiStudenta(int idx)
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
