package rs.ac.uns.ftn.ssluzba;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

public class Main {

	/**
	 * Practically doesn't do a single damn thing :)
	 * @param args discarded
	 */
	public static void main(String[] args) {
		Data.init();
		MainWindow.getInstance().setVisible(true);
	}
}

