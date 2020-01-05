package rs.ac.uns.ftn.ssluzba.gui.model;

/**
 * @author fmaster
 * @implNote available years of Study for Students and Subjects
 */
public enum GodinaStudija { 
	I, 
	II, 
	III, 
	IV; 
	
	/**
	 * @param s String containing {@link GodinaStudija} name 
	 * @return {@link Enum} type {@link GodinaStudija} or <code>null</code> if <code>s</code> not a {@link GodinaStudija} type
	 */
	public static GodinaStudija getGodinaStudija(String s) {
		if(s.equals(GodinaStudija.I.name())) return GodinaStudija.I;
		else if(s.equals(GodinaStudija.II.name())) return GodinaStudija.II;
		else if(s.equals(GodinaStudija.III.name())) return GodinaStudija.III;
		else if(s.equals(GodinaStudija.IV.name())) return GodinaStudija.IV;
		else return null;
	}
}
