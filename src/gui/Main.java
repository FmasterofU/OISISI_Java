package gui;

import gui.model.Data;
import gui.model.GodinaStudija;
import gui.model.Predmet;
import gui.model.Profesor;
import gui.model.Semestar;
import gui.model.Student;
import gui.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		Data.init();
		/*Data.data.listaProfesora.addProfesor(new Profesor());
		Data.data.listaPredmeta.addPredmet(new Predmet("fuuuuuuuuuck", "težak predmet", Semestar.LJETNJI, GodinaStudija.III, new Profesor()));
		Data.data.listaPredmeta.addPredmet(new Predmet("e206", "metode", Semestar.ZIMSKI, GodinaStudija.I, new Profesor()));
		//Data.data.listaStudenata.dodajStudenta(new Student());*/
		MainWindow.getInstance().setVisible(true);
	}
}


/*public static void main(String[] args) {
	//System.out.println("Da li radi? :)");
	Predmet pred = new Predmet();
	Profesor prof = new Profesor();
	Student stud = new Student();
	Data.init();
	//System.out.println(Data.data.listaPredmeta);
	//System.out.println(Data.data.listaPredmeta);
	pred.setProfesor(prof);
	ArrayList<Predmet> a = new ArrayList<Predmet>();
	a.add(pred);
	stud.setSlusaPredmete(a);
	Data.data.listaStudenata.dodajStudenta(stud.getIme(), stud.getPrezime(), stud.getDatumRodjenja(), stud.getAdresa(), stud.getTelefon(), stud.geteMail(), stud.getBrIndeksa(), stud.getDatumUpisa(), stud.getGodStudija(), stud.getFinansiranje(), stud.getProsecnaOcena());
	Data.data.listaPredmeta.addPredmet(pred);
	System.out.println(Data.data.listaPredmeta);
	System.out.println(Data.data.listaStudenata);
	Data.close();
	//System.out.println(Data.data);
}*/

