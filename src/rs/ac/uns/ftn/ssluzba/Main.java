package rs.ac.uns.ftn.ssluzba;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		Data.init();
		MainWindow.getInstance().setVisible(true);
	}
}

