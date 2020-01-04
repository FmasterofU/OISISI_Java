package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewStudenti;

/**
 * @author fmaster rammba
 * @implNote Controlling actions transfered from view to model, with care for data consistency
 */
public class PredmetController {

	/**
	 * @param novi new Subject to be added into Model
	 */
	public static void addPredmet(Predmet novi) {
		Data.getListaPredmeta().addPredmet(novi);
		ViewPredmeti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}

	/**
	 * @param p Subject to be deleted from Model
	 * @param ma which action is in progress
	 */
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

	/**
	 * @param sifra key value of the Subject to be edited in Model
	 * @param novi new Subject with updated data in it
	 * @param ma which action is in progress
	 */
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
