package listeners_and_actions;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import gui.view.CenterBox;
import gui.view.DodajStudenta;
import gui.view.MainWindow;
import gui.view.ObrisiStudenta;
import gui.view.ViewStudenti;

public class ApstraktnaAkcija extends AbstractAction{

	private static final long serialVersionUID = 4889011984599408652L;
	private String name;
	
	public ApstraktnaAkcija(String s) {
		String rez = s.trim();
		rez = s.toLowerCase();
		name = rez;
		switch(rez)
		{
			case "new":
				{
					putValue(NAME, "New");
					putValue(MNEMONIC_KEY, KeyEvent.VK_N);
					putValue(SMALL_ICON, new ImageIcon("Slike/new.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
					break;
				}
			case "close":
				{
					putValue(NAME, "Close");
					putValue(MNEMONIC_KEY, KeyEvent.VK_C);
					putValue(SMALL_ICON, new ImageIcon("Slike/close.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
					break;
				}
			case "edit":
				{
					putValue(NAME, "Edit");
					putValue(MNEMONIC_KEY, KeyEvent.VK_E);
					putValue(SMALL_ICON, new ImageIcon("Slike/edit.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
					break;
				}
			case "delete":
				{
					putValue(NAME, "Delete");
					putValue(MNEMONIC_KEY, KeyEvent.VK_D);
					putValue(SMALL_ICON, new ImageIcon("Slike/delete.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
					break;
				}
				
			case "help":
				{
					putValue(NAME, "Help");
					putValue(MNEMONIC_KEY, KeyEvent.VK_H);
					putValue(SMALL_ICON, new ImageIcon("Slike/help.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
					break;
				}
			case "about":
				{
					putValue(NAME, "About");
					putValue(MNEMONIC_KEY, KeyEvent.VK_A);
					putValue(SMALL_ICON, new ImageIcon("Slike/about.png"));
					putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
					break;
				}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(name.equals("close")) 
			MainWindow.exit();
		if(name.equals("new"))
		{
			if(CenterBox.getInstance().getSelectedIndex() == 0)
			{
				DodajStudenta.getNew().setVisible(true);
			}

		}
		if(name.equals("delete"))
		{
			if(CenterBox.getInstance().getSelectedIndex() == 0)
			{
				int idx = ViewStudenti.getInstance().getSelectedIndex();
				if(idx != -1)		ObrisiStudenta.getNew(idx).setVisible(true);
			}
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
