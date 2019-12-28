package gui.controller;

import gui.model.Data;
import gui.model.Profesor;
import gui.view.centerdata.ViewProfesori;

public class ProfesorController {
	
	private static ProfesorController instance = null;
	
	public static ProfesorController getInstance()
	{
		if(instance == null)	instance = new ProfesorController();
		return instance;
	}
	
	private ProfesorController() {}
	
	public void dodajProfesora(Profesor p)
	{
		Data.data.listaProfesora.addProfesor(p);
		ViewProfesori.getInstance().updateTable();
	}
}
