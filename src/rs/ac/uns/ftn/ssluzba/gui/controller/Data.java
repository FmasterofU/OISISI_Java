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

/**
 * @author fmaster
 * @implNote Data Persistence Service
 */
public class Data implements Serializable {

	private static final long serialVersionUID = -3785262540558754322L;
	private ListaPredmeta listaPredmeta = null;
	private ListaStudenata listaStudenata = null;
	private ListaProfesora listaProfesora = null;
	private static Data data = null;
	public static String location = "StudentskaSluzba.data";

	/**
	 * Initializes system.
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
	 * Prepares system for proper exit.
	 * Serializes data to location specified in static field location.
	 */
	public static void close() {
		serialize();
	}

	/**
	 * Initializes lists.
	 * fields listaPredmeta, listaStudenata and listaProfesora
	 */
	private Data() {
		this.listaPredmeta = new ListaPredmeta();
		this.listaStudenata = new ListaStudenata();
		this.listaProfesora = new ListaProfesora();
	}

	/**
	 * Serializes this class (fields-lists) to location given in field location
	 */
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

	/**
	 * Deserializes this class (fields-lists) from location given in field location
	 */
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
	 * @deprecated used during development process.
	 * modification needed if using
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

	/**
	 * @return static get-only field listaPredmeta
	 */
	public static ListaPredmeta getListaPredmeta() {
		return data.listaPredmeta;
	}

	/**
	 * @return static get-only field listaStudenata
	 */
	public static ListaStudenata getListaStudenata() {
		return data.listaStudenata;
	}

	/**
	 * @return static get-only field listaProfesora
	 */
	public static ListaProfesora getListaProfesora() {
		return data.listaProfesora;
	}
}
