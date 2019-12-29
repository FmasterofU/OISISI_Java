package gui.controller;

import gui.model.Data;
import gui.model.Student;
import gui.view.centerdata.ViewStudenti;

public class StudentController {
	
	private static StudentController instance = null;
	
	public static StudentController getInstance()
	{
		if(instance == null)	instance = new StudentController();
		return instance;
	}
	
	private StudentController() {}
	
	public void addStudent(Student s)
	{
		Data.data.listaStudenata.addStudent(s);
		ViewStudenti.getInstance().updateTable();
	}
	
	public void deleteStudent(String indeks)
	{
		Data.data.listaStudenata.deleteStudent(indeks);
		ViewStudenti.getInstance().updateTable();
	}
	
	public void editStudent(String indeks, Student s)
	{
		Data.data.listaStudenata.editStudent(indeks, s);
		ViewStudenti.getInstance().updateTable();
	}

}
