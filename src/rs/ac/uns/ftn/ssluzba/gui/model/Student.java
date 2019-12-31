package rs.ac.uns.ftn.ssluzba.gui.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 5260140464028562379L;
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresa;
	private String telefon;
	private String eMail;
	private String brIndeksa;
	private String datumUpisa;
	private GodinaStudija godStudija;
	private NacinFinansiranja finansiranje;
	private double prosecnaOcena;
	private ArrayList<Predmet> slusaPredmete;
	
	public Student(String ime, String prezime, String datumRodjenja, String adresa, String telefon, String eMail,
			String brIndeksa, String datumUpisa, GodinaStudija godStudija, NacinFinansiranja finansiranje, double prosecnaOcena) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.eMail = eMail;
		this.brIndeksa = brIndeksa;
		this.datumUpisa = datumUpisa;
		this.godStudija = godStudija;
		this.finansiranje = finansiranje;
		this.prosecnaOcena = prosecnaOcena;
		this.slusaPredmete = new ArrayList<Predmet>();
	}
	
	public Student(String ime, String prezime, String datumRodjenja, String adresa, String telefon, String eMail, String brIndeksa, 
			String datumUpisa, GodinaStudija godStudija, NacinFinansiranja finansiranje, double prosecnaOcena, ArrayList<Predmet> slusaPredmete) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.eMail = eMail;
		this.brIndeksa = brIndeksa;
		this.datumUpisa = datumUpisa;
		this.godStudija = godStudija;
		this.finansiranje = finansiranje;
		this.prosecnaOcena = prosecnaOcena;
		this.slusaPredmete = slusaPredmete;
	}
	
	public Student() {
		super();
		this.ime = "Pera";
		this.prezime = "Perić";
		this.datumRodjenja = "01.01.1950.";
		this.adresa = "Bulevar Oslobođenja 1, Novi Sad";
		this.telefon = "060/111-111";
		this.eMail = "pera.peric@gmail.com";
		this.brIndeksa = "BR1/2000";
		this.datumUpisa = "01.10.2000.";
		this.godStudija = GodinaStudija.I;
		this.finansiranje = NacinFinansiranja.BUDŽET;
		this.prosecnaOcena = 5.0;
		this.slusaPredmete = new ArrayList<Predmet>();
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
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

	public String getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

	public String getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(String datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public GodinaStudija getGodStudija() {
		return godStudija;
	}

	public void setGodStudija(GodinaStudija godStudija) {
		this.godStudija = godStudija;
	}

	public NacinFinansiranja getFinansiranje() {
		return finansiranje;
	}

	public void setFinansiranje(NacinFinansiranja finansiranje) {
		this.finansiranje = finansiranje;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<Predmet> getSlusaPredmete() {
		return slusaPredmete;
	}

	public void setSlusaPredmete(ArrayList<Predmet> slusaPredmete) {
		this.slusaPredmete = slusaPredmete;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [ime=");
		builder.append(ime);
		builder.append(", prezime=");
		builder.append(prezime);
		builder.append(", datumRođenja=");
		builder.append(datumRodjenja);
		builder.append(", adresa=");
		builder.append(adresa);
		builder.append(", telefon=");
		builder.append(telefon);
		builder.append(", eMail=");
		builder.append(eMail);
		builder.append(", brIndeksa=");
		builder.append(brIndeksa);
		builder.append(", datumUpisa=");
		builder.append(datumUpisa);
		builder.append(", godStudija=");
		builder.append(godStudija);
		builder.append(", finansiranje=");
		builder.append(finansiranje);
		builder.append(", prosečnaOcena=");
		builder.append(prosecnaOcena);
		builder.append(".\n\t\tSluša predmete sa šiframa: ");
		
		if(slusaPredmete.isEmpty())		builder.append("Ne sluša niti jedan predmet! ");
		else
		{
			for(Predmet s : slusaPredmete)
			{
				builder.append(s.getSifra());
				builder.append(" ");
			}
		}
		builder.append("]");
		return builder.toString();
	}
	
	public static void editStudent(Student stud, Student s){
		stud.setIme(s.getIme());
		stud.setPrezime(s.getPrezime());
		stud.setDatumRodjenja(s.getDatumRodjenja());
		stud.setAdresa(s.getAdresa());
		stud.setTelefon(s.getTelefon());
		stud.seteMail(s.geteMail());
		stud.setDatumUpisa(s.getDatumUpisa());
		stud.setGodStudija(s.getGodStudija());
		stud.setFinansiranje(s.getFinansiranje());
		stud.setProsecnaOcena(s.getProsecnaOcena());
		stud.setSlusaPredmete(s.getSlusaPredmete());
	}
}
