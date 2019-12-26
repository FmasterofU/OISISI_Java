package gui.controller;

import gui.model.Data;
import gui.model.Predmet;
import gui.view.centerdata.ViewPredmeti;

public class PredmetController {

	private static PredmetController instance = null;
	
	public static PredmetController getInstance()
	{
		if(instance == null)	instance = new PredmetController();
		return instance;
	}

	public void dodajPredmet(Predmet novi) {
		Data.data.listaPredmeta.addPredmet(novi);
		((ViewPredmeti) ViewPredmeti.getInstance()).updateTable();
	}
	
}
