package gui;

import gui.model.Profesor;
import gui.view.MainWindow;
import persistence.Data;

public class Main {

	public static void main(String[] args) {
		Data.init();
		//Data.data.listaProfesora.addProfesor(new Profesor());
		//Data.data.listaPredmeta.addPredmet(new Predmet("fuuuuuuuuuck", "težak predmet", (byte)5, (byte)3, new Profesor()));
		//Data.data.listaPredmeta.addPredmet(new Predmet("e206", "metode", (byte)5, (byte)3, new Profesor()));
		//Data.data.listaStudenata.dodajStudenta(new Student());
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

