package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Profesor;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewProfesori;

public class ProfesorController {
	
	public static void addProfesor(Profesor p)
	{
		Data.getListaProfesora().addProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
	
	public static void editProfesor(String id, Profesor p) {
		/*
		 * TODO:
		 * refresh search tab if active
		 */
		Data.getListaPredmeta().editProfesorInList(id,p);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaProfesora().changeProfesor(id, p);
		ViewProfesori.getInstance().updateTable();
	}
	
	public static void deleteProfesor(Profesor p)
	{
		/*
		 * TODO:
		 * refresh search tab if active
		 */
		//System.out.println(Data.data.listaPredmeta);
		Data.getListaPredmeta().deleteProfesorInList(p);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaProfesora().deleteProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
}
