package listeners_and_actions;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.view.IHighlight;

public class HighlightListener<T extends IHighlight> implements DocumentListener {

	T instance=null;
	public HighlightListener(T o) {
		System.out.println("instanca");
		instance=o;
	}
	
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		instance.setBorder(IHighlight.defaultBorder);
		instance.maybeHighlight();		
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		instance.setBorder(IHighlight.defaultBorder);
		instance.maybeHighlight();
		
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		instance.setBorder(IHighlight.defaultBorder);
		instance.maybeHighlight();
		
	}

}
