package gui.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Dialog extends JDialog {
	private int labGBC = 0;
	private int tfGBC = 0;
	public JButton acceptButton;
	public JButton cancelButton = new JButton("Odustanak");
	public JPanel middlePanel = new JPanel();
	public JPanel buttonPanel = new JPanel();
	public JPanel buttons = new JPanel();
	
	public Dialog(String windowName, String acceptButtonName, String cancelButtonName) {
		super(MainWindow.getInstance(), windowName, true);
		acceptButton = new JButton(acceptButtonName);
		cancelButton = new JButton(cancelButtonName);
		setSize(550, 550);
		setLocationRelativeTo(MainWindow.getInstance());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		acceptButton.setForeground(Color.BLACK);
		acceptButton.setBackground(Color.CYAN);
		
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
	
	public GridBagConstraints generateLabelGBC(){
		GridBagConstraints ret = new GridBagConstraints();
		ret.gridx = 0;
		ret.gridy = labGBC++;
		ret.insets = new Insets(10, 10, 10, 10);
		return ret;
	}
	
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
