package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Profesor;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;

/**
 * @author fmaster rammba
 * @implNote Controlling actions transfered from view to model, with care for data consistency
 */
public class ProfesorController {

	/**
	 * @param p - new Professor to be added to Model
	 */
	public static void addProfesor(Profesor p){
		Data.getListaProfesora().addProfesor(p);
		ViewProfesori.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}

	/**
	 * @param id - key value of the Professor to be edited in Model
	 * @param p - new Professor with updated data in it 
	 */
	public static void editProfesor(String id, Profesor p) {
		Data.getListaPredmeta().editProfesorInList(id,p);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaProfesora().changeProfesor(id, p);
		ViewProfesori.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}

	/**
	 * @param p - Professor to be deleted from Model
	 */
	public static void deleteProfesor(Profesor p){
		Data.getListaPredmeta().deleteProfesorInList(p);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaProfesora().deleteProfesor(p);
		ViewProfesori.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
}
