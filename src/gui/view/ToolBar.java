package gui.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners_and_actions.ApstraktnaAkcija;

@SuppressWarnings("serial")
class ToolBar extends JPanel {
	
	private static ToolBar instance = null;
	public static JPanel currentExpandedToolbarPanel = new JPanel();
	
	public static ToolBar getInstance() {
		if(instance==null) instance = new ToolBar();
		return instance;
	}
	
	private ToolBar() {
		BoxLayout box = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(box);
		this.add(Box.createHorizontalStrut(10));
		
		JButton buttonAdd = new JButton(new ImageIcon("Slike/add-24.png"));
		buttonAdd.setBackground(Color.WHITE);
		buttonAdd.setBorderPainted(false);
		//ApstraktnaAkcija actNew = ApstraktnaAkcija()
		this.add(buttonAdd);
		
		JButton buttonEdit = new JButton(new ImageIcon("Slike/edit-property-24.png"));
		buttonEdit.setBackground(Color.WHITE);
		buttonEdit.setBorderPainted(false);
		this.add(buttonEdit);
		
		JButton buttonDelete = new JButton(new ImageIcon("Slike/trash-24.png"));
		buttonDelete.setBackground(Color.WHITE);
		buttonDelete.setBorderPainted(false);
		this.add(buttonDelete);
		
		currentExpandedToolbarPanel.setMaximumSize(new Dimension());
		this.add(currentExpandedToolbarPanel);
		
		this.add(Box.createGlue());
		
		JTextField tf = new JTextField(30);
		Dimension d = this.getPreferredSize();
		tf.setSize(70, d.height*3/4);
		tf.setMaximumSize(new Dimension(300, d.height*3/4));
		tf.setMinimumSize(new Dimension(300, d.height*3/4));
		this.add(tf);
		
		JButton buttonSearch = new JButton(new ImageIcon("Slike/search-24.png"));
		buttonSearch.setBackground(Color.WHITE);
		buttonSearch.setBorderPainted(false);
		this.add(buttonSearch);
		
		this.add(Box.createHorizontalStrut(20));
		this.setBackground(Color.WHITE);
		//this.setSize(100,100);
	}


}
