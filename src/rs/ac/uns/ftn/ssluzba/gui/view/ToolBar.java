package rs.ac.uns.ftn.ssluzba.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.ssluzba.gui.view.listenersandactions.ThisAbstractAction;

@SuppressWarnings("serial")
public class ToolBar extends JPanel {
	
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

		ThisAbstractAction actNew = new ThisAbstractAction("new");
		JButton buttonAdd = new JButton(actNew);
		buttonAdd.setBackground(Color.WHITE);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setIcon(new ImageIcon("Slike/add-24.png"));
		this.add(buttonAdd);
		
		ThisAbstractAction actEdit = new ThisAbstractAction("edit");
		JButton buttonEdit = new JButton(actEdit);
		buttonEdit.setBackground(Color.WHITE);
		buttonEdit.setBorderPainted(false);
		buttonEdit.setIcon(new ImageIcon("Slike/edit-property-24.png"));
		this.add(buttonEdit);
		
		ThisAbstractAction actDelete = new ThisAbstractAction("delete");
		JButton buttonDelete = new JButton(actDelete);
		buttonDelete.setBackground(Color.WHITE);
		buttonDelete.setBorderPainted(false);
		buttonDelete.setIcon(new ImageIcon("Slike/trash-24.png"));
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
		
		ThisAbstractAction actSearch = new ThisAbstractAction("search");
		JButton buttonSearch = new JButton(actSearch);
		buttonSearch.setBackground(Color.WHITE);
		buttonSearch.setBorderPainted(false);
		//buttonSearch.setIcon(new ImageIcon("Slike/search-24.png"));
		this.add(buttonSearch);
		
		this.add(Box.createHorizontalStrut(20));
		this.setBackground(Color.WHITE);
	}


}
