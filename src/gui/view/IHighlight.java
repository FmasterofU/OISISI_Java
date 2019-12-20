package gui.view;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public interface IHighlight {
	public static final Border defaultBorder = null,  highlightBorder = BorderFactory.createLineBorder(java.awt.Color.RED);
	public void maybeHighlight();
	public void setBorder(Border border);
}
