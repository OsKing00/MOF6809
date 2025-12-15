package programMethodes;

import java.util.ArrayList;
import java.util.Scanner;

public class Erreurs {
	
	
	Scanner input = new Scanner(System.in); 
	Decodage ERR_DEC = new Decodage();

	String AllInstructionsP1immediat_1_1_octet[] = {"LDA","LDB","ADDA","ADDB"};
	String AllInstructionsP1immediat_1_2_octet[] = {"LDD","LDU","LDX","ADDD"};
	String AllInstructionsP1immediat_2_2_octet[] = {"LDS","LDY"};
	
/////////////////////////////////////////////////////////////////////
	public boolean CheckInstructionP1_2_octet(String P1)
	{
		if(P1.equals(null) || P1.equals(""))
		return false;
		
		for(String n : AllInstructionsP1immediat_1_1_octet)
		if(P1.equalsIgnoreCase(n))
		return true;
		
		return false;
	}
	public boolean CheckInstructionP1_3_octet(String P1)
	{
		if(P1.equals(null) || P1.equals(""))
		return false;
		
		for(String n : AllInstructionsP1immediat_1_2_octet)
		if(P1.equalsIgnoreCase(n))
		return true;
		
		return false;
	}
	public boolean CheckInstructionP1_4_octet(String P1)
	{
		if(P1.equals(null) || P1.equals(""))
		return false;
		
		for(String n : AllInstructionsP1immediat_2_2_octet)
		if(P1.equalsIgnoreCase(n))
		return true;
		
		return false;
	}
	
/////////////////////////////////////////////////////////////////////
	public boolean CheckSpaces(String T)
	{
		char SS[] = T.toCharArray();
		int countSpaces = 0; 
		for(int k = 0; k<SS.length ;k++)
		{
		if(SS[k]==' ')
			countSpaces++;
		}
		if(countSpaces==1)
			return true;
		else
			return false;
	}

/////////////////////////////////////////////////////////////////////
	public boolean CheckModeImmediat(char P21)
	{
		if(P21 == '#')
		return true;
		else
		return false;
	}

/////////////////////////////////////////////////////////////////////

	public boolean isHexadecimal(String P22) 
	{
		if(P22.equals(null) || P22.isEmpty())
		return false;
		char value[] = P22.toCharArray();
		for(int k = 0; k<value.length ; k++)
			{
				boolean isValue = value[k]>='0' && value[k]<='9';    
				boolean isLoweHex = value[k]>='a' && value[k]<='f';      
				boolean isHigherHex = value[k]>='A' && value[k]<='F';    
				if( !((isValue)||(isLoweHex)||(isHigherHex))) 
			return false;
			}
		return true;
	}
	
/////////////////////////////////////////////////////////////////////
	public boolean CheckHexa1octet(String a) {
		
		if (!a.matches("^[0-9A-Fa-f]{2}$")) {
	        return false;
	    }
		
	int value = Integer.parseInt(a, 16);
	return value <= 0xFF;
	}
	
/////////////////////////////////////////////////////////////////////
	public boolean CheckHexa2octet(String a) {
		
		if (!a.matches("^[0-9A-Fa-f]{4}$")) {
	        return false;
	    }
		
	int value = Integer.parseInt(a, 16);
	return value <= 0xFFFF;
	}
	
////////////////////////////////////////////////////////////////////
	
   public boolean CheckSyntaxErrorsImmediat(String T,String P1 , char P21 , String P22)
   {
	   if(   (  (CheckInstructionP1_2_octet(P1))&&(CheckModeImmediat(P21))&&(isHexadecimal(P22))&&(CheckHexa1octet(P22))&&(CheckSpaces(T))  )  ||   
			 (  (CheckInstructionP1_3_octet(P1))&&(CheckModeImmediat(P21))&&(isHexadecimal(P22))&&(CheckHexa2octet(P22))&&(CheckSpaces(T))  )  ||
			    (CheckInstructionP1_4_octet(P1))&&(CheckModeImmediat(P21))&&(isHexadecimal(P22))&&(CheckHexa2octet(P22))&&(CheckSpaces(T))             )
	   {
		   return true;
	   }
	   return false;
   }



		
//////////////////////////////////////////////////////////////////////////////////

