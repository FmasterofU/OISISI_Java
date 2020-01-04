package rs.ac.uns.ftn.ssluzba.gui.controller.listenersandactions;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import rs.ac.uns.ftn.ssluzba.gui.controller.CheckValidation;
import rs.ac.uns.ftn.ssluzba.gui.model.GodinaStudija;
import rs.ac.uns.ftn.ssluzba.gui.model.Student;
import rs.ac.uns.ftn.ssluzba.gui.view.modify.data.EditStudent;

/**
 * getting input data for {@link Student} from dialogs
 */
public class StudentListener implements FocusListener, ItemListener{
	
	private static Object data[] = new Object[10];

	@Override
	public void focusGained(FocusEvent e) {}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		
		if(txt.getName().trim().equals("tfime")) 
		{
			data[0] = txt.getText().trim();
			if(((String)data[0]).length() != 0)	data[0] = CheckValidation.firstLetterToCapital((String)data[0]);
		}
		else if(txt.getName().trim().equals("tfprez")) 
		{
			data[1] = txt.getText().trim();
			if(((String)data[1]).length() != 0)	data[1] = CheckValidation.firstLetterToCapital((String)data[1]);
		}
		else if(txt.getName().trim().equals("tfdatr"))			data[2] = txt.getText().trim();
		else if(txt.getName().trim().equals("tfadr"))
		{
			data[3] = txt.getText().trim();
			if(((String)data[3]).length() != 0)	data[3] = CheckValidation.firstLetterToCapital((String)data[3]);
		}
		else if(txt.getName().trim().equals("tftel"))			data[4] = txt.getText().trim();
		else if(txt.getName().trim().equals("tfmail"))			data[5] = txt.getText().trim();
		else if(txt.getName().trim().equals("tfindeks"))		data[6] = txt.getText().toUpperCase().trim();
		else if(txt.getName().trim().equals("tfdatu"))			data[7] = txt.getText().trim();
		else if(txt.getName().trim().equals("tfpros"))			data[9] = txt.getText().trim();
	}
	
	/**
	 * @param s {@link Student} whose data using in {@link EditStudent}
	 */
	public void setInitialData(Student s)
	{
		data[0] = s.getIme();
		data[1] = s.getPrezime();
		data[2] = s.getDatumRodjenja();
		data[3] = s.getAdresa();
		data[4] = s.getTelefon();
		data[5] = s.geteMail();
		data[6] = s.getBrIndeksa();
		data[7] = s.getDatumUpisa();
		data[8] = s.getGodStudija();
		//Double p = s.getProsecnaOcena();
		data[9] = Double.toString(s.getProsecnaOcena());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			JComboBox cb = (JComboBox) e.getSource();
			data[8] = cb.getSelectedItem();
			if(data[8].equals(GodinaStudija.IV.name())) data[8]=GodinaStudija.IV;
			else if(data[8].equals(GodinaStudija.III.name())) data[8]=GodinaStudija.III;
			else if(data[8].equals(GodinaStudija.II.name())) data[8]=GodinaStudija.II;
			else data[8]=GodinaStudija.I;
	       }
	}

	/**
	 * @return Object array of all data for {@link Student}
	 */
	public Object[] getData()
	{
		return data;
	}
	
	/**
	 * 	clears all data after closing dialog
	 */
	public void clearData()
	{
		for(int i = 0; i < data.length; i++)		data[i] = null;
	}
}
