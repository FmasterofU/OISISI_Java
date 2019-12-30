package gui.view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.sun.glass.events.KeyEvent;

import listeners_and_actions.ApstraktnaAkcija;

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
		
		ApstraktnaAkcija aNew = new ApstraktnaAkcija("new");
		ApstraktnaAkcija aClose = new ApstraktnaAkcija("close");
		ApstraktnaAkcija aEdit = new ApstraktnaAkcija("edit");
		ApstraktnaAkcija aDelete = new ApstraktnaAkcija("delete");
		ApstraktnaAkcija aHelp = new ApstraktnaAkcija("help");
		ApstraktnaAkcija aAbout = new ApstraktnaAkcija("about");
		
		file.add(aNew);
		file.add(aClose);
		edit.add(aEdit);
		edit.add(aDelete);
		help.add(aHelp);
		help.add(aAbout);
		
		this.setBackground(new Color(165, 199, 245)); //light blue color picked to be same as inactive tab color
		
		this.add(file);
		this.add(edit);
		this.add(help);
	}

}
