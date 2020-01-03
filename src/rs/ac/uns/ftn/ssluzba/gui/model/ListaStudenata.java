package rs.ac.uns.ftn.ssluzba.gui.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

public class ListaStudenata implements Serializable, ITableModel {
	
	private static final long serialVersionUID = 3654331325580773015L;
	private ArrayList<Student> studenti;
	public static ArrayList<String> kolone;
	
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

	
	public ListaStudenata()
	{
		this.studenti = new ArrayList<Student>();
		this.studenti.add(new Student());
	}
	
	public ListaStudenata(ListaStudenata ls) {
		this.studenti = new ArrayList<Student>();
		for(Student s : ls.studenti)
			studenti.add(s);
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
				//return s.getSlusaPredmete().toString();
				return s.slusaPredmeteString();
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

	public void deletePredmetInList(Predmet p, ModelAction ma) {
		if(ma == ModelAction.DELETE_S)
		{
			for(Student s : studenti)
				if(!p.getStudenti().contains(s))
					if(s.getSlusaPredmete() != null)
						for(Predmet pred : s.getSlusaPredmete())
							if(pred.getSifra().equals(p.getSifra()))
							{
								s.getSlusaPredmete().remove(pred);
								break;
							}
//				for(Student other : p.getStudenti())
//					if(!s.equals(other))
//					{
//						if(s.getSlusaPredmete()!=null)
//							for(Predmet pred : s.getSlusaPredmete())
//								if(pred.getSifra().equals(p.getSifra())) {
//									//System.out.println("s " + s + "other " + other);
//									s.getSlusaPredmete().remove(pred);
//									break;
//								}
//					}
		}
		else {
			for(Student s : studenti)
				if(s.getSlusaPredmete()!=null)
					for(Predmet pred : s.getSlusaPredmete())
						if(pred.getSifra().equals(p.getSifra())) {
							s.getSlusaPredmete().remove(pred);
							break;
						}
		}
	}

	public void editPredmetInList(String sifra, Predmet novi, ModelAction ma) {
		ArrayList<Student> stud = novi.getStudenti();
		for(Student s : studenti)
			if(stud.contains(s))
				if(ma==ModelAction.ADD_S) {
					if(!s.getSlusaPredmete().contains(novi))
						s.getSlusaPredmete().add(novi);
				}
				else if(ma==ModelAction.DELETE_S) s.getSlusaPredmete().remove(novi);
	}

	@Override
	public boolean isEmpty() {
		return studenti.isEmpty();
	}
	
	public ArrayList<String> getListOfStudentIndexes()
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(Student s : studenti)
			ret.add(s.getBrIndeksa());
		return ret;
	}
	
	public ArrayList<String> getListOfStudentIndexes(GodinaStudija god)
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(Student s : studenti)
			if(s.getGodStudija() == god)
				ret.add(s.getBrIndeksa());
		return ret;
	}
	
	public Student getStudentByKey(String key)
	{
		for(Student s : studenti)
			if(s.getBrIndeksa().equals(key))
				return s;
		return null;
	}
	
	public ListaStudenata mutableSearch(String searchQuery) {
		boolean check[] = new boolean[this.getStudenti().size()];
		String name = "", surname = "", index = "", mail = "";
		for(String splits : searchQuery.split(";"))
		{
			String parts[] = splits.split(":");
			if(parts[0].equals("ime"))
				name = parts[1];
			else if(parts[0].equals("prezime"))
				surname = parts[1];
			else if(parts[0].equals("indeks"))
				index = parts[1];
			else if(parts[0].equals("email"))
				mail = parts[1];
		}
		int i = 0;
		for(Student s : this.getStudenti())
		{
			if(s.getIme().equals((name != "") ? name : s.getIme()) && s.getPrezime().equals((surname != "") ? surname : s.getPrezime()) &&
				s.getBrIndeksa().equals((index != "") ? index : s.getBrIndeksa()) && s.geteMail().equals((mail != "") ? mail : s.geteMail()))
				check[i] = true;
			i++;
		}
		
		for(i = check.length - 1; i >= 0; i--)
			if(!check[i])
				this.getStudenti().remove(i);
		return this;
	}
	
//	private String getPredmetIDs(Student s)
//	{
//		String ret = "";
//		if(!s.getSlusaPredmete().isEmpty())
//		{
//			for(Predmet p : s.getSlusaPredmete())
//				ret += p.getSifra() + ", ";
//		}
//		else	ret += "Ne sluša niti jedan predmet";
//		return ret;
//	}
}
