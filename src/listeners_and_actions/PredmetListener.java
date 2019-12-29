package listeners_and_actions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import gui.model.GodinaStudija;
import gui.model.Predmet;
import gui.model.Semestar;

public class PredmetListener implements FocusListener, ItemListener {

	private static Object[] data = new Object[6];
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange()==ItemEvent.SELECTED) {
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
			}
		}
	}

	@Override
	public void focusGained(FocusEvent fe) {
		// TODO Auto-generated method stub
		
	}

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

	public void setInitialData(Predmet p) {
		data[0] = p.getSifra();
		data[1] =  p.getNaziv();
		data[2] =  p.getSemestar();
		data[3] =  p.getGodinaStudija();
		data[4] =  p.getProfesor();
		data[5] =  p.getStudenti();
	}
	
	public void clearData() {
		for(int i=0; i < data.length; i++) data[i] = null;		
	}

	public Object[] getData() {
		return data;
	}

}
