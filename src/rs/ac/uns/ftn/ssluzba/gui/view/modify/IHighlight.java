package rs.ac.uns.ftn.ssluzba.gui.view.modify;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.HighlightListener;

/**
 * @author fmaster
 * @implNote Components need to have implemented these methods in order to be highlighted when needed (required by {@link HighlightListener})
 */
public interface IHighlight {
	public static final Border defaultBorder = new JTextField().getBorder(),  highlightBorder = BorderFactory.createLineBorder(java.awt.Color.RED);
	public void maybeHighlight();
	public void setBorder(Border border);
}
