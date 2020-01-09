package rs.ac.uns.ftn.ssluzba.gui.model;

import java.awt.TextField;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.controller.ModelAction;

/**
 * @author fmaster
 * @implNote list of all data for {@link Profesor}, class implements {@link ITableModel} and {@link Serializable}
 */
public class ListaProfesora implements Serializable, ITableModel {

	private static final long serialVersionUID = 8001823155996613518L;
	private LinkedList<Profesor> profesori;
	public static ArrayList<String> kolone;

	static {
		kolone = new ArrayList<String>();
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Ro\u0111en(a)");
		kolone.add("Adresa");
		kolone.add("Telefon");
		kolone.add("e-mail");
		kolone.add("Kanc.");
		kolone.add("Br. LK");
		kolone.add("Titula");
		kolone.add("Zvanje");
		kolone.add("Predaje");
	}

	public ListaProfesora() {
		this.profesori = new LinkedList<Profesor>();
		
		// Default mode setup
		
		profesori.add(new Profesor("Aleksa", "Petkovi\u0107", "15.01.1965.", "Temerinska 15, Novi Sad", "021/334-990", "aleksa.petkovic@mailinator.com", "Dositeja Obradovi\u0107a 6, Novi Sad, MI 105", "007198721", "Prof. dr", "Redovni profesor"));
		profesori.add(new Profesor("Jana", "Lazarevi\u0107", "25.02.1963.", "Jovana Cviji\u0107a 26, Novi Sad", "021/435-891", "jana.lazarevic@mailinator.com", "Dositeja Obradovi\u0107a 6, Novi Sad, Nastavni blok 206", "008431903", "Prof. dr", "Redovni profesor"));
		profesori.add(new Profesor("Na\u0111a", "Aleksi\u0107", "23.03.1973.", "Gunduli\u0107eva 75, Novi Sad", "021/730-172", "nadja.aleksic@mailinator.com", "Dositeja Obradovi\u0107a 6, Novi Sad, NTP 307", "005671007", "Dr", "Vanredni profesor"));
		profesori.add(new Profesor("\u0110or\u0111e", "Spasojevi\u0107", "24.08.1978.", "\u0160ekspirova 44, Novi Sad", "021/514-893", "djordje.spasojevic@mailinator.com", "Dositeja Obradovi\u0107a 6, Novi Sad, MI 118", "009999331", "Dr", "Vanredni profesor"));
		profesori.add(new Profesor("Elena", "Milenkovi\u0107", "08.11.1985.", "Tolstojeva 52, Novi Sad", "021/834-901", "elena.milenkovic@mailinator.com", "Dositeja Obradovi\u0107a 6, Novi Sad, Nastavni blok 217", "003330976", "Dr", "Docent"));
		profesori.add(new Profesor("Teodor", "Mladenovi\u0107", "14.12.1983.", "Jovana Suboti\u0107a 33, Novi Sad", "021/441-007", "teodor.mladenovic@mailinator.com", "Dositeja Obradovi\u0107a 6, Novi Sad, NTP M35", "007441998", "Dr", "Docent"));
		
		//end
	}

	public ListaProfesora(ListaProfesora lp) {
		this.profesori = new LinkedList<Profesor>();
		for(Profesor p : lp.profesori)
			profesori.add(p);
	}

	public LinkedList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(LinkedList<Profesor> profesor) {
		this.profesori = profesor;
	}

	public void addProfesor(Profesor profesor) {
		profesori.add(profesor);
	}

	/**
	 * @param lk keyValue for {@link Profesor} (ID card)
	 * @return {@link Profesor} with lk or null
	 */
	public Profesor getProfesor(String lk) {
		for(Profesor p : profesori)
			if(p.getBrojLK().equals(lk))
				return p;
		return null;
	}

	/**
	 * @param id keyValue for editing {@link Profesor}
	 * @param novi new {@link Profesor} that overrides old
	 */
	public void changeProfesor(String id, Profesor novi) {
		for(Profesor p : profesori)
		{
			if(p.getBrojLK().equals(id))
			{
				p.setIme(novi.getIme());
				p.setPrezime(novi.getPrezime());
				p.setDatumRodjenja(novi.getDatumRodjenja());
				p.setAdresaStanovanja(novi.getAdresaStanovanja());
				p.setTelefon(novi.getTelefon());
				p.seteMail(novi.geteMail());
				p.setAdresaKancelarije(novi.getAdresaKancelarije());
				p.setTitula(novi.getTitula());
				p.setZvanje(novi.getZvanje());
				p.setPredajePredmete(novi.getPredajePredmete());
				break;
			}
		}
	}

