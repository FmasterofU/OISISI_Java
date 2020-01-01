package rs.ac.uns.ftn.ssluzba.gui.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3474955802889019798L;
	private String sifra, naziv;
	private Semestar semestar;
	private GodinaStudija godinaStudija; 
	private Profesor profesor;
	private ArrayList<Student> studenti;
	
	public Predmet() {
		super();
		this.sifra = "E213A-06";
		this.naziv = "Algebra";
		this.semestar = Semestar.ZIMSKI;
		this.godinaStudija = GodinaStudija.I;
		this.profesor = new Profesor();
		this.studenti = new ArrayList<Student>();
	}
	
	public Predmet(String sifra, String naziv, Semestar semestar, GodinaStudija godinaStudija, Profesor profesor) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.studenti = new ArrayList<Student>();
	}
	
	public Predmet(String sifra, String naziv, Semestar semestar, GodinaStudija godinaStudija, Profesor profesor,
			ArrayList<Student> studenti) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.studenti = studenti;
	}

	public String getSifra() {
		return sifra;
	}
	
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public Semestar getSemestar() {
		return semestar;
	}
	
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	
	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}
	
	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	
	public Profesor getProfesor() {
		return profesor;
	}
	
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public ArrayList<Student> getStudenti() {
		return studenti;
	}
	
	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Predmet [sifra=");
		builder.append(sifra);
		builder.append(", naziv=");
		builder.append(naziv);
		builder.append(", semestar=");
		builder.append(semestar);
		builder.append(", godinaStudija=");
		builder.append(godinaStudija);
		builder.append(", profesor=");
		builder.append(profesor);
		builder.append(", studenti=");
		builder.append(studenti);
		builder.append("]");
		return builder.toString();
	}
	
	 public static void editPredmet(Predmet p, Predmet novi) {
		 p.setNaziv(novi.getNaziv());
		 p.setSemestar(novi.getSemestar());
		 p.setGodinaStudija(novi.getGodinaStudija());
		 p.setProfesor(novi.getProfesor());
		 p.setStudenti(novi.getStudenti());
	 }

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.getSifra().equals(((Predmet)obj).getSifra());
	}
}
