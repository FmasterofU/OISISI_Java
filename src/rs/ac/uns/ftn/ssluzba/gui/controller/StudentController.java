package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewStudenti;

public class StudentController {
	
	public static void addStudent(Student s){
		Data.getListaStudenata().addStudent(s);
		ViewStudenti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
	
	public static void deleteStudent(String indeks){
		Data.getListaPredmeta().deleteStudentInList(indeks);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaStudenata().deleteStudent(indeks);
		ViewStudenti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
	
	public static void editStudent(String indeks, Student s){
		Data.getListaPredmeta().editStudentInList(indeks,s);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaStudenata().editStudent(indeks, s);
		ViewStudenti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
}
