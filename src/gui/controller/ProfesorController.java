package gui.controller;

import gui.model.Data;
import gui.model.Profesor;
import gui.view.centerdata.ViewPredmeti;
import gui.view.centerdata.ViewProfesori;

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
		Data.data.listaPredmeta.deleteProfesorInList(p);
		ViewPredmeti.getInstance().updateTable();
		Data.data.listaProfesora.deleteProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
}
