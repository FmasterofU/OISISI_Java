package gui.controller;

import gui.model.Student;
import gui.view.centerdata.ViewStudenti;
import persistence.Data;

public class StudentController {
	
	private static StudentController instance = null;
	
	public static StudentController getInstance()
	{
		if(instance == null)	instance = new StudentController();
		return instance;
	}
	
	private StudentController() {}
	
	public void dodajStudenta(Student s)
	{
		Data.data.listaStudenata.dodajStudenta(s);
		ViewStudenti.getInstance().updateTable();
	}
	
	public void izbrisiStudenta(String indeks)
	{
		Data.data.listaStudenata.izbrisiStudenta(indeks);
		ViewStudenti.getInstance().updateTable();
	}
	
	public void izmeniStudenta(String indeks, Student s)
	{
		Data.data.listaStudenata.izmeniStudenta(indeks, s);
		ViewStudenti.getInstance().updateTable();
	}

}
