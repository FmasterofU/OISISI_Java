package rs.ac.uns.ftn.ssluzba.gui.view.modify;

import javax.swing.JTextField;

import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.HighlightListener;

/**
 * @author fmaster
 * @implNote Generalized Highlightable TextField
 * abstract - implement {@link IHighlight}
 * extends {@link JTextField}
 */
@SuppressWarnings("serial")
public abstract class TextField extends JTextField implements IHighlight {
	
	/**
	 * Construct, delegate, setup Highlighter
	 */
	public TextField() {
		getDocument().addDocumentListener(new HighlightListener<TextField>(this));
	}
	
	/**
	 * Construct, delegate, setup Highlighter
	 * @param i - passed to {@link JTextField} constructor 
	 */
	public TextField(int i) {
		super(i);
		getDocument().addDocumentListener(new HighlightListener<TextField>(this));
	}
	
	/**
	 * Construct, delegate, setup Highlighter
	 * @param i - passed to {@link JTextField} constructor 
	 */
	public TextField(String i) {
		super(i);
		getDocument().addDocumentListener(new HighlightListener<TextField>(this));
	}
}
