package rs.ac.uns.ftn.ssluzba.gui.model;

import java.awt.TextField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;

/**
 *  @author fmaster
 *	@implNote list of all data for {@link Predmet}, class implementing {@link ITableModel} and {@link Serializable}
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
		
		// Default mode setup
		
		Predmet p = new Predmet("OP301", "Osnove programiranja", Semestar.ZIMSKI, GodinaStudija.I, null);
		predmeti.add(p);
		p.setProfesor(Data.getListaProfesora().getProfesor("007198721"));
		Data.getListaProfesora().editPredmetInList(p.getSifra(), p, ModelAction.ADD_P);
		this.editPredmet(p.getSifra(), p);
		ArrayList<Student> initial = new ArrayList<Student>();
		initial.add(Data.getListaStudenata().getStudentByKey("RA1/2019"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA5/2019"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA3/2019"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA2/2019"));
		p.setStudenti(initial);
		Data.getListaStudenata().editPredmetInList(p.getSifra(), p, ModelAction.ADD_S);
		this.editPredmet(p.getSifra(), p);
		
		p = new Predmet("DM881", "Diskretna matematika", Semestar.ZIMSKI, GodinaStudija.II, null);
		predmeti.add(p);
		p.setProfesor(Data.getListaProfesora().getProfesor("008431903"));
		Data.getListaProfesora().editPredmetInList(p.getSifra(), p, ModelAction.ADD_P);
		this.editPredmet(p.getSifra(), p);
		initial = new ArrayList<Student>();
		initial.add(Data.getListaStudenata().getStudentByKey("RA3/2018"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA15/2018"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA133/2017"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA122/2017"));
		p.setStudenti(initial);
		Data.getListaStudenata().editPredmetInList(p.getSifra(), p, ModelAction.ADD_S);
		this.editPredmet(p.getSifra(), p);
		
		p = new Predmet("PP007", "Paralelno programiranje", Semestar.ZIMSKI, GodinaStudija.III, null);
		predmeti.add(p);
		p.setProfesor(Data.getListaProfesora().getProfesor("005671007"));
		Data.getListaProfesora().editPredmetInList(p.getSifra(), p, ModelAction.ADD_P);
		this.editPredmet(p.getSifra(), p);
		initial = new ArrayList<Student>();
		initial.add(Data.getListaStudenata().getStudentByKey("RA1/2017"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA5/2017"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA33/2017"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA152/2016"));
		p.setStudenti(initial);
		Data.getListaStudenata().editPredmetInList(p.getSifra(), p, ModelAction.ADD_S);
		this.editPredmet(p.getSifra(), p);
		
		p = new Predmet("RVP33", "Ra\u010dunarstvo visokih performansi", Semestar.ZIMSKI, GodinaStudija.IV, null);
		predmeti.add(p);
		p.setProfesor(Data.getListaProfesora().getProfesor("009999331"));
		Data.getListaProfesora().editPredmetInList(p.getSifra(), p, ModelAction.ADD_P);
		this.editPredmet(p.getSifra(), p);
		initial = new ArrayList<Student>();
		initial.add(Data.getListaStudenata().getStudentByKey("RA1/2016"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA5/2016"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA33/2015"));
		initial.add(Data.getListaStudenata().getStudentByKey("RA102/2015"));
		p.setStudenti(initial);
		Data.getListaStudenata().editPredmetInList(p.getSifra(), p, ModelAction.ADD_S);
		this.editPredmet(p.getSifra(), p);
		
		p = new Predmet("JSD91", "Jezici specifi\u010dni za domen", Semestar.LJETNJI, GodinaStudija.IV, null);
		predmeti.add(p);
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
	 * @param sifra keyValue for searching {@link Predmet}
	 * @return {@link Predmet} with sifra or null
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
	 * @param sifra keyValue for {@link Predmet}
	 * @param novi new {@link Predmet} that will override old
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
	 * @implNote deletes {@link Predmet}
	 * @param p {@link Predmet} instance to be removed (see {@link Predmet} equals method)
	 * @param ma unused
	 */
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
	 * @param text potentially keyValue
	 * @return false if {@link Predmet} with text does not exists
	 */
	public boolean predmetCodeExists(String text) {
		for(Predmet p : predmeti)
			if(p.getSifra().equals(text))
				return true;
		return false;
	}

	/**
	 *  deletes {@link Student} with indeks from {@link ListaPredmeta}
	 * @param indeks keyValue for deleting {@link Student}
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
	 * @param indeks keyValue for editing {@link Student}
	 * @param stud updated {@link Student}
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
	 * @param p deleting {@link Profesor}
	 */
	public void deleteProfesorInList(Profesor p) {
		for(Predmet pred : predmeti)
			if(pred.getProfesor()!=null && pred.getProfesor().getBrojLK().equals(p.getBrojLK()))
				pred.setProfesor(null);
	}

	/**
	 * @param id keyValue for editing {@link Profesor}
	 * @param p updated {@link Profesor}
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
	 * @param p input {@link Predmet}
	 * @return {@link ArrayList} with {@link Student} keyValues who are on the same year as {@link Predmet} p and not listening p
	 */
	public ArrayList<String> getStudentIndexesNotListeningPredmet(Predmet p) {
		ArrayList<String> ret = Data.getListaStudenata().getListOfStudentIndexes(p.getGodinaStudija());
		for(Student stud : p.getStudenti()) 
			if(ret.contains(stud.getBrIndeksa()) || (stud.getGodStudija() != p.getGodinaStudija()))
				ret.remove(stud.getBrIndeksa());
		return ret;
	}

	/**
	 * @param p input {@link Predmet}
	 * @return {@link ArrayList} with {@link Student} keyValues who are listening {@link Predmet} p
	 */
	public ArrayList<String> getStudentIndexesListeningPredmet(Predmet p){
		ArrayList<String> ret = new ArrayList<String>();
		for(Student stud : p.getStudenti())
			ret.add(stud.getBrIndeksa());
		return ret;
	}

	/**
	 * @param s String of {@link Student} keyValues separated with spaceCharacter
	 * @return {@link ArrayList} of {@link Student}s with keyValues in {@link String} s
	 */
	public ArrayList<Student> getStudents(String s) {
		ArrayList<Student> ret = new ArrayList<Student>();
		if(s != "") {
			String[] splits = s.split(" ");
			for(String spl : splits)
				ret.add(Data.getListaStudenata().getStudentByKey(spl));
		}
		return ret;
	}

	/**
	 * @author fmaster
	 * @implNote ATTENTION: mutates state of <code>this</code>
	 * @param searchQuery input from Search {@link TextField}
	 * @return {@link ListaPredmeta} with {@link Predmet}s which fulfills data in search
	 */
	public ListaPredmeta mutableSearch(String searchQuery) {
		String[][] magic = CheckValidation.tokenizeSearchQuery(searchQuery, 1);
		Predmet[] p = {new Predmet()};
		for(Predmet pred : this.predmeti.toArray(p)) 
			for(int i=0;i<magic[1].length;i++)
				if(magic[0][i].equals("Semestar"))
					if(!((Semestar)pred.get(kolone.indexOf(magic[0][i]))).equals(Semestar.getSemestar(magic[1][i]))){
						this.predmeti.remove(pred);
						break;
					} else continue;
				else if(magic[0][i].equals("Godina"))
					if(!((GodinaStudija)pred.get(kolone.indexOf(magic[0][i]))).equals(GodinaStudija.getGodinaStudija(magic[1][i]))){
						this.predmeti.remove(pred);
						break;
					} else continue;
				else if(!((String)pred.get(kolone.indexOf(magic[0][i]))).equals(magic[1][i])){
					this.predmeti.remove(pred);
					break;
				}
		return this;
	}
}
