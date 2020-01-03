package rs.ac.uns.ftn.ssluzba.gui.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import rs.ac.uns.ftn.ssluzba.gui.model.ListaPredmeta;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaProfesora;
import rs.ac.uns.ftn.ssluzba.gui.model.ListaStudenata;

public class Data implements Serializable {

	private static final long serialVersionUID = -3785262540558754322L;
	private ListaPredmeta listaPredmeta = null;
	private ListaStudenata listaStudenata = null;
	private ListaProfesora listaProfesora = null;
	private static Data data = null;
	public static String location = "StudentskaSluzba.data";

	/**
	 * Initialize system
	 * Deserializes data from location stored in static field location, which, if not otherwise set, by default is StudentskaSluzba.data.
	 */
	public static void init() {
		if(Data.data == null) {
			Data.data = new Data();
			deserialize();
		}
		System.gc();
	}

	/**
	 * Prepares system for proper exit
	 * Serializes data to location specified in static field location.
	 */
	public static void close() {
		serialize();
	}

	private Data() {
		this.listaPredmeta = new ListaPredmeta();
		this.listaStudenata = new ListaStudenata();
		this.listaProfesora = new ListaProfesora();
	}

	private static void serialize() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(location));
			out.writeObject(Data.data);
			out.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void deserialize() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(location));
			Data.data = (Data) in.readObject();
			in.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Do not use this method
	 */
	public static void checkStackTrace() {
		StackTraceElement[] stackTraceDataClassCallingCheck = Thread.currentThread().getStackTrace();
		if(!stackTraceDataClassCallingCheck[3].getMethodName().equals("<init>") || !stackTraceDataClassCallingCheck[3].getClassName().equals(Data.class.getCanonicalName())) {
			for(StackTraceElement s : stackTraceDataClassCallingCheck)
				System.out.println(s.getMethodName()+" from "+s.getClassName());
			System.out.flush();
			throw new RuntimeException("Nije dozvoljeno pozivati getInstance metode kod listi izvan konstruktora persistence.Data klase!");
		}
	}

	public static ListaPredmeta getListaPredmeta() {
		return data.listaPredmeta;
	}

	public static ListaStudenata getListaStudenata() {
		return data.listaStudenata;
	}

	public static ListaProfesora getListaProfesora() {
		return data.listaProfesora;
	}
}
