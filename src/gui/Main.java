package gui;

import gui.model.Predmet;
import gui.model.Profesor;
import gui.view.MainWindow;
import persistence.Data;

public class Main {

	public static void main(String[] args) {
		Data.init();
		//Data.data.listaPredmeta.addPredmet(new Predmet("fuuuuuuuuuck", "tezak predmet", (byte)5, (byte)3, new Profesor()));
		//Data.data.listaPredmeta.addPredmet(new Predmet("e206", "metode", (byte)5, (byte)3, new Profesor()));
		MainWindow.getInstance().setVisible(true);
	}

}
