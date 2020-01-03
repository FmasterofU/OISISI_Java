package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import rs.ac.uns.ftn.ssluzba.gui.controller.StudentController;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

public class DeleteStudent extends JOptionPane{

		private static final long serialVersionUID = 8706916055932739479L;
		private static DeleteStudent instance = null;
		
		public static DeleteStudent getNew(String idx)
		{
			instance = new DeleteStudent(idx);
			return instance;
		}
		
		private DeleteStudent(String idx)
		{
			//String index = getIndex(idx);
			if(!idx.equals(""))
			{
				String message = "Da li \u017eelite obrisati studenta sa indeksom " + idx + "?";
				UIManager.put("OptionPane.yesButtonText", "Da");
				UIManager.put("OptionPane.noButtonText", "Ne");
				int type = JOptionPane.showConfirmDialog(MainWindow.getInstance(), message, "Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(type == JOptionPane.YES_OPTION)
				{
					StudentController.deleteStudent(idx);
				}
			}
		}
		/*
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
		}*/

}
