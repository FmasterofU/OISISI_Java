package rs.ac.uns.ftn.ssluzba.gui.controller;

import rs.ac.uns.ftn.ssluzba.gui.model.Data;

public class CheckValidation {
	
		public static boolean checkName(String name, int mode)
		{
			/*
			 * mode: 
			 * 		0 - Imena/Prezimena
			 * 		1 - Sifre
			 * 		2 - Naziv predmeta
			 */
			name=name.trim();
			switch(mode) {
			case 0: return name.matches("[a-zA-ZšđčćžŠĐČĆŽ ]+");
			case 1: return name.matches("[a-zA-Z0-9\\-\\.]+");
			case 2: return name.matches("[a-zA-ZšđčćžŠĐČĆŽ 1-9]+");
			default: return false;
			}
		}
		
		public static boolean checkDate(String date)
		{
			//dd.mm.yyyy.
			
			date = date.trim();
			if(date.length() != 11)
				return false;
			else if(date.charAt(0) < '0' || date.charAt(0) > '3')
				return false;
			else if(date.charAt(1) < '0' || date.charAt(1) > '9')
				return false;
			String dan = date.substring(0, 2);
			int d;
			if((d = Integer.parseInt(dan)) > 31)
				return false;
			if(d == 0)
				return false;
			
			if(date.charAt(2) != '.')
				return false;
			else if(date.charAt(3) < '0' || date.charAt(3) > '1')
				return false;
			else if(date.charAt(4) < '0' || date.charAt(4) > '9')
				return false;
			String mesec = date.substring(3, 5);
			int m;
			if((m = Integer.parseInt(mesec)) > 12)
				return false;
			if(m == 0)
				return false;
			
			if(!doesHave31Days(m) && (d == 31))
				return false;
			
			if(date.charAt(5) != '.')
				return false;
			else if(date.charAt(6) < '0' || date.charAt(6) > '2')
				return false;
			else if(date.charAt(7) < '0' || date.charAt(7) > '9')
				return false;
			else if(date.charAt(8) < '0' || date.charAt(8) > '9')
				return false;
			else if(date.charAt(9) < '0' || date.charAt(9) > '9')
				return false;
			String godina = date.substring(6, 10);
			int god;
			if((god = Integer.parseInt(godina)) > 2019)
				return false;
			if(god < 1930)
				return false;
			
			if(m==2 && d > 29)
				return false;
			if((!isLeapYear(god)) && (m == 2) && (d >= 29))
				return false;
			
			if(date.charAt(10) != '.')
				return false;
			return true;
		}
		
		public static boolean checkIndex(String index)
		{
			//	ssX/YYYY or ssXX/YYYY or ssXXX/YYYY
			
			index = index.trim().toUpperCase();
			if(!checkIndexYear(index))
				return false;
			if(Data.data.listaStudenata.indexExists(index))		return false;
			return index.matches("[a-zA-Z]{2}[1-9][0-9]{0,2}/[0-9]{4}");
		}
		
