package rs.ac.uns.ftn.ssluzba.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.ThisAbstractAction;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.IHighlight;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.TextField;

@SuppressWarnings("serial")
public class ToolBar extends JPanel {
	
	private static ToolBar instance = null;
	public static JPanel currentExpandedToolbarPanel = new JPanel();
	private static String searchQuery = new String();
	private static TextField tf;
	private static JButton buttonSearch;
	
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
		buttonAdd.setToolTipText("Dodaj");
		buttonAdd.setBackground(Color.WHITE);
		buttonAdd.setBorderPainted(false);
		buttonAdd.setIcon(new ImageIcon("Slike/add-property-32.png"));
		this.add(buttonAdd);
		
		ThisAbstractAction actEdit = new ThisAbstractAction("edit");
		JButton buttonEdit = new JButton(actEdit);
		buttonEdit.setToolTipText("Izmijeni");
		buttonEdit.setBackground(Color.WHITE);
		buttonEdit.setBorderPainted(false);
		buttonEdit.setIcon(new ImageIcon("Slike/edit-property-32.png"));
		this.add(buttonEdit);
		
		ThisAbstractAction actDelete = new ThisAbstractAction("delete");
		JButton buttonDelete = new JButton(actDelete);
		buttonDelete.setToolTipText("Ukloni");
		buttonDelete.setBackground(Color.WHITE);
		buttonDelete.setBorderPainted(false);
		buttonDelete.setIcon(new ImageIcon("Slike/remove-property-32.png"));
		this.add(buttonDelete);
		
		currentExpandedToolbarPanel.setMaximumSize(new Dimension());
		this.add(currentExpandedToolbarPanel);
		
		this.add(Box.createGlue());
		
		///is added later, now just declared to be available for text field listener on enter key
		ThisAbstractAction actSearch = new ThisAbstractAction("search");
		buttonSearch = new JButton(actSearch);
		buttonSearch.setToolTipText("Pretra\u017ei");
		buttonSearch.setBackground(Color.WHITE);
		buttonSearch.setBorderPainted(false);
		buttonSearch.setIcon(new ImageIcon("Slike/search-32.png"));
		
		tf = new TextField(30) {
			@Override
			public void maybeHighlight() {
				setBorder(((this.getText().isEmpty() || CheckValidation.checkSearchQuery(this.getText(),CenterBox.getInstance().getSelectedIndex())) ? IHighlight.defaultBorder : IHighlight.highlightBorder));
			}
			/*
			public boolean isEmpty() {
				if(this.getText().isEmpty()) {
					CenterBox.reset(CenterBox.getInstance().getSelectedIndex());
					return true;
				}else return false;
			}*/
		};
		Dimension d = this.getPreferredSize();
		tf.setSize(70, d.height*3/4);
		tf.setMaximumSize(new Dimension(300, d.height*3/4));
		tf.setMinimumSize(new Dimension(300, d.height*3/4));
		tf.setFont(new Font(tf.getFont().getFamily(), tf.getFont().getStyle(), tf.getFont().getSize()+2)); //adding 2 when pictures are 32px
		tf.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				searchQuery = ((JTextField)e.getComponent()).getText();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				focusLost(e);				
			}
		});
		tf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					//searchQuery = tf.getText();
					searchQuery = ((JTextField) e.getComponent()).getText();
					buttonSearch.doClick();
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {}
		});
		this.add(tf);
		
		this.add(buttonSearch);
		
		this.add(Box.createHorizontalStrut(20));
		this.setBackground(Color.WHITE);
	}

	public static String getSearchQuery() {
		return searchQuery;
	}

	public static void resetSearch() {
		tf.setText(null);
		searchQuery = "";
	}

	public static void dynamicChange(int selectedCenterBoxTab) {
		if(!ViewSearch.updateInProgress) ToolBar.resetSearch();
		ToolBar.getInstance().remove(ToolBar.currentExpandedToolbarPanel);
		switch(selectedCenterBoxTab) {
			case 2:
				ToolBar.currentExpandedToolbarPanel = ExpandedToolBarPanel.getInstance();
				break;
			case 3:
				if(ViewPredmeti.inSearchMode==true) {
					ToolBar.currentExpandedToolbarPanel = ExpandedToolBarPanel.getInstance();
					break;
				}
			default:
				ToolBar.currentExpandedToolbarPanel = new JPanel();
				ToolBar.currentExpandedToolbarPanel.setMaximumSize(new Dimension());
		}
		ToolBar.getInstance().add(ToolBar.currentExpandedToolbarPanel, 4);
		ToolBar.getInstance().validate();
		ToolBar.getInstance().repaint();
	}

	public void reSearch() {
		buttonSearch.doClick();
	}
}
