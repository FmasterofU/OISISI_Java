package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewStudenti;

public class PredmetController {

	public static void addPredmet(Predmet novi) {
		//Data.data.listaProfesora.getProfesor(novi.getProfesor().getBrojLK()).getPredajePredmete().add(novi);
		//ViewProfesori.getInstance().updateTable();
		//System.out.println(Data.data.listaProfesora);
		Data.data.listaPredmeta.addPredmet(novi);
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void deletePredmet(Predmet p, ModelAction ma)
	{
		/*
		 * TODO:
		 * refresh search tab if active
		 */
		Data.data.listaStudenata.deletePredmetInList(p,ma);
		Data.data.listaProfesora.deletePredmetInList(p,ma);
		Data.data.listaPredmeta.deletePredmet(p,ma);
		ViewStudenti.getInstance().updateTable();
		ViewProfesori.getInstance().updateTable();
		ViewPredmeti.getInstance().updateTable();
	}
	
	public static void editPredmet(String sifra, Predmet novi, ModelAction ma)
	{
		/*
		 * TODO:
		 * refresh search tab if active
		 */
		if(ma==ModelAction.ADD_S/* || ma==ModelAction.DELETE_S*/) {
			Data.data.listaStudenata.editPredmetInList(sifra,novi,ma);
			ViewStudenti.getInstance().updateTable();
		}
		else if(ma==ModelAction.DELETE_S) {
			Data.data.listaStudenata.deletePredmetInList(novi, ma);
		}
		if(ma==ModelAction.ADD_P || ma==ModelAction.DELETE_P) {
			Data.data.listaProfesora.editPredmetInList(sifra,novi,ma);
			ViewProfesori.getInstance().updateTable();
		}
		Data.data.listaPredmeta.editPredmet(sifra, novi);
		ViewPredmeti.getInstance().updateTable();
	}
}
