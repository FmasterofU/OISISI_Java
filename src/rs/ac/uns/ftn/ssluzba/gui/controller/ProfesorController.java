package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.Profesor;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;

public class ProfesorController {
	
	public static void addProfesor(Profesor p)
	{
		Data.data.listaProfesora.addProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
	
	public static void editProfesor(String id, Profesor p) {
		/*
		 * TODO:
		 * refresh search tab if active
		 */
		Data.data.listaPredmeta.editProfesorInList(id,p);
		ViewPredmeti.getInstance().updateTable();
		Data.data.listaProfesora.changeProfesor(id, p);
		ViewProfesori.getInstance().updateTable();
	}
	
	public static void deleteProfesor(Profesor p)
	{
		/*
		 * TODO:
		 * refresh search tab if active
		 */
		//System.out.println(Data.data.listaPredmeta);
		Data.data.listaPredmeta.deleteProfesorInList(p);
		ViewPredmeti.getInstance().updateTable();
		Data.data.listaProfesora.deleteProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
}
