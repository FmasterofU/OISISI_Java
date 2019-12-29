package gui.controller;

import gui.model.Data;
import gui.model.Predmet;
import gui.view.centerdata.ViewPredmeti;

public class PredmetController {

	public static void dodajPredmet(Predmet novi) {
		Data.data.listaPredmeta.addPredmet(novi);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void izbrisiPredmet(Predmet p)
	{
		Data.data.listaPredmeta.deletePredmet(p);
		ViewPredmeti.getInstance().updateTable();
	}
}
