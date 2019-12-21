package gui.view.modify;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MandatoryTextFieldLabel extends JLabel {
	public MandatoryTextFieldLabel(String text) {
		super("<html>"+text+"<font color='red'>* </font></html>");
	}
}
