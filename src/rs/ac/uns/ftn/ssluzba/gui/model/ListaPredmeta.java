package rs.ac.uns.ftn.ssluzba.gui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;

public class ListaPredmeta implements Serializable, ITableModel {

	private static final long serialVersionUID = -8045180299982898373L;
	private LinkedList<Predmet> predmeti;
	private static ArrayList<String> kolone;
	
	static {
		kolone = new ArrayList<String>();
		kolone.add("Šifra");
		kolone.add("Naziv");
		kolone.add("Semestar");
		kolone.add("Godina");
		kolone.add("Profesor");
		kolone.add("Studenti");
	}
	
	public ListaPredmeta() {
		this.setPredmeti(new LinkedList<Predmet>());
	}
	
	public ListaPredmeta(ListaPredmeta lp) {
		this.predmeti = new LinkedList<Predmet>();
		for(Predmet p : lp.predmeti)
			predmeti.add(p);
	}

	public LinkedList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(LinkedList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public void addPredmet(Predmet predmet) {
		predmeti.add(predmet);
	}
	
	 public Predmet getPredmet(String sifra) {
		 for(Predmet p : predmeti)
			 if(p.getSifra().equals(sifra))
				 return p;
		 return null;
	 }
	 /*
	 public void changePredmet(String sifra, Predmet p) {
		 deletePredmet(getPredmet(sifra));
		 addPredmet(p);
	 }
	 */
	 public void editPredmet(String sifra, Predmet novi) {
		 Predmet p = getPredmet(sifra);
		 p.setNaziv(novi.getNaziv());
		 p.setSemestar(novi.getSemestar());
		 p.setGodinaStudija(novi.getGodinaStudija());
		 p.setProfesor(novi.getProfesor());
		 p.setStudenti(novi.getStudenti());
	 }
	 
	 public void deletePredmet(String sifra) {
		 predmeti.remove(getPredmet(sifra));
	 }
	 
	 public void deletePredmet(Predmet p, ModelAction ma) {
		 predmeti.remove(p);
	 }
	 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaPredmeta [predmeti=");
		builder.append(predmeti);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return predmeti.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predmet p = predmeti.get(rowIndex);
		switch(columnIndex) 
		{
			case 0:
				return p.getSifra();
			case 1:
				return p.getNaziv();
			case 2:
				return p.getSemestar();
			case 3:
				return p.getGodinaStudija();
			case 4:
				if (p.getProfesor() != null)
					return p.getProfesor().getIme()+" "+p.getProfesor().getPrezime();
				else	return "Niko ne predaje";
			case 5:
				//return p.getStudenti();
				return p.haveStudentsString();
			default:
				return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return kolone.get(col);
	}

	public boolean predmetCodeExists(String text) {
		for(Predmet p : predmeti)
			if(p.getSifra().equals(text))
				return true;
		return false;
	}

	public void deleteStudentInList(String indeks) {
		for(Predmet p : predmeti)
			if(p.getStudenti()!=null)
				for(Student s : p.getStudenti())
					if(s.getBrIndeksa().equals(indeks)) {
						p.getStudenti().remove(s);
						break;
					}
	}

	public void editStudentInList(String indeks, Student stud) {
		for(Predmet p : predmeti)
			if(p.getStudenti()!=null)
				for(Student s : p.getStudenti())
					if(s.getBrIndeksa().equals(indeks))
						Student.editStudent(s, stud);
	}

	public void deleteProfesorInList(Profesor p) {
		for(Predmet pred : predmeti)
			if(pred.getProfesor()!=null && pred.getProfesor().getBrojLK().equals(p.getBrojLK()))
				pred.setProfesor(null);
	}

	public void editProfesorInList(String id, Profesor p) {
		for(Predmet pred : predmeti)
			if(pred.getProfesor()!=null && pred.getProfesor().getBrojLK().equals(id))
				Profesor.changeProfesor(pred.getProfesor(), p);
	}

	@Override
	public boolean isEmpty() {
		return predmeti.isEmpty();
	}
	
	public ArrayList<String> getStudentIndexesNotListeningPredmet(Predmet p)
	{
		ArrayList<String> ret = Data.getListaStudenata().getListOfStudentIndexes(p.getGodinaStudija());
		for(Student stud : p.getStudenti())
		{
			if(ret.contains(stud.getBrIndeksa()) || (stud.getGodStudija() != p.getGodinaStudija()))
				ret.remove(stud.getBrIndeksa());
		}
		return ret;
	}
	
	public ArrayList<String> getStudentIndexesListeningPredmet(Predmet p)
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(Student stud : p.getStudenti())
		{
			ret.add(stud.getBrIndeksa());
		}
		return ret;
	}
	
	public ArrayList<Student> getStudents(String s)
	{
		ArrayList<Student> ret = new ArrayList<Student>();
		if(s != "")
		{
			String[] splits = s.split(" ");
			for(String spl : splits)
				ret.add(Data.getListaStudenata().getStudentByKey(spl));
		}
		return ret;
	}

	public ListaPredmeta mutableSearch(String searchQuery) {
		// TODO Auto-generated method stub
		return this;
	}
}
