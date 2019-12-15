package gui;

import gui.view.MainWindow;
import persistence.Data;

public class Main {

	public static void main(String[] args) {
		Data.init();
		MainWindow.getInstance().setVisible(true);
	}

}
