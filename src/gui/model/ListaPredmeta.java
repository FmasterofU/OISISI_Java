package gui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class ListaPredmeta implements Serializable, IAbstractTableModel {

	private static final long serialVersionUID = -8045180299982898373L;
	private LinkedList<Predmet> predmeti;
	private static ListaPredmeta instance = null;
	private static ArrayList<String> kolone;
	
	static {
		kolone = new ArrayList<String>();
		kolone.add("Šifra");
		kolone.add("Naziv");
		kolone.add("Semestar");
		kolone.add("Godina");
		kolone.add("Profesor");
		kolone.add("Studenti");
	}
	
	private ListaPredmeta() {
		this.setPredmeti(new LinkedList<Predmet>());
	}
	
	protected static ListaPredmeta getInstance() {
		Data.checkStackTrace();
		if(instance==null) instance = new ListaPredmeta();
		return instance;
	}

	public LinkedList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(LinkedList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public void addPredmet(Predmet predmet) {
		predmeti.add(predmet);
	}
	
	 public Predmet getPredmet(String sifra) {
		 for(Predmet p : predmeti)
			 if(p.getSifra().equals(sifra))
				 return p;
		 return null;
	 }
	 
	 public void editPredmet(String sifra, Predmet p) {
		 deletePredmet(getPredmet(sifra));
		 addPredmet(p);
	 }
	 
	 public void deletePredmet(String sifra) {
		 predmeti.remove(getPredmet(sifra));
	 }
	 
	 public void deletePredmet(Predmet p) {
		 predmeti.remove(p);
	 }
	 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaPredmeta [predmeti=");
		builder.append(predmeti);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return predmeti.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Predmet p = predmeti.get(rowIndex);
		switch(columnIndex) 
		{
			case 0:
				return p.getSifra();
			case 1:
				return p.getNaziv();
			case 2:
				return p.getSemestar();
			case 3:
				return p.getGodinaStudija();
			case 4:
				return p.getProfesor().getIme()+" "+p.getProfesor().getPrezime();
			case 5:
				return p.getStudenti();
			default:
				return null;
		}
	}

	@Override
	public String getColumnName(int col) {
		return kolone.get(col);
	}

	public boolean predmetCodeExists(String text) {
		for(Predmet p : predmeti)
			if(p.getSifra().equals(text))
				return true;
		return false;
	}
}
