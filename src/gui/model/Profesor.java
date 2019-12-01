package gui.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Profesor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5398649810778780650L;
	private String ime, prezime, datumRodjenja, adresaStanovanja, telefon, 
		eMail, adresaKancelarije,  brojLK, titula, zvanje; 
	private ArrayList<Predmet> predajePredmete;
	
	public Profesor() {
		super();
		this.ime = "Marko";
		this.prezime = "Markovic";
		this.datumRodjenja = "01.01.1970";
		this.adresaStanovanja = "Bulevar Oslobodjenja 1";
		this.telefon = "021/000-000";
		this.eMail = "marko@uns.ac.rs";
		this.adresaKancelarije = "A1";
		this.brojLK = "010100000";
		this.titula = "dr";
		this.zvanje = "Comp.Sci";
		this.predajePredmete = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String telefon,
			String eMail, String adresaKancelarije, String brojLK, String titula, String zvanje) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.eMail = eMail;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLK = brojLK;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predajePredmete = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, String datumRodjenja, String adresaStanovanja, String telefon,
			String eMail, String adresaKancelarije, String brojLK, String titula, String zvanje,
			ArrayList<Predmet> predajePredmete) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.eMail = eMail;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLK = brojLK;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predajePredmete = predajePredmete;
	}
	
	public String getIme() {
		return ime;
	}
	
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	
	public String getBrojLK() {
		return brojLK;
	}
	
	public void setBrojLK(String brojLK) {
		this.brojLK = brojLK;
	}
	
	public String getTitula() {
		return titula;
	}
	
	public void setTitula(String titula) {
		this.titula = titula;
	}
	
	public String getZvanje() {
		return zvanje;
	}
	
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	
	public ArrayList<Predmet> getPredajePredmete() {
		return predajePredmete;
	}
	
	public void setPredajePredmete(ArrayList<Predmet> predajePredmete) {
		this.predajePredmete = predajePredmete;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profesor [ime=");
		builder.append(ime);
		builder.append(", prezime=");
		builder.append(prezime);
		builder.append(", datumRodjenja=");
		builder.append(datumRodjenja);
		builder.append(", adresaStanovanja=");
		builder.append(adresaStanovanja);
		builder.append(", telefon=");
		builder.append(telefon);
		builder.append(", eMail=");
		builder.append(eMail);
		builder.append(", adresaKancelarije=");
		builder.append(adresaKancelarije);
		builder.append(", brojLK=");
		builder.append(brojLK);
		builder.append(", titula=");
		builder.append(titula);
		builder.append(", zvanje=");
		builder.append(zvanje);
		builder.append(", predajePredmete=");
		builder.append(predajePredmete);
		builder.append("]");
		return builder.toString();
	}
}
