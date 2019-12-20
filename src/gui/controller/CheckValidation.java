package gui.controller;

public class CheckValidation {
	
		public static boolean checkName(String name)
		{
			name = name.trim();
			if(name.length() == 0)
				return false;
			for(int i = 0; i < name.length(); i++)
			{
				if(name.charAt(i) >= '0' && name.charAt(i) <= '9')
					return false;
			}
			return true;
		}
		
		@SuppressWarnings("unused")
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
			
			if(date.charAt(10) != '.')
				return false;
			return true;
		}
		
		public static boolean checkIndex(String index)
		{
			//ssX-YYYY or ssXX-YYYY or ssXXX-YYYY
			
			index = index.trim().toUpperCase();
			if(index.length() < 8 || index.length() > 10)
				return false;
			else if(index.charAt(0) < 'A' || index.charAt(0) > 'Z')
				return false;
			else if(index.charAt(1) < 'A' || index.charAt(1) > 'Z')
				return false;
			else if(index.charAt(2) < '0' || index.charAt(2) > '9')
				return false;
			
			int i = 3;
			if(index.length() == 8)
			{
				if(index.charAt(i++) != '-')
					return false;
			}
			else if(index.length() == 9)
			{
				if(index.charAt(i) < '0' || index.charAt(i++) > '9')
					return false;
				else if(index.charAt(i++) != '-')
					return false;
			}
			else
			{
				if(index.charAt(i) < '0' || index.charAt(i++) > '9')
					return false;
				if(index.charAt(i) < '0' || index.charAt(i++) > '9')
					return false;
				else if(index.charAt(i++) != '-')
					return false;
			}
			if(index.charAt(i) < '0' || index.charAt(i++) > '9')
				return false;
			else if(index.charAt(i) < '0' || index.charAt(i++) > '9')
				return false;
			else if(index.charAt(i) < '0' || index.charAt(i++) > '9')
				return false;
			else if(index.charAt(i) < '0' || index.charAt(i++) > '9')
				return false;
			return true;
		}
		
		public static boolean checkMail(String mail)
		{
			mail = mail.trim();
			if(!mail.contains("@"))
				return false;
			return true;
		}
		
		@SuppressWarnings("finally")
		public static boolean checkProsek(String prosek)
		{
			prosek = prosek.trim();
			Double p = 0.0;
			try 
			{
				p = Double.parseDouble(prosek);
			}
			catch(Exception e)
			{
				//e.printStackTrace();
				return false;
			}
			finally
			{
				if(p < 5.0 || p > 10.0)
					return false;
				return true;
			}
		}
		
		public static boolean checkPhoneNumber(String num)
		{
			//	nnn/nnn-nnn or nnn/nnn-nnnn
			
			num = num.trim();
			if(num.length() < 11 || num.length() > 12)
				return false;
			if(num.charAt(0) < '0' || num.charAt(0) > '9')
				return false;
			else if(num.charAt(1) < '0' || num.charAt(1) > '9')
				return false;
			else if(num.charAt(2) < '0' || num.charAt(2) > '9')
				return false;
			else if(num.charAt(3) != '/')
				return false;
			else if(num.charAt(4) < '0' || num.charAt(4) > '9')
				return false;
			else if(num.charAt(5) < '0' || num.charAt(5) > '9')
				return false;
			else if(num.charAt(6) < '0' || num.charAt(6) > '9')
				return false;
			else if(num.charAt(7) != '-')
				return false;
			else if(num.charAt(8) < '0' || num.charAt(8) > '9')
				return false;
			else if(num.charAt(9) < '0' || num.charAt(9) > '9')
				return false;
			else if(num.charAt(10) < '0' || num.charAt(10) > '9')
				return false;
			
			if(num.length() == 12)
				if(num.charAt(10) < '0' || num.charAt(10) > '9')
					return false;
			return true;
		}
		
		@SuppressWarnings({ "unused", "finally" })
		public static boolean[] isStudentValid(String[] data)
		{
			if(data.length != 10)
				return new boolean[data.length];
			
			boolean[] ret = {checkName(data[0]), checkName(data[1]), checkDate(data[2]), checkPhoneNumber(data[4]), checkMail(data[5]), checkIndex(data[6]), checkDate(data[7]), false, checkProsek(data[9])};
			
			byte g;
			try
			{
				g = Byte.parseByte(data[8]);
			}
			catch(Exception e)
			{
				return ret;
			}
			finally
			{
				ret[8] = true;
				return ret;
			}
		}
}
