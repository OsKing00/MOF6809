package programMethodes;

import java.util.ArrayList;
import java.util.Scanner;

public class Instructions {
	Scanner input = new Scanner(System.in);
    
   private String P1[];
   private String P2[];
   private char  P21[];
   private String P22[];
  
/////////////////////////////////////////////////////////////////////////////

	public String[] GetP1(ArrayList <String> T)
	{
	    int i=0;
	    int j;
	    int taille = T.size();
	    P1 = new String[taille];
	    while (i<taille)
	    {
	        String line = T.get(i);
	        if (line == null) {
	            P1[i] = "";
	            i++;
	            continue;
	        }
	        line = line.trim();
	        if(line.equalsIgnoreCase("END"))
	            break;

	        char[] SS = line.toCharArray();
	        P1[i] = "";

	        for(j=0 ; j<SS.length && SS[j]!=' ' ; j++)
	            P1[i]+= SS[j];

	        i++;
	    }
	    return P1;
	}

/////////////////////////////////////////////////////////////////////////////

	public String[] GetP2(ArrayList<String> T) {
	    int i = 0;
	    int taille = T.size();

	   
	    P2 = new String[taille];

	    while (i < taille) {
	        String line = T.get(i);
	        if (line == null) { 
	            P2[i] = "";
	            i++;
	            continue;
	        }

	       
	        if (line.trim().equalsIgnoreCase("END")) {
	            break;
	        }

	        int spaceIndex = line.indexOf(' ');
	        if (spaceIndex != -1) {
	            P2[i] = line.substring(spaceIndex + 1).trim();
	        } else {
	            P2[i] = ""; 
	        }
	        i++;
	    }

	 
	    return P2;
	}
	
/////////////////////////////////////////////////////////////////////////////

	public char[] GetModeAdressage (String P2[])
	{
		P21 = new char[P2.length];
		int k=0;
		while (k<P2.length)
		{	
			P21[k]='\0';
			
			if (P2[k] == null) {
	            k++;
	            continue;
	        }

	       
	        String s = P2[k].trim();

	       
	        if (s.length() == 0) {
	            k++;
	            continue;
	        }

	       
	        char SS[] = s.toCharArray();

	    
	        if (SS[0] != '$')
	            P21[k] = SS[0];

	        k++;
	    }
	    return P21;
	}
	
/////////////////////////////////////////////////////////////////////////////

	public String[] GetValue(String P2[])
	{
		P22 = new String[P2.length];
		int k = 0;
		while(k < P2.length && P2[k] != null && !P2[k].equals(""))
		{
			P22[k]="";
			char SS[] = P2[k].toCharArray();
			
            if(SS[0]=='$')
            {
            	for(int x = 1 ; x<SS.length ; x++)
            	    P22[k] = P22[k] + SS[x]; 
            }
            else
            	for(int x = 2 ; x<SS.length ; x++)
            	    P22[k] = P22[k] + SS[x]; 
            k++;
		}
		return P22;
	}
}




