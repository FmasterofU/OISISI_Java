package listeners_and_actions;

import java.awt.Desktop;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class MessageWithLink extends JEditorPane {
    private static final long serialVersionUID = 1L;

    public MessageWithLink(String htmlBody) {
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