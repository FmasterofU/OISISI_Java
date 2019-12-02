package gui.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3474955802889019798L;
	private String sifra, naziv;
	private byte semestar, godinaStudija; 
	private Profesor profesor;
	private ArrayList<Student> studenti;
	
	public Predmet() {
		super();
		this.sifra = "E213A-06";
		this.naziv = "Algebra";
		this.semestar = 1;
		this.godinaStudija = 1;
		this.profesor = new Profesor();
		this.studenti = new ArrayList<Student>();
	}
	
	public Predmet(String sifra, String naziv, byte semestar, byte godinaStudija, Profesor profesor) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.studenti = new ArrayList<Student>();
	}
	
	public Predmet(String sifra, String naziv, byte semestar, byte godinaStudija, Profesor profesor,
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
	
	public byte getSemestar() {
		return semestar;
	}
	
	public void setSemestar(byte semestar) {
		this.semestar = semestar;
	}
	
	public byte getGodinaStudija() {
		return godinaStudija;
	}
	
	public void setGodinaStudija(byte godinaStudija) {
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
}