		public static boolean checkIndexYear(String index)
		{
			String s = "0";
			Double year = 0.0;
			if(index.length() > 4)
			{
				s = index.substring(index.length() - 4, index.length());
			}
			try
			{
				year = Double.parseDouble(s);
				if(year <= 2019)
					return true;
				return false;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public static boolean checkMail(String mail)
		{
			mail = mail.trim();
			return mail.matches("([a-zA-Z0-9]+\\.?)*[a-zA-Z0-9]@[a-z0-9]+(\\.[a-z]{2,3})+");
		}
		
		public static boolean checkProsek(String prosek)
		{
			prosek = prosek.trim();
			return prosek.matches("(5)|(5\\.0)|(5\\.00)|([6-9]\\.[0-9]{1,2})|(10)|(10\\.0)|(10\\.00)");
		}
		
		public static boolean checkPhoneNumber(String num)
		{
			//	0nn/nnn-nnn or 0nn/nnn-nnnn or 0nn/nnn-nnnnn for domestic numbers
			//    +MMMnn/nnn-nnn or +MMMnn/nnn-nnnn or +MMMnn/nnn-nnnnn for foreign numbers
			
			num = num.trim();
			//return num.matches("0[1-9][0-9][/][0-9]{3}-[0-9]{3,5}");
			return num.matches("(\\+[1-9][0-9]{2}|0)[1-9][0-9][/][0-9]{3}-[0-9]{3,5}");
		}
		
		public static boolean checkAdress(String adress)
		{
			adress = adress.trim();
			if(adress.length() == 0)
				return false;
			return true;
		}
		
		public static boolean isLeapYear(int god)
		{
			if((god % 4 == 0) && (god % 100 != 0))
				return true;
			else if((god % 4 == 0) && (god % 100 == 0) && (god % 400 == 0))
				return true;
			else
				return false;
		}
		
		public static boolean doesHave31Days(int mes)
		{
			switch(mes)
			{
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					return true;
				default:
					return false;
			}
		}
		
		public static boolean[] isStudentValid(Object[] data, boolean editable)
		{
			if(data.length != 10)
				return new boolean[2];
			
			for(Object o : data)
				if(o == null)	return new boolean[2];
			
			boolean[] ret = {checkName((String)data[0],0), checkName((String)data[1],0), checkDate((String)data[2]), checkAdress((String)data[3]), checkPhoneNumber((String)data[4]), checkMail((String)data[5]), checkIndex((String)data[6]) || editable, checkDate((String)data[7]), data[8] != null ? true : false, checkProsek((String)data[9])};
			//if(!data[8].equals(""))	ret[8] = true;
			return ret;
		}

		public static boolean[] isPredmetValid(Object[] o, boolean editable) {
			boolean[] ret = { (o[0]!=null ? (checkName((String) o[0], 1) && checkUniquePredmetCode((String) o[0])) : false) || editable, o[1]!=null ? (checkName((String) o[1], 2) && checkUniquePredmetCode((String) o[1])) : false, o[2]!=null ? true : false, o[3]!=null ? true : false, o[4]!=null ? true : false };
			return ret;
		}

		public static boolean checkUniquePredmetCode(String text) {
			return !Data.data.listaPredmeta.predmetCodeExists(text);
		}
		
		public static boolean checkUniqueProfesorID(String id) {
			return !Data.data.listaProfesora.profesorIDExists(id);
		}

		public static boolean checkSemester(String text) {
			return text.matches("[1-8]");
		}

		public static boolean checkSelection(Object selectedItem) {
			return selectedItem != null ? true : false;
		}
		
		public static boolean checkLK(String lk)
		{
			return lk.matches("[0-9]{9}");
		}
		
		public static boolean checkTitula(String t)
		{
			return t.matches("[a-zA-Z]+");
		}
		
		public static boolean checkZvanje(String z)
		{
			return z.matches("[a-zA-Z]+");
		}
		
		public static boolean[] isProfesorValid(Object[] data, boolean editable)
		{
			if(data.length != 10)
				return new boolean[2];
			for(Object o : data)
				if(o == null)	return new boolean[2];
			
			boolean[] ret = {checkName((String) data[0],0), checkName((String) data[1],0), checkDate((String) data[2]), checkAdress((String) data[3]), checkPhoneNumber((String) data[4]), checkMail((String) data[5]), checkAdress((String) data[6]), (checkLK((String) data[7]) && checkUniqueProfesorID((String) data[7])) || editable, checkTitula((String) data[8]), checkZvanje((String) data[9])};
			return ret;
		}
		
		public static String firstLetterToCapital(String s)
		{
			String[]	temp = s.split(" ");
			String ret = "";
			
			for(int i = 0; i < temp.length; i++)
			{
				String a = temp[i].substring(0, 1).toUpperCase();
				String b = temp[i].substring(1, temp[i].length()).toLowerCase();
				temp[i] = a+b;
				ret += temp[i];
				if(i != temp.length - 1)	ret += " ";
			}
			return ret;
		}
}
