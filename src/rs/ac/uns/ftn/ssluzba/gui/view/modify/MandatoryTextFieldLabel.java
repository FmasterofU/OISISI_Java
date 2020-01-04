package rs.ac.uns.ftn.ssluzba.gui.view.modify;

import javax.swing.JLabel;

/**
 * @author fmaster
 * @implNote Mandatory Text Field label - adds red star at the end of the lagel
 * extends {@link JLabel}
 */
@SuppressWarnings("serial")
public class MandatoryTextFieldLabel extends JLabel {
	/**
	 * @implNote adds red star at the end of text and creates label
	 * @param text - text of the label (without *)
	 */
	public MandatoryTextFieldLabel(String text) {
		super("<html>"+text+"<font color='red'>* </font></html>");
	}
}
