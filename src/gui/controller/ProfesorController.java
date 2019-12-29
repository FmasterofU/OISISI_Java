package gui.controller;

import gui.model.Data;
import gui.model.Profesor;
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
		 * edit in predmeti
		 * edit profesori
		 * update profesori
		 * update predmeti
		 * refresh search tab if active
		 */
	}
	
	public static void deleteProfesor(Profesor p)
	{
		/*
		 * TODO:
		 * delete from predmeti
		 * update predmeti
		 * refresh search tab if active
		 */
		Data.data.listaProfesora.deleteProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
	
}
