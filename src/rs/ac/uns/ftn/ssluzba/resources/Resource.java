package rs.ac.uns.ftn.ssluzba.resources;

import java.net.URL;

/**
 * @author fmaster
 * @implNote resource getter class (just icons now), this implementation needed in order for the Runnable JAR archive to be formed correctly (including images in archive)
 */
public class Resource {
	
	private Resource() {}
	
	public static URL get(String name) {
		return Resource.class.getResource("/rs/ac/uns/ftn/ssluzba/resources/"+name);
	}
}
