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
			ListaStudenata.getInstance(Data.data.listaStudenata);
			ListaPredmeta.getInstance(Data.data.listaPredmeta);
		}
		System.gc();
	}

	public static void close() {
		Data.data.listaStudenata = ListaStudenata.getInstance();
		Data.data.listaPredmeta = ListaPredmeta.getInstance();
		SerializeSystem.serialize();
	}
	
	protected Data() {
		this.listaPredmeta = ListaPredmeta.getInstance();
		this.listaStudenata = ListaStudenata.getInstance();
	}
}
