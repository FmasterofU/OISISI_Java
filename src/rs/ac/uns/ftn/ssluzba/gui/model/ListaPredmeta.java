package rs.ac.uns.ftn.ssluzba.gui.model;

import java.awt.TextField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;

/**
 *		list of all data for {@link Predmet}
 */
public class ListaPredmeta implements Serializable, ITableModel {

	private static final long serialVersionUID = -8045180299982898373L;
	private LinkedList<Predmet> predmeti;
	public static ArrayList<String> kolone;
	
	static {
		kolone = new ArrayList<String>();
		kolone.add("\u0160ifra");
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
	
	 /**
	 * @param sifra - keyValue for searching {@link Predmet}
	 * @return - {@link Predmet} with sifra or null
	 */
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
	 /**
	 * @param sifra - keyValue for {@link Predmet}
	 * @param novi - new {@link Predmet} that will override old
	 */
	public void editPredmet(String sifra, Predmet novi) {
		 Predmet p = getPredmet(sifra);
		 p.setNaziv(novi.getNaziv());
		 p.setSemestar(novi.getSemestar());
		 p.setGodinaStudija(novi.getGodinaStudija());
		 p.setProfesor(novi.getProfesor());
		 p.setStudenti(novi.getStudenti());
	 }
	 
	 /**
	 *		deletes {@link Predmet} with keyValue sifra 
	 * @param sifra - keyValue for deleting {@link Predmet}
	 */
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

	/**
	 * @param text - potentially keyValue
	 * @return - false if {@link Predmet} with text does not exists
	 */
	public boolean predmetCodeExists(String text) {
		for(Predmet p : predmeti)
			if(p.getSifra().equals(text))
				return true;
		return false;
	}

	/**
	 *  deletes {@link Student} with indeks from {@link ListaPredmeta}
	 * @param indeks - keyValue for deleting {@link Student}
	 */
	public void deleteStudentInList(String indeks) {
		for(Predmet p : predmeti)
			if(p.getStudenti()!=null)
				for(Student s : p.getStudenti())
					if(s.getBrIndeksa().equals(indeks)) {
						p.getStudenti().remove(s);
						break;
					}
	}

	/**
	 *
	 * @param indeks - keyValue for editing {@link Student}
	 * @param stud - updated {@link Student}
	 */
	public void editStudentInList(String indeks, Student stud) {
		for(Predmet p : predmeti)
			if(p.getStudenti()!=null)
				for(Student s : p.getStudenti())
					if(s.getBrIndeksa().equals(indeks))
						Student.editStudent(s, stud);
	}

	/**
	 * 	deletes p from {@link ListaPredmeta}
	 * @param p - deleting {@link Profesor}
	 */
	public void deleteProfesorInList(Profesor p) {
		for(Predmet pred : predmeti)
			if(pred.getProfesor()!=null && pred.getProfesor().getBrojLK().equals(p.getBrojLK()))
				pred.setProfesor(null);
	}

	/**
	 * @param id - keyValue for editing {@link Profesor}
	 * @param p - updated {@link Profesor}
	 */
	public void editProfesorInList(String id, Profesor p) {
		for(Predmet pred : predmeti)
			if(pred.getProfesor()!=null && pred.getProfesor().getBrojLK().equals(id))
				Profesor.changeProfesor(pred.getProfesor(), p);
	}

	@Override
	public boolean isEmpty() {
		return predmeti.isEmpty();
	}
	
	/**
	 * @param p - input {@link Predmet}
	 * @return - {@link ArrayList} with {@link Student} keyValues who are on the same year as {@link Predmet} p and not listening p
	 */
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
	
	/**
	 * @param p - input {@link Predmet}
	 * @return - {@link ArrayList} with {@link Student} keyValues who are listening {@link Predmet} p
	 */
	public ArrayList<String> getStudentIndexesListeningPredmet(Predmet p)
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(Student stud : p.getStudenti())
		{
			ret.add(stud.getBrIndeksa());
		}
		return ret;
	}
	
	/**
	 * @param s - String of {@link Student} keyValues separated with spaceCharacter
	 * @return - {@link ArrayList} of {@link Student}s with keyValues in {@link String} s
	 */
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

	/**
	 * @param searchQuery - input from Search {@link TextField}
	 * @return {@link ListaPredmeta} with {@link Predmet}s which fulfills data in search
	 */
	public ListaPredmeta mutableSearch(String searchQuery) {
		String[][] magic = CheckValidation.tokenizeSearchQuery(searchQuery, 1);
		Predmet[] p = {new Predmet()};
		for(Predmet pred : this.predmeti.toArray(p)) 
			for(int i=0;i<magic[1].length;i++)
				if(!((String)pred.get(kolone.indexOf(magic[0][i]))).equals(magic[1][i])){
					this.predmeti.remove(pred);
					break;
				}
		return this;
	}
}
