package rs.ac.uns.ftn.ssluzba;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

/**
 * @author fmaster
 * @implNote Starting point
 */
public class Main {

	
	public static String version = "v1.1.0";
	
	/**
	 * @implNote Practically doesn't do a single damn thing :)
	 * Well it does, Data initialization and starts up the MainWindow, version number
	 * @param args discarded
	 */
	public static void main(String[] args) {
		Data.init();
		MainWindow.getInstance().setVisible(true);
	}
}

