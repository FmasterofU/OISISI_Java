package rs.ac.uns.ftn.ssluzba;

import rs.ac.uns.ftn.ssluzba.gui.controller.Data;
import rs.ac.uns.ftn.ssluzba.gui.model.GodinaStudija;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.model.Profesor;
import rs.ac.uns.ftn.ssluzba.gui.model.Semestar;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.MainWindow;

public class Main {

	public static void main(String[] args) {
		Data.init();
		/*Data.data.listaProfesora.addProfesor(new Profesor());
		Data.data.listaPredmeta.addPredmet(new Predmet("FUUUUUUUUCK", "težak predmet", Semestar.LJETNJI, GodinaStudija.III, new Profesor()));
		Data.data.listaPredmeta.addPredmet(new Predmet("E206", "metode", Semestar.ZIMSKI, GodinaStudija.I, new Profesor()));
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

