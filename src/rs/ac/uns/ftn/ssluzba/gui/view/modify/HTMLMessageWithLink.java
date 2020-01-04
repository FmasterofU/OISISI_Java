package rs.ac.uns.ftn.ssluzba.gui.view.modify;

import java.awt.Desktop;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * @author fmaster powered by StackOverflow xD
 * @implNote extends {@link JEditorPane}, links will open in default browser
 */
@SuppressWarnings("serial")
public class HTMLMessageWithLink extends JEditorPane {

	/**
	 * @param htmlBody - any html body block (without body tags), links will open in default browser
	 */
	public HTMLMessageWithLink(String htmlBody) {
		super("text/html", "<html><body>" + htmlBody + "</body></html>");
		this.setBackground((new JPanel()).getBackground());
		this.setFont(new JOptionPane().getFont());
		addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
					try {
						Desktop.getDesktop().browse(e.getURL().toURI());
					} catch (Exception excp) {
						excp.printStackTrace();
					}
				}
			}
		});
		setEditable(false);
		setBorder(null);
	}
}