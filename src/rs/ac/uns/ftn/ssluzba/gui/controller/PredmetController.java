package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewStudenti;

public class PredmetController {

	public static void addPredmet(Predmet novi) {
		Data.getListaPredmeta().addPredmet(novi);
		ViewPredmeti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
	
	public static void deletePredmet(Predmet p, ModelAction ma){
		Data.getListaStudenata().deletePredmetInList(p,ma);
		ViewStudenti.getInstance().updateTable();
		Data.getListaProfesora().deletePredmetInList(p,ma);
		ViewProfesori.getInstance().updateTable();
		Data.getListaPredmeta().deletePredmet(p,ma);
		ViewPredmeti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
	
	public static void editPredmet(String sifra, Predmet novi, ModelAction ma){
		if(ma==ModelAction.ADD_S/* || ma==ModelAction.DELETE_S*/) {
			Data.getListaStudenata().editPredmetInList(sifra,novi,ma);
			ViewStudenti.getInstance().updateTable();
		}
		else if(ma==ModelAction.DELETE_S) {
			Data.getListaStudenata().deletePredmetInList(novi, ma);
			ViewStudenti.getInstance().updateTable();
		}
		if(ma==ModelAction.ADD_P || ma==ModelAction.DELETE_P) {
			Data.getListaProfesora().editPredmetInList(sifra,novi,ma);
			ViewProfesori.getInstance().updateTable();
		}
		Data.getListaPredmeta().editPredmet(sifra, novi);
		ViewPredmeti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
}