	public void deleteProfesor(Profesor p) {
		profesori.remove(p);
	}

	@Override
	public int getColumnCount() {
		return kolone.size();
	}

	@Override
	public int getRowCount() {
		return profesori.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Profesor p = profesori.get(rowIndex);
		switch(columnIndex)
		{
		case 0: 
			return p.getIme();
		case 1:
			return p.getPrezime();
		case 2:
			return p.getDatumRodjenja();
		case 3:
			return p.getAdresaStanovanja();
		case 4:
			return p.getTelefon();
		case 5:
			return p.geteMail();
		case 6:
			return p.getAdresaKancelarije();
		case 7:
			return p.getBrojLK();
		case 8:
			return p.getTitula();
		case 9:
			return p.getZvanje();
		case 10:
			return p.PredajePredmeteTableString();
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return kolone.get(col);
	}

	/**
	 * @return {@link ArrayList} with unique {@link Profesor} keyValues
	 */
	public ArrayList<String> getUniqueProfList() {
		ArrayList<String> ret = new ArrayList<String>();
		for(Profesor p : profesori) ret.add(p.getIme()+ " "+ p.getPrezime()+" PK"+p.getBrojLK().toString()); 
		return ret;
	}

	/**
	 * @param id potentially {@link Profesor} keyValue
	 * @return true if {@link Profesor} with id exists
	 */
	public boolean profesorIDExists(String id) {
		for(Profesor p : profesori)
			if(p.getBrojLK().equals(id))
				return true;
		return false;
	}

	/**
	 * @implNote deletes {@link Predmet} p from {@link ListaProfesora}
	 * @param p deleting {@link Predmet}
	 * @param ma Action from view to model
	 */
	public void deletePredmetInList(Predmet p, ModelAction ma) {
		for(Profesor prof : profesori)
			if(prof.getPredajePredmete()!=null)
				for(Predmet pred : prof.getPredajePredmete())
					if(pred.getSifra().equals(p.getSifra())) {
						prof.getPredajePredmete().remove(pred);
						break;
					}
	}

	/**
	 * @author rammba
	 * @param sifra keyValue for {@link Predmet}
	 * @param novi editing {@link Predmet}
	 * @param ma Action from view to model
	 */
	public void editPredmetInList(String sifra, Predmet novi, ModelAction ma) {
		for(Profesor prof : profesori)
			if(ma==ModelAction.ADD_P) {
				if(novi.getProfesor().getBrojLK().equals(prof.getBrojLK()))
					prof.getPredajePredmete().add(novi);
			} else if(ma==ModelAction.DELETE_P) {
				if(Data.getListaPredmeta().getPredmet(sifra).getProfesor().getBrojLK().equals(prof.getBrojLK()))
					prof.getPredajePredmete().remove(novi);
			} else if(ma==ModelAction.BASIC_EDIT)
			{
				if(novi.getProfesor() != null)
				{
					if(novi.getProfesor().getBrojLK().equals(prof.getBrojLK()))
					{
						int i = 0;
						for(Predmet p : prof.getPredajePredmete())
						{
							if(p.getSifra().equals(sifra))
							{
								prof.getPredajePredmete().set(i, novi);
							}
							i++;
						}
					}
				}
			}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaProfesora [profesori=").append(profesori).append("]");
		return builder.toString();
	}

	@Override
	public boolean isEmpty() {
		return profesori.isEmpty();
	}

	/**
	 * @author fmaster
	 * @implNote ATTENTION: method mutates state of <code>this</code>
	 * @param searchQuery input from Search {@link TextField}
	 * @return {@link ListaPredmeta} with {@link Profesor}s who fulfills data in search
	 */
	public ListaProfesora mutableSearch(String searchQuery) {
		String[][] magic = CheckValidation.tokenizeSearchQuery(searchQuery, 1);
		Profesor[] p = {new Profesor()};
		for(Profesor prof : this.profesori.toArray(p)) 
			for(int i=0;i<magic[1].length;i++)
				if(!((String)prof.get(kolone.indexOf(magic[0][i]))).equals(magic[1][i])) {
					this.profesori.remove(prof);
					break;
				}
		return this;
	}
}
