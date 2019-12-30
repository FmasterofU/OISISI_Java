package gui.controller;

import gui.model.Data;
import gui.model.Predmet;
import gui.view.centerdata.ViewPredmeti;
import gui.view.centerdata.ViewProfesori;
import gui.view.centerdata.ViewStudenti;

public class PredmetController {

	public static void addPredmet(Predmet novi) {
		Data.data.listaPredmeta.addPredmet(novi);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void deletePredmet(Predmet p)
	{
		/*
		 * TODO:
		 * refresh search tab if active
		 */
		Data.data.listaStudenata.deletePredmetInList(p);
		ViewStudenti.getInstance().updateTable();
		Data.data.listaProfesora.deletePredmetInList(p);
		ViewProfesori.getInstance().updateTable();
		Data.data.listaPredmeta.deletePredmet(p);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void editPredmet(String sifra, Predmet novi)
	{
		/*
		 * TODO:
		 * refresh search tab if active
		 */
		Data.data.listaStudenata.editPredmetInList(sifra,novi);
		ViewStudenti.getInstance().updateTable();
		Data.data.listaProfesora.editPredmetInList(sifra,novi);
		ViewProfesori.getInstance().updateTable();
		Data.data.listaPredmeta.editPredmet(sifra, novi);
		ViewPredmeti.getInstance().updateTable();
	}
}
