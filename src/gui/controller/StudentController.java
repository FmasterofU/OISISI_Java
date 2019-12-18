package gui.controller;

import gui.model.ListaStudenata;
import gui.model.Student;
import gui.view.ViewStudenti;

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
		ListaStudenata.getInstance().dodajStudenta(s);
		ViewStudenti.getInstance().updateTable();
	}
	
	public void izbrisiStudenta(String indeks)
	{
		ListaStudenata.getInstance().izbrisiStudenta(indeks);
		ViewStudenti.getInstance().updateTable();
	}
	
	public void izmeniStudenta(String indeks, Student s)
	{
		ListaStudenata.getInstance().izmeniStudenta(indeks, s);
		ViewStudenti.getInstance().updateTable();
	}

}
