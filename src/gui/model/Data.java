package gui.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = -3785262540558754322L;
	public ListaPredmeta listaPredmeta = null;
	public ListaStudenata listaStudenata = null;
	public ListaProfesora listaProfesora = null;
	public static Data data = null;
	
	public static void init() {
		if(Data.data == null) {
			Data.data = new Data();
			deserialize();
		}
		System.gc();
	}

	public static void close() {
		serialize();
	}
	
	private Data() {
		this.listaPredmeta = ListaPredmeta.getInstance();
		this.listaStudenata = ListaStudenata.getInstance();
		this.listaProfesora = ListaProfesora.getInstance();
	}

	private static void serialize() {
		try {
	         ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("StudentskaSluzba.data"));
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
	         ObjectInputStream in = new ObjectInputStream(new FileInputStream("StudentskaSluzba.data"));
	         Data.data = (Data) in.readObject();
	         in.close();
	      } catch (IOException i) {
	        // i.printStackTrace();
	      } catch (Exception e) {
	    	 e.printStackTrace();
		  }
	}
	
	public static void checkStackTrace() {
		StackTraceElement[] stackTraceDataClassCallingCheck = Thread.currentThread().getStackTrace();
		if(!stackTraceDataClassCallingCheck[3].getMethodName().equals("<init>") || !stackTraceDataClassCallingCheck[3].getClassName().equals("gui.model.Data")) {
			for(StackTraceElement s : stackTraceDataClassCallingCheck)
				System.out.println(s.getMethodName()+" from "+s.getClassName());
			System.out.flush();
			throw new RuntimeException("Nije dozvoljeno pozivati getInstance metode kod listi izvan konstruktora persistence.Data klase!");
		}
	}
}
