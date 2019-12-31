package gui.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import gui.view.MainWindow;

public class ListaStudenata implements Serializable, ITableModel {
	
	private static final long serialVersionUID = 3654331325580773015L;
	private static ListaStudenata instance = null;
	private ArrayList<Student> studenti;
	private static ArrayList<String> kolone;
	
	static {
		kolone = new ArrayList<String>();
		kolone.add("Indeks");
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Rođen(a)");
		kolone.add("God. st.");
		kolone.add("Status");
		kolone.add("Prosek");
		kolone.add("Adresa");
		kolone.add("Telefon");
		kolone.add("Mail");
		kolone.add("Upisan(a)");
		kolone.add("Predmeti");
	}
	
	protected static ListaStudenata getInstance()
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
	}
	
	public boolean indexExists(String index)
	{
		for(Student s : studenti)
		{
			if(s.getBrIndeksa().equals(index))
				return true;
		}
		return false;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	public int getColumnCount()
	{
		return kolone.size();
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
				return s.getGodStudija().name();
			case 5:
					return s.getFinansiranje().name();
			case 6:
				return Double.toString(s.getProsecnaOcena());
			case 7:
				return s.getAdresa();
			case 8:
				return s.getTelefon();
			case 9:
				return s.geteMail();
			case 10:
				return s.getDatumUpisa();
			case 11:
				return s.getSlusaPredmete().toString();
			default:
				return null;
		}
	}
	
	public void addStudent(String ime, String prezime, String datumRodjenja, String adresa, String telefon, String eMail,
			String brIndeksa, String datumUpisa, GodinaStudija godStudija, NacinFinansiranja finansiranje, double prosecnaOcena)
	{
		if(!indexExists(brIndeksa))
			this.studenti.add(new Student(ime, prezime, datumRodjenja, adresa, telefon, eMail, brIndeksa, datumUpisa, godStudija, finansiranje, prosecnaOcena));
		else
		{
			JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Student sa unetim indeksom već postoji!", "Grеška", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void addStudent(Student s)
	{
		if(!indexExists(s.getBrIndeksa()))
			this.studenti.add(s);
		else
		{
			JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Student sa unetim indeksom već postoji!", "Grеška", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	public void deleteStudent(String brI)
	{
		for(Student s : studenti)
		{
			if(s.getBrIndeksa().equals(brI))
			{
				this.studenti.remove(s);
				break;
			}
		}
	}
	
	public void editStudent(String brI, String ime, String prezime, String datumRodjenja, String adresa, String telefon, String eMail,
			String datumUpisa, GodinaStudija godStudija, NacinFinansiranja finansiranje, double prosecnaOcena)
	{
		for(Student s : studenti)
		{
			if(s.getBrIndeksa().equals(brI))
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
	
	public void editStudent(String brI, Student s)
	{
		for(Student stud : studenti)
		{
			if(stud.getBrIndeksa().equals(brI))
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
				stud.setSlusaPredmete(s.getSlusaPredmete());
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

	public void deletePredmetInList(Predmet p) {
		for(Student s : studenti)
			if(s.getSlusaPredmete()!=null)
				for(Predmet pred : s.getSlusaPredmete())
					if(pred.getSifra().equals(p.getSifra()))
						s.getSlusaPredmete().remove(p);
	}

	public void editPredmetInList(String sifra, Predmet novi) {
		for(Student s : studenti)
			if(s.getSlusaPredmete()!=null)
				for(Predmet p : s.getSlusaPredmete())
					if(p.getSifra().equals(sifra))
						Predmet.editPredmet(p, novi);
	}

	@Override
	public boolean isEmpty() {
		return studenti.isEmpty();
	}
}
