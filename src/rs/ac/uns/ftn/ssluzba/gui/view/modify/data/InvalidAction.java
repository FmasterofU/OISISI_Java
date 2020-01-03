package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

public class InvalidAction extends JOptionPane{

	private static final long serialVersionUID = 3282106550141237408L;
	
	public InvalidAction(String error)
	{
		JOptionPane.showConfirmDialog(MainWindow.getInstance(), error, "Grе\u0161ka", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon("Slike/error_message-32.png"));
	}
}
