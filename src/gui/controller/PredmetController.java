package gui.controller;

import gui.model.Data;
import gui.model.Predmet;
import gui.view.centerdata.ViewPredmeti;

public class PredmetController {

	public static void addPredmet(Predmet novi) {
		Data.data.listaPredmeta.addPredmet(novi);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void deletePredmet(String sifra)
	{
		Data.data.listaPredmeta.deletePredmet(sifra);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void deletePredmet(Predmet p)
	{
		Data.data.listaPredmeta.deletePredmet(p);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void editPredmet(String sifra, Predmet p)
	{
		Data.data.listaPredmeta.editPredmet(sifra, p);
		ViewPredmeti.getInstance().updateTable();
	}
}
