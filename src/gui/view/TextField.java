package gui.view;

import javax.swing.JTextField;

import listeners_and_actions.HighlightListener;

@SuppressWarnings("serial")
public class TextField extends JTextField implements IHighlight {
	
	public TextField() {
		getDocument().addDocumentListener(new HighlightListener<TextField>(this));
	}
	public TextField(int i) {
		super(i);
		getDocument().addDocumentListener(new HighlightListener<TextField>(this));
	}
	
	@Override
	public void maybeHighlight() {
		setBorder(defaultBorder);
	}

}
