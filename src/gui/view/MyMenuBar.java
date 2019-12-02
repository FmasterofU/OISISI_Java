package gui.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import listeners_and_actions.ApstraktnaAkcija;

public class MyMenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4419127483078704097L;
	
	public MyMenuBar()
	{
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu help = new JMenu("Help");
		
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
		
		this.add(file);
		this.add(edit);
		this.add(help);
	}

}
