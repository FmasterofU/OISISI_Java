package rs.ac.uns.ftn.ssluzba.gui.model;

import java.awt.TextField;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

/**
 * @author rammba
 * @implNote list of all data for {@link Student}, class implements {@link ITableModel} and {@link Serializable}
 */
public class ListaStudenata implements Serializable, ITableModel {

	private static final long serialVersionUID = 3654331325580773015L;
	private ArrayList<Student> studenti;
	public static ArrayList<String> kolone;

	static {
		kolone = new ArrayList<String>();
		kolone.add("Indeks");
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Ro\u0111en(a)");
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
		
		//	Default data
		studenti.add(new Student("Luka", "Jovanovi\u0107", "01.01.2000.", "Kara\u0111or\u0111eva 83, Novi Sad", "021/333-555", "luka.jovanovic@mailinator.com", "RA1/2019", "01.07.2019.", GodinaStudija.I, NacinFinansiranja.BUD\u017dET, 5.0));
		studenti.add(new Student("Sofija", "Petrovi\u0107", "16.05.2000.", "Milo\u0161a Pocerca 55, \u0160abac", "015/343-356", "sofija.petrovic@mailinator.com", "RA5/2019", "11.07.2019.", GodinaStudija.I, NacinFinansiranja.BUD\u017dET, 5.0));
		studenti.add(new Student("Stefan", "Nikoli\u0107", "18.03.2000.", "Knez Mihajlova 16, Beograd", "011/923-4857", "stefan.nikolic@mailinator.com", "RA3/2019", "03.07.2019.", GodinaStudija.I, NacinFinansiranja.BUD\u017dET, 5.0));
		studenti.add(new Student("Dunja", "Ili\u0107", "11.11.2000.", "Petefi \u0160andora 15, Novi Sad", "021/433-958", "dunja.ilic@mailinator.com", "RA2/2019", "01.07.2019.", GodinaStudija.I, NacinFinansiranja.SAMOFINANSIRANJE, 5.0));
		studenti.add(new Student("Lazar", "\u0110or\u0111evi\u0107", "03.12.2000.", "Josip Broz Tito 13, Subotica", "024/333-559", "lazar.djordjevic@mailinator.com", "RA4/2019", "06.07.2019.", GodinaStudija.I, NacinFinansiranja.SAMOFINANSIRANJE, 5.0));
		studenti.add(new Student("Sara", "Pavlovi\u0107", "03.12.1999.", "Vojvode Mi\u0161i\u0107a 23, \u0160abac", "015/313-061", "sara.pavlovic@mailinator.com", "RA3/2018", "01.07.2018.", GodinaStudija.II, NacinFinansiranja.BUD\u017dET, 9.43));
		studenti.add(new Student("Vuk", "Markovi\u0107", "03.12.1999.", "Temerinska 133, Novi Sad", "021/351-091", "vuk.markovic@mailinator.com", "RA15/2018", "11.07.2018.", GodinaStudija.II, NacinFinansiranja.BUD\u017dET, 8.32));
		studenti.add(new Student("Teodora", "Popovi\u0107", "03.12.1998.", "Surepova 15, \u0160abac", "015/324-500", "teodora.popovic@mailinator.com", "RA133/2017", "03.07.2017.", GodinaStudija.II, NacinFinansiranja.SAMOFINANSIRANJE, 8.03));
		studenti.add(new Student("Filip", "Stojanovi\u0107", "03.12.1998.", "Francuska 113, Beograd", "011/233-3900", "filip.stojanovic@mailinator.com", "RA122/2017", "02.07.2017.", GodinaStudija.II, NacinFinansiranja.SAMOFINANSIRANJE, 6.05));
		studenti.add(new Student("Ana", "\u017divkovi\u0107", "03.12.1998.", "Kralja Petra 20, Novi Sad", "021/231-114", "ana.zivkovic@mailinator.com", "RA201/2017", "04.07.2017.", GodinaStudija.II, NacinFinansiranja.SAMOFINANSIRANJE, 7.56));
		studenti.add(new Student("Viktor", "Jankovi\u0107", "03.12.1998.", "Gogoljeva 3, Novi Sad", "021/135-463", "viktor.jankovic@mailinator.com", "RA1/2017", "01.07.2017.", GodinaStudija.III, NacinFinansiranja.BUD\u017dET, 10.0));
		studenti.add(new Student("Petra", "Todorovi\u0107", "03.12.1998.", "Njego\u0161eva 2, Novi Sad", "021/903-463", "petra.todorovic@mailinator.com", "RA5/2017", "12.07.2017.", GodinaStudija.III, NacinFinansiranja.BUD\u017dET, 7.65));
		studenti.add(new Student("Andrej", "Stankovi\u0107", "03.12.1998.", "Radoja Domanovi\u0107a 5, Novi Sad", "021/731-067", "andrej.stankovic@mailinator.com", "RA33/2017", "19.07.2017.", GodinaStudija.III, NacinFinansiranja.BUD\u017dET, 9.56));
		studenti.add(new Student("Mila", "Risti\u0107", "03.12.1997.", "Vojvode Stepe 183, Beograd", "011/433-3800", "mila.ristic@mailinator.com", "RA152/2016", "15.07.2016.", GodinaStudija.III, NacinFinansiranja.SAMOFINANSIRANJE, 6.54));
		studenti.add(new Student("Pavle", "Kosti\u0107", "03.12.1997.", "Crnotravska 13, Beograd", "011/313-0007", "pavle.kostic@mailinator.com", "RA104/2016", "06.07.2016.", GodinaStudija.III, NacinFinansiranja.SAMOFINANSIRANJE, 8.04));
		studenti.add(new Student("Lena", "Kova\u010devi\u0107", "03.12.1997.", "Bulevar Oslobo\u0111enja 143, Novi Sad", "021/533-3801", "lena.kovacevic@mailinator.com", "RA1/2016", "01.07.2016.", GodinaStudija.IV, NacinFinansiranja.BUD\u017dET, 7.90));
		studenti.add(new Student("Filip", "\u017divkovi\u0107", "03.12.1997.", "1300 Kaplara, \u0160abac", "015/333-500", "filip.zivkovic@mailinator.com", "RA5/2016", "21.07.2016.", GodinaStudija.IV, NacinFinansiranja.BUD\u017dET, 7.23));
		studenti.add(new Student("Tara", "Dimitrijevi\u0107", "03.12.1996.", "Milovana Gli\u0161i\u0107a, Valjevo", "014/303-007", "tara.dimitrijevic@mailinator.com", "RA33/2015", "23.07.2015.", GodinaStudija.IV, NacinFinansiranja.SAMOFINANSIRANJE, 8.32));
		studenti.add(new Student("Vasilije", "Mici\u0107", "03.12.1996.", "Vuka Karad\u017ei\u0107a, Loznica", "015/101-909", "vasilije.micic@mailinator.com", "RA102/2015", "04.07.2015.", GodinaStudija.IV, NacinFinansiranja.SAMOFINANSIRANJE, 6.45));
		studenti.add(new Student("Lenka", "Jovi\u0107", "03.12.1997.", "Bulevar Mihajla Pupina, Novi Sad", "021/431-500", "lenka.jovic@mailinator.com", "RA244/2016", "07.07.2016.", GodinaStudija.IV, NacinFinansiranja.SAMOFINANSIRANJE, 6.0));
		
	}

