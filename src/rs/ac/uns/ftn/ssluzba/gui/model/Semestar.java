package rs.ac.uns.ftn.ssluzba.gui.model;

/**
 * @author fmaster
 * @implNote Possible Semesters in Faculty
 */
public enum Semestar { 
	ZIMSKI,
	LJETNJI;
	
	/**
	 * @param s String containing {@link Semestar} name 
	 * @return {@link Enum} type {@link Semestar} or <code>null</code> if <code>s</code> not a {@link Semestar} type
	 */
	public static Semestar getSemestar(String s) {
		if(s.equals(ZIMSKI.name())) return ZIMSKI;
		else if(s.equals(LJETNJI.name())) return LJETNJI;
		else return null;
	}
}
