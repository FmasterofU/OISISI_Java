package listeners_and_actions;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JTextField;

public class StudentListener implements FocusListener, ItemListener{
	
	private static String data[] = {"", "", "", "", "", "", "", "", "1", ""};

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
		else if(txt.getName().trim().equals("tfdatr"))			data[2] = (txt.getText());
		else if(txt.getName().trim().equals("tfadr"))			data[3] = (txt.getText());
		else if(txt.getName().trim().equals("tftel"))			data[4] = (txt.getText());
		else if(txt.getName().trim().equals("tfmail"))			data[5] = (txt.getText());
		else if(txt.getName().trim().equals("tfindeks"))		data[6] = (txt.getText().toUpperCase());
		else if(txt.getName().trim().equals("tfdatu"))			data[7] = (txt.getText());
		else if(txt.getName().trim().equals("tfpros"))			data[9] = (txt.getText());
	}
	
	public static void ispis()
	{
		for(int i = 0; i < data.length; i++)	System.out.println(data[i]);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			String temp = (String) e.getItem();
			if(temp.contains("prva"))		data[8] = "1";
			else if(temp.contains("druga"))		data[8] = "2";
			else if(temp.contains("tre"))		data[8] = "3";
			else		data[8] = "4";
	       }
	}

	public String[] getData()
	{
		return data;
	}
	
	public void clearData()
	{
		for(int i = 0; i < data.length; i++)		data[i] = "";
		data[8] = "1";
	}

}
