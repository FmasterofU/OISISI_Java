package gui.controller;

import gui.model.Data;
import gui.model.Predmet;
import gui.view.centerdata.ViewPredmeti;

public class PredmetController {

	public static void addPredmet(Predmet novi) {
		Data.data.listaPredmeta.addPredmet(novi);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void deletePredmet(Predmet p)
	{
		/*
		 * TODO:
		 * delete from profesori
		 * update profesori
		 * refresh search tab if active
		 */
		Data.data.listaPredmeta.deletePredmet(p);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void editPredmet(String sifra, Predmet novi)
	{
		/*
		 * TODO:
		 * edit in profesori
		 * update profesori
		 * refresh search tab if active
		 */
		Data.data.listaPredmeta.editPredmet(sifra, novi);
		ViewPredmeti.getInstance().updateTable();
	}
}
