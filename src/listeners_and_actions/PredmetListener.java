package listeners_and_actions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import gui.model.GodinaStudija;
import gui.model.Semestar;

public class PredmetListener implements FocusListener, ItemListener {

	private static Object[] data = new Object[5];
	
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getStateChange()==ItemEvent.SELECTED) {
			@SuppressWarnings("rawtypes")
			JComboBox cb = (JComboBox) ie.getSource();
			switch(cb.getName()) {
				case "cbSemestar":
					data[2] = cb.getSelectedItem();
					if(((String) data[2]).contains("Zimski")) data[2]=Semestar.ZIMSKI;
					else data[2]=Semestar.LJETNJI;
					break;
				case "cbGodina":
					data[3] = cb.getSelectedItem();
					if(((String) data[3]).contains("IV")) data[3]=GodinaStudija.IV;
					else if(((String) data[3]).contains("III")) data[3]=GodinaStudija.III;
					else if(((String) data[3]).contains("II")) data[3]=GodinaStudija.II;
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

	public void clearData() {
		for(int i=0; i < data.length; i++) data[i] = null;		
	}

	public Object[] getData() {
		return data;
	}

}
