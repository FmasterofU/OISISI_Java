package listeners_and_actions;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class StudentListener implements FocusListener, ItemListener{
	
	private String data[] = {"", "", "", "", "", "", "", "", "", "", ""};

	@Override
	public void focusGained(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);	
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.GRAY);
		
		if(txt.getName().trim().equals("tfime"))					data[0] = (txt.getText());
		else if(txt.getName().trim().equals("tfprez"))			data[1] = (txt.getText());
		else if(txt.getName().trim().equals("tfindeks"))		data[2] = (txt.getText());
		else if(txt.getName().trim().equals("tfdatr"))			data[3] = (txt.getText());
		else if(txt.getName().trim().equals("tfadr"))			data[4] = (txt.getText());
		else if(txt.getName().trim().equals("tftel"))			data[5] = (txt.getText());
		else if(txt.getName().trim().equals("tfmail"))			data[6] = (txt.getText());
		else if(txt.getName().trim().equals("tfpros"))			data[7] = (txt.getText());
		else if(txt.getName().trim().equals("tfdatu"))			data[8] = (txt.getText());
	}
	
	public void ispis()
	{
		for(int i = 0; i < data.length; i++)	System.out.println(data[i]);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
	          data[9] = (String) e.getItem();
	       }
	}
	
	//will be updated
	public void check(String b)
	{
		data[10] = b;
	}

}
