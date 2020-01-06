package resources;

import java.net.URL;

public class Resource {
	
	public static URL get(String name) {
		return Resource.class.getResource("/resources/"+name);
	}
}
