package gui.model;

import java.io.Serializable;
import java.util.LinkedList;

import persistence.Data;

public class ListaPredmeta implements Serializable{

	private static final long serialVersionUID = -8045180299982898373L;
	private LinkedList<Predmet> predmeti;
	private static ListaPredmeta instance = null;
	
	private ListaPredmeta() {
		this.setPredmeti(new LinkedList<Predmet>());
	}
	
	public static ListaPredmeta getInstance() {
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
	
	 public void getPredmet(int index) {
		 predmeti.get(index);
	 }
	 
	 public void changePredmet(int index, Predmet p) {
		 predmeti.set(index, p);
	 }
	 
	 public void deletePredmet(int index) {
		 predmeti.remove(index);
	 }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaPredmeta [predmeti=");
		builder.append(predmeti);
		builder.append("]");
		return builder.toString();
	}
}
