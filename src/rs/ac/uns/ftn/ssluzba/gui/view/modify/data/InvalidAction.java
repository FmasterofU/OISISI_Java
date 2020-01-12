package rs.ac.uns.ftn.ssluzba.gui.view.modify.data;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;
import rs.ac.uns.ftn.ssluzba.resources.Resource;

/**
 * @author rammba
 * @implNote Option pane (extends {@link JOptionPane}) displayed when user tries to start an invalid operation at that point in time
 */
@SuppressWarnings("serial")
public class InvalidAction extends JOptionPane {
	
	/**
	 * @param error - error message to be displayed
	 * @see InvalidAction
	 */
	public InvalidAction(String error){
		JOptionPane.showConfirmDialog(MainWindow.getInstance(), error, "Grе\u0161ka", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, new ImageIcon(Resource.get("error_message-32.png")));
	}
}
