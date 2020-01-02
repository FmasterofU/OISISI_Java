package rs.ac.uns.ftn.ssluzba.gui.view.modify;

import javax.swing.JTextField;

import rs.ac.uns.ftn.ssluzba.gui.view.listenersandactions.HighlightListener;

@SuppressWarnings("serial")
public abstract class TextField extends JTextField implements IHighlight {
	
	public TextField() {
		getDocument().addDocumentListener(new HighlightListener<TextField>(this));
	}
	public TextField(int i) {
		super(i);
		getDocument().addDocumentListener(new HighlightListener<TextField>(this));
	}
	public TextField(String i) {
		super(i);
		getDocument().addDocumentListener(new HighlightListener<TextField>(this));
	}
	/*
	@Override
	public void maybeHighlight() {
		setBorder(defaultBorder);
	}
*/
}
