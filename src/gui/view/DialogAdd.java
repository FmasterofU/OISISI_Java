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
public class DialogAdd extends JDialog {
	public int labGBC = 0;
	public int tfGBC = 0;
	public JButton acceptButton = new JButton("Potvrda");
	public JButton cancelButton = new JButton("Odustanak");
	public JPanel middleLabelsNFields = new JPanel();
	
	public DialogAdd(String name) {
		super(MainWindow.getInstance(), name, true);
		setSize(550, 550);
		setLocationRelativeTo(MainWindow.getInstance());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel buttonPanel = new JPanel();
		acceptButton.setForeground(Color.BLACK);
		acceptButton.setBackground(Color.CYAN);
		
		JPanel buttons = new JPanel();
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
		
		middleLabelsNFields.setLayout(new GridBagLayout());
		this.add(middleLabelsNFields, BorderLayout.CENTER);
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
