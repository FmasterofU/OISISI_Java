package rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import rs.ac.uns.ftn.ssluzba.gui.model.GodinaStudija;
import rs.ac.uns.ftn.ssluzba.gui.model.Predmet;
import rs.ac.uns.ftn.ssluzba.gui.model.Semestar;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.EditPredmet;

/**
 * @author fmaster
 * @implNote getting input data for {@link Predmet} from dialogs
 */
public class PredmetListener implements FocusListener, ItemListener {

	private static Object[] data = new Object[7];
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange()==ItemEvent.SELECTED) {
			data[6] = true;
			@SuppressWarnings("rawtypes")
			JComboBox cb = (JComboBox) ie.getSource();
			switch(cb.getName()) {
				case "cbSemestar":
					data[2] = cb.getSelectedItem();
					if(((String) data[2]).equals(Semestar.ZIMSKI.name())) data[2]=Semestar.ZIMSKI;
					else data[2]=Semestar.LJETNJI;
					break;
				case "cbGodina":
					data[3] = cb.getSelectedItem();
					if(data[3].equals(GodinaStudija.IV.name())) data[3]=GodinaStudija.IV;
					else if(data[3].equals(GodinaStudija.III.name())) data[3]=GodinaStudija.III;
					else if(data[3].equals(GodinaStudija.II.name())) data[3]=GodinaStudija.II;
					else data[3]=GodinaStudija.I;
					break;
				case "cbProfesor":
					data[4] = cb.getSelectedItem().toString();
					break;
				case "cbStud":
					data[6] = cb.getSelectedItem().toString();				
			}
		}
	}

	@Override
	public void focusGained(FocusEvent fe) {}

	@Override
	public void focusLost(FocusEvent fe) {
		JTextField txt = (JTextField) fe.getComponent();
		switch(txt.getName()) {
			case "tfSifra":
				data[0]=txt.getText().toUpperCase();
				break;
			case "tfNaziv":
				data[1]=txt.getText();
				break;
		}		
	}

	/**
	 * @param p {@link Predmet} whose data using in {@link EditPredmet}
	 */
	public void setInitialData(Predmet p) {
		data[0] = p.getSifra();
		data[1] =  p.getNaziv();
		data[2] =  p.getSemestar();
		data[3] =  p.getGodinaStudija();
		data[4] =  p.getProfesor();
		data[5] = "";
		if(!p.getStudenti().isEmpty())
			for(Student s : p.getStudenti())
				data[5] += s.getBrIndeksa() + " ";
		data[6] = null;
	}
	
	/**
	 * clears all data after closing dialog
	 */
	public void clearData() {
		for(int i=0; i < data.length; i++) data[i] = null;		
	}

	/**
	 * @return Object array of data for {@link Predmet}
	 */
	public Object[] getData() {
		return data;
	}

}
