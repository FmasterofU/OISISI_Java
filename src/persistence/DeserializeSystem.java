package persistence;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeSystem {
	protected static void deserialize() {
		try {
	         ObjectInputStream in = new ObjectInputStream(new FileInputStream("StudentskaSluzba.data"));
	         Data.data = (Data) in.readObject();
	         in.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      } catch (Exception e) {
	    	 e.printStackTrace();
		  }
	}
}
