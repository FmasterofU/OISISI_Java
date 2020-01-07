package resources;

import java.net.URL;

/**
 * @author fmaster
 * @implNote resource getter class (just icons now), this implementation needed in order for the Runnable JAR archive to be formed correctly (including images in archive)
 */
public class Resource {
	
	public static URL get(String name) {
		return Resource.class.getResource("/resources/"+name);
	}
}
