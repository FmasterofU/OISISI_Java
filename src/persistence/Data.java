package persistence;

import java.io.Serializable;

import gui.model.ListaPredmeta;
import gui.model.ListaStudenata;

public class Data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3785262540558754322L;
	public ListaPredmeta listaPredmeta = null;
	public ListaStudenata listaStudenata = null;
	public static Data data = null;
	
	public static void init() {
		if(Data.data == null) {
			Data.data = new Data();
			DeserializeSystem.deserialize();
		}
		System.gc();
	}

	public static void close() {
		SerializeSystem.serialize();
	}
	
	protected Data() {
		this.listaPredmeta = ListaPredmeta.getInstance();
		this.listaStudenata = ListaStudenata.getInstance();
	}

	public static void checkStackTrace() {
		StackTraceElement[] stackTraceDataClassCallingCheck = Thread.currentThread().getStackTrace();
		if(!stackTraceDataClassCallingCheck[3].getMethodName().equals("<init>") || !stackTraceDataClassCallingCheck[3].getClassName().equals("persistence.Data")) {
			for(StackTraceElement s : stackTraceDataClassCallingCheck)
				System.out.println(s.getMethodName()+s.getClassName());
			System.out.flush();
			throw new RuntimeException("Nije dozvoljeno pozivati getInstance metode kod listi izvan konstruktora persistende.Data klase!");
		}
	}
}
