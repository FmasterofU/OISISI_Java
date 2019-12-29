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
	
	// index==row gui
	
	 public Predmet getPredmet(String sifra) {
		 for(Predmet p : predmeti)
			 if(p.getSifra().equals(sifra))
				 return p;
		 return null;
	 }
	 
	 /* TODO ukloniti zavisnost od indeksa u sledecim metodata (get i delete su vec uradjeni)
	 
	 public void changePredmet(int index, Predmet p) {
		 predmeti.set(index, p);
	 }
	 
	 public void deletePredmet(int index) {
		 predmeti.remove(index);
	 }

	 public void deletePredmet(String sifra) {
		 for(Predmet p : predmeti)
			 if(p.getSifra().equals(sifra)) {
				 predmeti.remove(p);
				 return;
			 }
	 }*/
	 
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
