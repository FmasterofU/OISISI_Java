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
		
		file.add(new ApstraktnaAkcija("new"));
		file.add(new ApstraktnaAkcija("close"));
		edit.add(new ApstraktnaAkcija("edit"));
		edit.add(new ApstraktnaAkcija("delete"));
		help.add(new ApstraktnaAkcija("help"));
		help.add(new ApstraktnaAkcija("about"));
		
		this.add(file);
		this.add(edit);
		this.add(help);
	}

}
