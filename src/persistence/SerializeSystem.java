package persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class SerializeSystem {
	protected static void serialize() {
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
	
}
