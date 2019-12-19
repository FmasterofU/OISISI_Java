package gui.model;

import java.io.Serializable;
import java.util.ArrayList;

import persistence.Data;

public class ListaStudenata implements Serializable, IAbstractTableModel {
	
	private static final long serialVersionUID = 3654331325580773015L;
	private static ListaStudenata instance = null;
	private ArrayList<Student> studenti;
	private ArrayList<String> kolone;
	
	public static ListaStudenata getInstance()
	{
		Data.checkStackTrace();
		if(instance == null)
			instance = new ListaStudenata();
		return instance;
	}
	
	private ListaStudenata()
	{
		this.studenti = new ArrayList<Student>();
		this.studenti.add(new Student());
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum roðenja");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	public int getColumnCount()
	{
		return this.kolone.size();
	}
	
	public String getColumnName(int index)
	{
		return kolone.get(index);
	}
	
	public int getRowCount()
	{
		return this.studenti.size();
	}
	
	public Student getRow(int index)
	{
		return this.studenti.get(index);
	}
	
	public String getValueAt(int row, int column)
	{
		Student s = this.studenti.get(row);
		switch(column)
		{
			case 0: 
				return s.getBrIndeksa();
			case 1:
				return s.getIme();
			case 2:
				return s.getPrezime();
			case 3:
				return s.getDatumRodjenja();
			case 4:
				return Byte.toString(s.getGodStudija());
			case 5:
				{
					NacinFinansiranja nf = s.getFinansiranje();
					if(nf == NacinFinansiranja.BUDZET)	return "B";
					else	return "S";
				}
			case 6:
				return Double.toString(s.getProsecnaOcena());
			default:
				return null;
		}
	}
	
	public void dodajStudenta(String ime, String prezime, String datumRodjenja, String adresa, String telefon, String eMail,
			String brIndeksa, String datumUpisa, byte godStudija, NacinFinansiranja finansiranje, double prosecnaOcena)
	{
		this.studenti.add(new Student(ime, prezime, datumRodjenja, adresa, telefon, eMail, brIndeksa, datumUpisa, godStudija, finansiranje, prosecnaOcena));
	}
	
	public void dodajStudenta(Student s)
	{
		this.studenti.add(s);
	}
	
	public void izbrisiStudenta(String brI)
	{
		for(Student s : studenti)
		{
			if(s.getBrIndeksa() == brI)
			{
				this.studenti.remove(s);
				break;
			}
		}
	}
	
	public void izmeniStudenta(String brI, String ime, String prezime, String datumRodjenja, String adresa, String telefon, String eMail,
			String datumUpisa, byte godStudija, NacinFinansiranja finansiranje, double prosecnaOcena)
	{
		for(Student s : studenti)
		{
			if(s.getBrIndeksa() == brI)
			{
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresa(adresa);
				s.setTelefon(telefon);
				s.seteMail(eMail);
				s.setDatumUpisa(datumUpisa);
				s.setGodStudija(godStudija);
				s.setFinansiranje(finansiranje);
				s.setProsecnaOcena(prosecnaOcena);
				break;
			}
		}
	}
	
	public void izmeniStudenta(String brI, Student s)
	{
		for(Student stud : studenti)
		{
			if(stud.getBrIndeksa() == brI)
			{
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
				break;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaStudenata [studenti=");
		for(Student s : studenti)
		{
			builder.append(s);
			builder.append(", ");
		}
		builder.append("]");
		return builder.toString();
	}
}
