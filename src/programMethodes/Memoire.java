package programMethodes;

import java.util.ArrayList;

public class Memoire {
	Decodage MEM_DEC = new Decodage();
	

	
	public int[] AdressROM() {
		int[] AdressROM = new int [1024];
		for(int i=0 ; i<1024 ; i++) {
			AdressROM[i]= 0xFC00 + i;
		}
		return AdressROM;
	}
	
	public int[] InitValeurROM() {
		int[] ValeurROM = new int[1024];
		for(int k=0 ; k<1024 ; k++) {
			ValeurROM[k] = 0xFF;
		}
		return ValeurROM;
	}
	
	public int[] ValeurROM(ArrayList<String> AA,String [] P1, char[] P21 , String P22[] , int P1_NumberOctets [] , int P22_NumberOctets [] , int taille ) {
		int ValueROM[] = new int [1024];
		int j = 0;
		
		for( int k = 0 ; k<taille  ; k++)
		{	
			int X = 0x00;
			String Y = "";
			
			
			if(P1_NumberOctets [k] == 1)
			{
				Y =  MEM_DEC.InstructionIoOpCode(P1[k], P21[k],AA.get(k));    // LDA ---> 86  donc valeurROM[0] = 86
				char Temp [] =Y.toCharArray();
				Y="";
				Y += Temp[0];
				Y += Temp[1];
				ValueROM[j] = MEM_DEC.hexToSignedInt(Y) & 0xFF;
				j++;

			}
		 if (P1_NumberOctets [k] == 2)
			{
			 
				Y = MEM_DEC.InstructionIoOpCode(P1[k],P21[k],AA.get(k));   // pour LDS , on va avoir X = 10CE 'entier'
		        char[] Temp = String.valueOf(Y).toCharArray();   // 1 | 0 | C | E
		        for(int r = 0 ; r<4 ; r+=2)
		        {
		        	Y = "";
		        	Y+=Temp[r];
		        	Y+=Temp[r+1];
		        	X = MEM_DEC.HexaStringToInt(Y);
		        	ValueROM[j] = X & 0xFF;
		        	j++;
		        }
			}
			//
		 if (P22_NumberOctets [k] == 1)
			{
			 if(P22[k].equals("DP"))
			 {}
			 else {
				ValueROM[j] = MEM_DEC.hexToSignedInt(P22[k]) & 0xFF;        // LDA #$99 donc on va avoir ValeurROM[1] = 99 entier signe.
				j++;}
			}
		 if(P22_NumberOctets [k] == 2)
			{
		        char[] Temp = P22[k].toCharArray();  // 1 | 0 | C | E
		        for(int r = 0 ; r<4 ; r+=2)
		        {
		        	Y = "";
		        	Y+=Temp[r];
		        	Y+=Temp[r+1];
		        	X = MEM_DEC.hexToSignedInt(Y);
		        	ValueROM[j] = X & 0xFF;
		        	j++;
		        }
			}
		 ValueROM[j] = 0x3F;
		}
	return ValueROM;
	}
	
	
	
	
	
	
	
	
	
	
	
	public int[] AdressRAM() {
		int[] AdressRAM = new int [1280];
		for(int i=0 ; i<1280 ; i++) {
			AdressRAM[i]= 0x0000 + i;
		}
		return AdressRAM;
	}
	
	public int[] InitValeurRAM() {
		int[] ValeurRAM = new int[1280];
		for(int i = 0; i < 1280; i++) {
			ValeurRAM[i] = 0x00;	
		}
		return ValeurRAM;
	}



}




