package programMethodes;

public class Memoire {
	Decodage MEM_DEC = new Decodage();
	

	
	public int[] AdressROM() {
		int[] AdressROM = new int [50];
		for(int i=0 ; i<50 ; i++) {
			AdressROM[i]= 0xFC00 + i;
		}
		return AdressROM;
	}
	
	public int[] InitValeurROM() {
		int[] ValeurROM = new int[50];
		for(int k=0 ; k<50 ; k++) {
			ValeurROM[k] = 0xFF;
		}
		return ValeurROM;
	}
	
	public int[] ValeurROM(String [] P1 , String P22[] , int P1_NumberOctets [] , int P22_NumberOctets [] , int taille ) {
		int ValueROM[] = new int [50];
		int j = 0;
		
		for( int k = 0 ; k<taille  ; k++)
		{	
			int X = 0x00;
			String Y = "";
			
			
			if(P1_NumberOctets [k] == 1)
			{
				Y =  MEM_DEC.toOpCodeImmediat(P1[k]);    // LDA ---> 86  donc valeurROM[0] = 86
				char Temp [] =Y.toCharArray();
				Y="";
				Y += Temp[0];
				Y += Temp[1];
				ValueROM[j] = MEM_DEC.hexToSignedInt(Y) & 0xFF;
				j++;

			}
		 if (P1_NumberOctets [k] == 2)
			{
			 
				Y = MEM_DEC.toOpCodeImmediat(P1[k]);   // pour LDS , on va avoir X = 10CE 'entier'
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
				ValueROM[j] = MEM_DEC.hexToSignedInt(P22[k]) & 0xFF;        // LDA #$99 donc on va avoir ValeurROM[1] = 99 entier signe.
				j++;
				
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
		int[] AdressRAM = {
			    0x0000, 0x0001, 0x0002, 0x0003, 0x0004, 0x0005, 0x0006, 0x0007,
			    0x0008, 0x0009, 0x000A, 0x000B, 0x000C, 0x000D, 0x000E, 0x000F,
			    0x0010, 0x0011, 0x0012, 0x0013, 0x0014, 0x0015, 0x0016, 0x0017,
			    0x0018, 0x0019, 0x001A, 0x001B, 0x001C, 0x001D, 0x001E, 0x001F,
			    0x0020, 0x0021, 0x0022, 0x0023, 0x0024, 0x0025, 0x0026, 0x0027,
			    0x0028, 0x0029, 0x002A, 0x002B, 0x002C, 0x002D, 0x002E, 0x002F,
			    0x0030, 0x0031
			};
		return AdressRAM;
	}
	
	public int[] InitValeurRAM() {
		int[] ValeurRAM = new int[50];
		for(int i = 0; i < 50; i++) {
			ValeurRAM[i] = 0x00;	
		}
		return ValeurRAM;
	}



}