	public ListaStudenata(ListaStudenata ls) {
		this.studenti = new ArrayList<Student>();
		for(Student s : ls.studenti)
			studenti.add(s);
	}

	/**
	 * @param index potentially keyValue for {@link Student} (index)
	 * @return true if {@link Student} with index exists
	 */
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
			JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Student sa unetim indeksom ve\u0107 postoji!", "Grе\u0161ka", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}	
	}

	public void addStudent(Student s)
	{
		if(!indexExists(s.getBrIndeksa()))
			this.studenti.add(s);
		else
		{
			JOptionPane.showConfirmDialog(MainWindow.getInstance(), "Student sa unetim indeksom ve\u0107 postoji!", "Grе\u0161ka", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
		}	
	}

	/**
	 * deletes {@link Student} with keyValue from {@link ListaStudenata}
	 * @param brI keyValue for {@link Student}
	 */
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

	/**
	 * deletes {@link Predmet} p from {@link ListaStudenata}
	 * @param p deleting {@link Predmet}
	 * @param ma Action from view to model
	 */
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

	/**
	 * @param sifra keyValue for editing {@link Student}
	 * @param novi new {@link Student} that will override old
	 * @param ma Action from view to model
	 */
	public void editPredmetInList(String sifra, Predmet novi, ModelAction ma) {
		ArrayList<Student> stud = novi.getStudenti();
		for(Student s : studenti)
			if(stud.contains(s))
				if(ma==ModelAction.ADD_S) {
					if(!s.getSlusaPredmete().contains(novi))
						s.getSlusaPredmete().add(novi);
				}
				else if(ma==ModelAction.DELETE_S) s.getSlusaPredmete().remove(novi);
				else if(ma==ModelAction.BASIC_EDIT)
				{
					int i = 0;
					for(Predmet p : s.getSlusaPredmete())
					{
						if(p.getSifra().equals(sifra))
						{
							s.getSlusaPredmete().set(i, novi);
						}
						i++;
					}
				}
	}

	@Override
	public boolean isEmpty() {
		return studenti.isEmpty();
	}

	/**
	 * @return {@link ArrayList} of keyValues for all {@link Student}s
	 */
	public ArrayList<String> getListOfStudentIndexes()
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(Student s : studenti)
			ret.add(s.getBrIndeksa());
		return ret;
	}

	/**
	 * @param god year on faculty
	 * @return {@link ArrayList} of keyValues for all {@link Student}s on god
	 */
	public ArrayList<String> getListOfStudentIndexes(GodinaStudija god)
	{
		ArrayList<String> ret = new ArrayList<String>();
		for(Student s : studenti)
			if(s.getGodStudija() == god)
				ret.add(s.getBrIndeksa());
		return ret;
	}

	/**
	 * @param key potentially keyValue for {@link Student}
	 * @return {@link Student} with keyValue key or null
	 */
	public Student getStudentByKey(String key)
	{
		for(Student s : studenti)
			if(s.getBrIndeksa().equals(key))
				return s;
		return null;
	}

	/**
	 * @author rammba
	 * @param searchQuery input from Search {@link TextField}
	 * @return {@link ListaStudenata} with {@link Student}s who fulfills data in search
	 */
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
}