	public String AfficheCompilation(ArrayList<String> AA, String BB[], char CC[], String DD[]) {

	    String output = "";
	    int i = 0;
	    boolean hasError = false;

	    int max = Math.min(AA.size(), 20);
	    while (i < max && AA.get(i) != null) {
	        String line = AA.get(i).trim();

	        if (line.equalsIgnoreCase("END"))
	            break;

	        boolean syntaxOk = false;
	        if (i < BB.length && i < CC.length && i < DD.length) {
	            syntaxOk = CheckSyntaxErrorsImmediat(AA.get(i) , BB[i], CC[i], DD[i]);
	        } else {
	            syntaxOk = false;
	        }

	        if (!syntaxOk) {
	            hasError = true;
	            output += "Error At line " + (i + 1) + "\n";
	        }

	        i++;
	    }

	    if (AA.size() == 0 || !AA.get(AA.size() - 1).trim().equalsIgnoreCase("END")) {
	        hasError = true;
	        output += "Missing END at last line\n";
	    }

	    if (!hasError) {
	        output = "Code Correct";
	    }

	    return output;
	}

	
	//***********************************************

	public int ErrorNumbers(ArrayList<String> AA, String BB[], char CC[], String DD[]) {
		
		int ErrorsCounter = 0;
		int i = 0;
	    boolean hasError = false;

	    int max = Math.min(AA.size(), 20);
	    while (i < max && AA.get(i) != null) {
	        String line = AA.get(i).trim();

	        if (line.equalsIgnoreCase("END"))
	            break;

	        boolean syntaxOk = false;
	        if (i < BB.length && i < CC.length && i < DD.length) {
	            syntaxOk = CheckSyntaxErrorsImmediat(AA.get(i) , BB[i], CC[i], DD[i]);
	        } else {
	            syntaxOk = false;
	        }

	        if (!syntaxOk) {
	            hasError = true;
	            ErrorsCounter ++;
	        }

	        i++;
	    }

	    if (AA.size() == 0 || !AA.get(AA.size() - 1).trim().equalsIgnoreCase("END")) {
	        hasError = true;
	        ErrorsCounter ++;
	    }

	    if (!hasError) {
	    	ErrorsCounter = 0;
	    }

	    return ErrorsCounter;
	}
	
//////////////////////////////////////////////////////////////////////////////////
	
	public int[] P1_NumberOctets(String P1[]  , int taille )
	   {
		   int TailleOpCode [] = new int [taille];
		   int conteur = 0;
		   
		   
		   for(int k = 0 ; k<P1.length ; k++)
		   {
			   String S="";
			   conteur = 0;
			   
			   if(P1[k]!=null && !P1[k].isEmpty()) {
			   S = ERR_DEC.toOpCodeImmediat( P1[k] );   // supposons S = "86" 'LDA'.
			   }
			  //  Convert int to String, then to char array
		        char[] Temp = S.toCharArray();
		        conteur = Temp.length;
		        TailleOpCode[k] = conteur / 2;

		   }
		   return TailleOpCode;
	   }
	
	public int[] P22_NumberOctets(String P22[]  , int taille )
	   {
		   int TailleValeur [] = new int [taille];
		   int conteur = 0;
		   
		   for(int k = 0 ; k<taille ; k++)     // LDS #$99AB      value  = "99AB"
		   {
			   
			   if(P22[k]!=null && !P22[k].isEmpty()) {
			   char Temp[] = P22[k].toCharArray();
			   conteur = Temp.length;
			   TailleValeur[k] = conteur / 2;
			   }
		   }
		   return TailleValeur;
	   }
	
	
}



