package rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import rs.ac.uns.ftn.ssluzba.gui.view.modify.IHighlight;

/**
 * @author fmaster
 * @implNote Listener class for highlighting
 * @param <T> extending {@link IHighlight} interface
 */
public class HighlightListener<T extends IHighlight> implements DocumentListener, ItemListener {

	private T instance=null;
	public HighlightListener(T o) {
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		instance.setBorder(IHighlight.defaultBorder);
		instance.maybeHighlight();
	}

}
