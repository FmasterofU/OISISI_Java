package gui.controller;

import gui.model.Data;
import gui.model.Profesor;
import gui.view.centerdata.ViewProfesori;

public class ProfesorController {
	
	public static void addProfesora(Profesor p)
	{
		Data.data.listaProfesora.addProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
	
	public static void deleteProfesor(Profesor p)
	{
		Data.data.listaProfesora.deleteProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
	
}
