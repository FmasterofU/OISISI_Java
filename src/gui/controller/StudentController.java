package gui.controller;

import gui.model.Data;
import gui.model.Student;
import gui.view.centerdata.ViewPredmeti;
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
		/*
		 * TODO: 
		 * refresh search tab if active
		*/
		Data.data.listaPredmeta.deleteStudentInList(indeks);
		ViewPredmeti.getInstance().updateTable();
		Data.data.listaStudenata.deleteStudent(indeks);
		ViewStudenti.getInstance().updateTable();
	}
	
	public void editStudent(String indeks, Student s)
	{
		/*
		 * TODO: 
		 * refresh search tab if active
		 */
		Data.data.listaPredmeta.editStudentInList(indeks,s);
		ViewPredmeti.getInstance().updateTable();
		Data.data.listaStudenata.editStudent(indeks, s);
		ViewStudenti.getInstance().updateTable();
	}

}
