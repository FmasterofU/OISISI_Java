package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewPredmeti;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewSearch;
import rs.ac.uns.ftn.ssluzba.gui.view.centerdata.ViewStudenti;

/**
 * @author rammba fmaster
 * @implNote Controlling actions transfered from view to model, with care for data consistency
 */
public class StudentController {

	/**
	 * @param s - new Student to be added to Model
	 */
	public static void addStudent(Student s){
		Data.getListaStudenata().addStudent(s);
		ViewStudenti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}

	/**
	 * @param indeks - key value of the Student to be deleted from Model
	 */
	public static void deleteStudent(String indeks){
		Data.getListaPredmeta().deleteStudentInList(indeks);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaStudenata().deleteStudent(indeks);
		ViewStudenti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}

	/**
	 * @param indeks - key value of the Student to be edited in Model
	 * @param s - new Student with updated data in it
	 */
	public static void editStudent(String indeks, Student s){
		Data.getListaPredmeta().editStudentInList(indeks,s);
		ViewPredmeti.getInstance().updateTable();
		Data.getListaStudenata().editStudent(indeks, s);
		ViewStudenti.getInstance().updateTable();
		if(ViewSearch.instanceIfExists()!=null)
			ViewSearch.instanceIfExists().updateTable();
	}
}
