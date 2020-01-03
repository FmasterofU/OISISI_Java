package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Profesor;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;

public class ProfesorController {
	
	public static void addProfesor(Profesor p){
		Data.getListaProfesora().addProfesor(p);
		ViewProfesori.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
	
	public static void editProfesor(String id, Profesor p) {
		Data.getListaPredmeta().editProfesorInList(id,p);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaProfesora().changeProfesor(id, p);
		ViewProfesori.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
	
	public static void deleteProfesor(Profesor p){
		Data.getListaPredmeta().deleteProfesorInList(p);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaProfesora().deleteProfesor(p);
		ViewProfesori.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
}
