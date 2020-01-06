package rs.ac.uns.ftn.ssluzba.gui.view;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions.ThisAbstractAction;

public class MenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4419127483078704097L;
	private static JMenuBar instance = null;
	public static JMenuBar getInstance()
	{
		if(instance == null)	instance = new MenuBar();
		return instance;
	}
	
	private MenuBar()
	{
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
		file.setMnemonic(KeyEvent.VK_F);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);
		
		ThisAbstractAction aNew = new ThisAbstractAction("new");
		ThisAbstractAction aClose = new ThisAbstractAction("close");
		ThisAbstractAction aEdit = new ThisAbstractAction("edit");
		ThisAbstractAction aDelete = new ThisAbstractAction("delete");
		ThisAbstractAction aHelp = new ThisAbstractAction("help");
		ThisAbstractAction aAbout = new ThisAbstractAction("about");
		
		file.add(aNew);
		file.add(aClose);
		edit.add(aEdit);
		edit.add(aDelete);
		help.add(aHelp);
		help.add(aAbout);
		
		this.setBackground(CenterBox.getInstance().getBackground()); //light blue, same as inactive tab color in centerbox
		
		this.add(file);
		this.add(edit);
		this.add(help);
	}

}
