package gui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListaProfesora implements Serializable, IAbstractTableModel {

	private static final long serialVersionUID = 8001823155996613518L;
	private LinkedList<Profesor> profesori;
	private static ListaProfesora instance = null;
	private static ArrayList<String> kolone;
	
	static {
		kolone = new ArrayList<String>();
		kolone.add("Ime");
		kolone.add("Prezime");
		kolone.add("Datum rođenja");
		kolone.add("Adresa stanovanja");
		kolone.add("Telefon");
		kolone.add("e-mail");
		kolone.add("Kancelarija");
		kolone.add("Br. LK");
		kolone.add("Titula");
		kolone.add("Zvanje");
		kolone.add("Predaje Predmete");
	}
	
	private ListaProfesora() {
		this.profesori = new LinkedList<Profesor>();
	}
	
	protected static ListaProfesora getInstance() {
		Data.checkStackTrace();
		if(instance==null) instance = new ListaProfesora();
		return instance;
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
	//TODO izmijeniti metode to narednog linijskog komentara da odgovaraju dogovoru
	// index==row gui
	
	 public Profesor getProfesor(String lk) {
		 for(Profesor p : profesori)
			 if(p.getBrojLK().equals(lk))
				 return p;
		 return null;
	 }
	 
	 public void changeProfesor(int index, Profesor p) {
		 profesori.set(index, p);
	 }
	 
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
	 
	//
	 
	 
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
				//return p.getPredajePredmete();
				return "Will be added";
			default:
				return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return kolone.get(col);
	}

	public ArrayList<String> getUniqueProfList() {
		ArrayList<String> ret = new ArrayList<String>();
		for(Profesor p : profesori) ret.add(p.getIme()+ " "+ p.getPrezime()+" PK"+p.getBrojLK().toString()); 
		return ret;
	}

	public boolean profesorIDExists(String id) {
		for(Profesor p : profesori)
			if(p.getBrojLK().equals(id))
				return true;
		return false;
	}

	public void deletePredmetInList(Predmet p) {
		for(Profesor prof : profesori)
			for(Predmet pred : prof.getPredajePredmete())
				if(pred.getSifra().equals(p.getSifra()))
					prof.getPredajePredmete().remove(p);
	}

	public void editPredmetInList(String sifra, Predmet novi) {
		for(Profesor prof : profesori)
			for(Predmet pred : prof.getPredajePredmete())
				if(pred.getSifra().equals(sifra))
					Predmet.editPredmet(pred, novi);
	}
}
