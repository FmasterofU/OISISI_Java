package rs.ac.uns.ftn.ssluzba.gui.view.modify;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.view.listenersandactions.HighlightListener;

@SuppressWarnings("serial")
public class ComboBox<T> extends JComboBox<T> implements IHighlight {

	public ComboBox(T[] o) {
		super();
		super.setModel(new DefaultComboBoxModel<T>(o));
		this.addItemListener(new HighlightListener<ComboBox<T>>(this));
		super.setSelectedItem(null);
	}
	
	@Override
	public void maybeHighlight() {
		setBorder((CheckValidation.checkSelection(this.getSelectedItem()) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
	}
}
