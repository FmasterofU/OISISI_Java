package rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import rs.ac.uns.ftn.ssluzba.gui.view.modify.IHighlight;

/**
 * @author fmaster
 * @implNote Listener class for highlighting
 * @param T extending {@link IHighlight} interface
 */
public class HighlightListener<T extends IHighlight> implements DocumentListener, ItemListener {

	private T instance=null;
	/**
	 * @param o generic object extending {@link IHighlight} to be hold in instance of this class {@link HighlightListener}, used in {@link Override} of implemented interfaces {@link DocumentListener} and {@link ItemListener}
	 */
	public HighlightListener(T o) {
		instance=o;
	}

	/**
	 * {@link Override}
	 */
	@Override
	public void changedUpdate(DocumentEvent arg0) {
		instance.setBorder(IHighlight.defaultBorder);
		instance.maybeHighlight();		
	}

	/**
	 * {@link Override}
	 */
	@Override
	public void insertUpdate(DocumentEvent arg0) {
		instance.setBorder(IHighlight.defaultBorder);
		instance.maybeHighlight();

	}

	/**
	 * {@link Override}
	 */
	@Override
	public void removeUpdate(DocumentEvent arg0) {
		instance.setBorder(IHighlight.defaultBorder);
		instance.maybeHighlight();

	}

	/**
	 * {@link Override}
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		instance.setBorder(IHighlight.defaultBorder);
		instance.maybeHighlight();
	}

}
