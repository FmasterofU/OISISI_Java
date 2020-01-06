package rs.ac.uns.ftn.ssluzba.gui.view.modify;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

/**
 * @author rammba fmaster
 * @implNote Concrete Dialog class for our use case, extending {@link JDialog}
 */
@SuppressWarnings({ "serial" })
public class Dialog extends JDialog {
	private int labGBC = 0;
	private int tfGBC = 0;
	public JButton acceptButton;
	public JButton cancelButton;
	public JPanel middlePanel = new JPanel();
	public JPanel buttonPanel = new JPanel();
	public JPanel buttons = new JPanel();
	//public boolean[] enableAccept;
	
	/**
	 * @see Dialog
	 * @param windowName - name of the new Dialog window
	 * @param acceptButtonName - name displayed on the default accept button
	 * @param cancelButtonName - name displayed on the default cancel button
	 */
	public Dialog(String windowName, String acceptButtonName, String cancelButtonName) {
		super(MainWindow.getInstance(), windowName, true);
		this.setBackground(Color.WHITE);
		middlePanel.setBackground(Color.WHITE);
		buttonPanel.setBackground(Color.WHITE);
		buttons.setBackground(Color.WHITE);
		acceptButton = new JButton(acceptButtonName);
		acceptButton.setMnemonic(KeyEvent.VK_S);
		cancelButton = new JButton(cancelButtonName);
		cancelButton.setMnemonic(KeyEvent.VK_Q);
		setSize(550, 550);
		setLocationRelativeTo(MainWindow.getInstance());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		acceptButton.setForeground(Color.BLACK);
		acceptButton.setBackground(Color.CYAN);
		/*
		//just to prove that we do know how to disable a button
		acceptButton.setEnabled(false);
		acceptButton.firePropertyChange((String)null, true, false);
		acceptButton.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				//kroz for petlju bi prosli kroz sve enableAccept i provjerili da li su true, ako jesu enable
				//enableAccept bi se setovao za kroz vec postojece listenere uz svaki postojeci item/state/focus change uz predhodni poziv CheckValidation
				acceptButton.setEnabled(true);
			}
		});
		*/
		BoxLayout box1 = new BoxLayout(buttons, BoxLayout.Y_AXIS);
		buttons.setLayout(box1);
		
		BoxLayout box2 = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);
		buttonPanel.setLayout(box2);
		buttonPanel.add(Box.createGlue());
		buttonPanel.add(cancelButton);
		buttonPanel.add(Box.createHorizontalStrut(10));
		buttonPanel.add(acceptButton);
		buttonPanel.add(Box.createHorizontalStrut(10));
		buttons.add(buttonPanel);
		buttons.add(new JLabel(" "));
		
		this.add(buttons, BorderLayout.SOUTH);
		
		middlePanel.setLayout(new GridBagLayout());
		this.add(middlePanel, BorderLayout.CENTER);
	}
	
	/**
	 * @return new properly set-up {@link GridBagConstraints} instance for label component in {@link Dialog} instance
	 */
	public GridBagConstraints generateLabelGBC(){
		GridBagConstraints ret = new GridBagConstraints();
		ret.gridx = 0;
		ret.gridy = labGBC++;
		ret.insets = new Insets(10, 10, 10, 10);
		return ret;
	}
	
	/**
	 * @return new properly set-up {@link GridBagConstraints} instance for text field component in {@link Dialog} instance
	 */
	public GridBagConstraints generateTextFieldGBC(){
		GridBagConstraints ret = new GridBagConstraints();
		ret.gridx = 1;
		ret.gridy = tfGBC++;
		ret.weightx = 100;
		ret.fill = GridBagConstraints.HORIZONTAL;
		ret.insets = new Insets(10, 10, 10, 10);
		return ret;
	}
}
