package programMethodes;

import java.util.ArrayList;

public class UAL {
	Decodage UAL_DEC = new Decodage();
	public int CheckCarry8(int A[] , int ADDA[])
	{
		int Carry = 0;
		int i = 7;
		
		if(A[i] + ADDA[i]==2)
			Carry = 1;
		 	
		if(A[i] + ADDA[i]==0)
			 Carry = 0;
		
			while(A[i] + ADDA[i]==1 && i>=0)
			{
				i--;
				if(A[i] + ADDA[i]==2) {
					Carry = 1;
					break;
				}
				else if (A[i] + ADDA[i]==0) {
					Carry = 0;
					break;
				}			
			}	
			return Carry;	
	}
	public int CheckCarry16(int A[] , int ADDA[])
	{
		int Carry = 0;
		int i = 15;
		
		if(A[i] + ADDA[i]==2)
			Carry = 1;
		 	
		if(A[i] + ADDA[i]==0)
			 Carry = 0;
		
			while(A[i] + ADDA[i]==1 && i>=0)
			{
				i--;
				if(A[i] + ADDA[i]==2) {
					Carry = 1;
					break;
				}
				else if (A[i] + ADDA[i]==0) {
					Carry = 0;
					break;
				}			
			}	
			return Carry;	
	}
	
	public int CheckHalfCarry8(int A[] , int ADDA[])
	{
		int Carry = 0;
		int i = 3;
		
		if(A[i] + ADDA[i]==2)
			Carry = 1;
		 	
		if(A[i] + ADDA[i]==0)
			 Carry = 0;
		
			while(A[i] + ADDA[i]==1 && i>=0)
			{
				i--;
				if(A[i] + ADDA[i]==2) {
					Carry = 1;
					break;
				}
				else if (A[i] + ADDA[i]==0) {
					Carry = 0;
					break;
				}			
			}	
			return Carry;	
	}
	public int CheckHalfCarry16(int A[] , int ADDA[])
	{
		int Carry = 0;
		int i = 7;
		
		if(A[i] + ADDA[i]==2)
			Carry = 1;
		 	
		if(A[i] + ADDA[i]==0)
			 Carry = 0;
		
			while(A[i] + ADDA[i]==1 && i>=0)
			{
				i--;
				if(A[i] + ADDA[i]==2) {
					Carry = 1;
					break;
				}
				else if (A[i] + ADDA[i]==0) {
					Carry = 0;
					break;
				}			
			}	
			return Carry;	
	}
	
	public int CheckSigne(int Result)
	{
		int N = 0;
		if (Result < 0 )
			N = 1;
		else 
			N = 0;	
		return N;
	}
	
	public int CheckZero(int Result)
	{
		int Z = 0;
		if(Result == 0)
			Z = 1;
		else 
			Z = 0;
		return Z;
	}
	
	public int CheckParity(int Result)
	{
		int P =0;
		int tmp = Result;
		tmp = tmp/2;
		tmp = tmp*2;
		
		if (Result == tmp)
			P = 1;
		else
			P = 0;
		return P;
	}
	
	public int CheckOverFlow(int entr1 , int entr2 , int Result)
	{
		int V = 0;
		if(entr1*entr2 >= 0)
		{
			if(entr1*Result>=0)
			{
				V = 0;
			}
			else
			{
				V = 1;
			}
		}
		else {
			V = 0;
		}
		return V;
	}
	
	public int[] OR_8bits(int Tab1[] , int Tab2[])
	{
		int ResultatOR [] = new int [8];
		 for(int i = 0 ; i<8 ; i++)
		 {
			 if( (Tab1[i]==Tab2[i]) && Tab1[i] ==0 )
				 ResultatOR[i] = 0;
			 
			 if(  (Tab1[i] != Tab2[i])  || ((Tab1[i]==Tab2[i]) && Tab1[i] ==1))
				 ResultatOR[i] = 1;
		 }
		 return ResultatOR;
	}
	
	public static int Binary8_ToInt(int Binaire[])
    {
        int Res = 0;
        int counter = 0;
        while (counter < 8)
        {
            Res += Math.pow(2,counter)*Binaire[counter];
            counter++;
        }
       return Res;
    }
	
	public int[] AND_8bits(int Tab1[] , int Tab2[])
	{
		int ResultatAND [] = new int [8];
		 for(int i = 0 ; i<8 ; i++)
		 {
			 if( (Tab1[i]==Tab2[i]) && Tab1[i] ==1 )
				 ResultatAND[i] = 1;
			 
			 else
				 ResultatAND[i] = 0;
			 
		 }
		 return ResultatAND;
	}
	public int[] DecimalToTwosComplement8(int valeur) {
	    int[] resultat = new int[8];
	    
	    for (int i = 0; i < 8; i++) {
	        resultat[i] = (valeur >> i) & 1;
	    }
	    
	    return resultat;
	}
	public int[] DecimalToTwosComplement16(int valeur) {
	    int[] resultat = new int[16];
	    for (int i = 0; i < 16; i++) {
	        resultat[i] = (valeur >> i) & 1;
	    }
	    
	    return resultat;
	}
	public int SignedBinaryToInteger(int[] binaire) {
	    int rawValue = 0;

	    
	    for (int i = 0; i < 8; i++) {
	        if (binaire[i] == 1) {
	            
	            rawValue += (1 << i); 
	        }
	    }
	    return rawValue;
	}
	
	public static class CalculMembers {
		public ArrayList<Integer> A;
		public ArrayList<Integer> B;
		public ArrayList<Integer> S;
		public ArrayList<Integer> U;
		public ArrayList<Integer> X;
		public ArrayList<Integer> Y;
		public ArrayList<Integer> DP;
		public ArrayList<int[]> CCR;
		public ArrayList<int[]> Valram;
		

		public CalculMembers (ArrayList<Integer> A, ArrayList<Integer> B ,ArrayList<Integer> S , ArrayList<Integer> Y
				,ArrayList<Integer> X, ArrayList<Integer> U, ArrayList<Integer> DP, ArrayList<int[]> CCR, ArrayList<int[]> Valram) 
		     {this.A=A; this.B=B; this.S=S; this.Y=Y; this.X=X; this.U=U; this.DP=DP; this.CCR=CCR; this.Valram=Valram;}
	}
	
	  public int toSignedByte(int x, int nbOctet ) {
		 if(nbOctet == 1)
			 return (int) (byte) (x & 0xFF);
		 else 
			 return (int) (short) (x & 0xFFFF);  
		 
}


	public CalculMembers Calcule(ArrayList<String> AA, int PC[], String P1[], char P21[], int ValueROM[],int ADRAM[], int P1_NumberOctets[] , int P22_NumberOctets []) {
	    int A = 0x00;
	    int B = 0x00;
	    int DP = 0x00;
	    
	    int S = 0x0000;
	    int Shigh = 0x00;
	    int Slow = 0x00;
	    
	    int Y = 0x0000;
	    int Yhigh = 0x00;
	    int Ylow = 0x00;
	    
	    int X = 0x0000;
	    int Xhigh = 0x00;
	    int Xlow = 0x00;
	    
	    int U = 0x0000;
	    int Uhigh = 0x00;
	    int Ulow = 0x00;
	    
	    int D = 0x0000;
	    int Dhigh = 0x00;
	    int Dlow = 0x00;
	    
	    int Ad = 0x0000;
	    int AdHigh=0x00;
    	int AdLow=0x00;
	    
	    
	    ArrayList<Integer> valeursA = new ArrayList<>();
	    ArrayList<Integer> valeursB = new ArrayList<>();
	    ArrayList<Integer> valeursS = new ArrayList<>();
	    ArrayList<Integer> valeursY = new ArrayList<>();
	    ArrayList<Integer> valeursX = new ArrayList<>();
	    ArrayList<Integer> valeursU = new ArrayList<>();
	    ArrayList<Integer> valeursDP = new ArrayList<>();
	    ArrayList<int[]> CCR = new ArrayList<>();
	    ArrayList<int[]> Valram = new ArrayList<>();
	    


	    int k = 0;
	    int l = 1;
	    int Temp = 0;
	    
	    int entry1 = 0; int entry2 = 0; int res = 0;
    	int entry1Bin8[] = new int [8];  int entry2Bin8[] = new int [8];
    	int entry1Bin16[] = new int [16];  int entry2Bin16[] = new int [16];
    	
    	int [] flags = new int [8];
    	flags[5]=1;
    	flags[0]=1;
    	int [] valram = new int [1280];
    	
    	
    	CCR.add(flags.clone());
    	
	    while (k < P1.length      &&       P1[k] != null      &&      !P1[k].isEmpty()     &&     l<ValueROM.length) 
	    {
	    	String OTH_INS = AA.get(k);
	    	OTH_INS = OTH_INS.replaceAll("\\s+", "");
	    	Temp += P1_NumberOctets[k] + P22_NumberOctets[k];
	    	
	    	if(P21[k] == '#') {
	    	
	        if (P1[k].equalsIgnoreCase("LDA")) {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = A;
	            A = ValueROM[Temp - 1] & 0xFF;
	            entry2 = ValueROM[Temp - 1];
	            entry1Bin8 = DecimalToTwosComplement8(entry1);
	            entry2Bin8 = DecimalToTwosComplement8(entry2);
	            res = toSignedByte(A , 1);
	            
	            flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	        }
	        else if (P1[k].equalsIgnoreCase("ADDA")) {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = A;
	        	A = (A + ValueROM[Temp - 1]) & 0xFF;
	        	entry2 = ValueROM[Temp - 1];
	        	entry1Bin8 = DecimalToTwosComplement8(entry1);
	            entry2Bin8 = DecimalToTwosComplement8(entry2);
	        	res = toSignedByte(A , 1);
	            
	        	flags[6]=CheckCarry8(entry1Bin8,entry2Bin8);
	        	flags[2]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	        }
	        else if (P1[k].equalsIgnoreCase("LDB")) {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = B;
	        	B = ValueROM[Temp - 1] & 0xFF;
	        	entry2 = ValueROM[Temp - 1];
	        	entry1Bin8 = DecimalToTwosComplement8(entry1);
	            entry2Bin8 = DecimalToTwosComplement8(entry2);
	        	res = toSignedByte(B , 1);
	            
	            flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	        }
	        else if (P1[k].equalsIgnoreCase("ADDB")) {
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = B;
		        	B = (B + ValueROM[Temp - 1]) & 0xFF;
		        	entry2 = ValueROM[Temp - 1];
		        	entry1Bin8 = DecimalToTwosComplement8(entry1);
		            entry2Bin8 = DecimalToTwosComplement8(entry2);
		        	res = toSignedByte(B , 1);
		            
		        	flags[6]=CheckCarry8(entry1Bin8,entry2Bin8);
		        	flags[2]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=CheckOverFlow(entry1,entry2,res);
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
	        }
	        else if (P1[k].equalsIgnoreCase("LDS"))
	        {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = S;
	        	Shigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
	        	Slow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
	        	
	        	String S1 = "";
	        	
	        	if(Slow<16) {
	        		S1 = Integer.toHexString(Shigh);
	        		S1 += "0";
		        	S1 +=  Integer.toHexString(Slow);
	        	}
	        	else {
	        	S1 = Integer.toHexString(Shigh); 
	        	S1 +=  Integer.toHexString(Slow);
	        	}
	        	
	        	S = Integer.parseInt(S1, 16) & 0xFFFF;
	        	entry2 = S;
	        	res = toSignedByte(S , 2);
	        	
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	        }
	        else if (P1[k].equalsIgnoreCase("LDY"))
	        {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = Y;
	        	Yhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
	        	Ylow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
	        	
	        	String Y1 = "";
	        	
	        	if(Ylow<16) {
	        		Y1 = Integer.toHexString(Yhigh);
	        		Y1 += "0";
		        	Y1 +=  Integer.toHexString(Ylow);
	        	}
	        	else {
	        	Y1 = Integer.toHexString(Yhigh); 
	        	Y1 +=  Integer.toHexString(Ylow);
	        	}
	        	
	        	Y = Integer.parseInt(Y1, 16) & 0xFFFF;
	        	entry2 = Y;
	        	res = toSignedByte(Y , 2);
	        	
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));	
	        }
	        else if (P1[k].equalsIgnoreCase("LDX"))
	        {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = X;
	        	Xhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
	        	Xlow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
	        	
	        	String X1 = "";
	        	
	        	if(Xlow<16) {
	        		X1 = Integer.toHexString(Xhigh);
	        		X1 += "0";
		        	X1 +=  Integer.toHexString(Xlow);
	        	}
	        	else {
	        	X1 = Integer.toHexString(Xhigh); 
	        	X1 +=  Integer.toHexString(Xlow);
	        	}
	        	
	        	X = Integer.parseInt(X1, 16) & 0xFFFF;
	        	entry2 = X;
	        	res = toSignedByte(X , 2);
	        	
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	        }
	        else if (P1[k].equalsIgnoreCase("LDU"))
	        {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = U;
	        	Uhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
	        	Ulow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
	        	
	        	String U1 = "";
	        	
	        	if(Ulow<16) {
	        		U1 = Integer.toHexString(Uhigh);
	        		U1 += "0";
		        	U1 +=  Integer.toHexString(Ulow);
	        	}
	        	else {
	        	U1 = Integer.toHexString(Uhigh); 
	        	U1 +=  Integer.toHexString(Ulow);
	        	}
	        	
	        	U = Integer.parseInt(U1, 16) & 0xFFFF;
	        	entry2 = U;
	        	res = toSignedByte(U , 2);
	        	
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	        }
	        else if (P1[k].equalsIgnoreCase("LDD"))
	        {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = toSignedByte(D,2);
	        	Dhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
	        	Dlow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
	        	
	        	String D1 = "";
	        	String D2 = "";
	        	
	        	if(Dlow<16) {
	        		D1 = Integer.toHexString(Dhigh);
	        		D1 += "0";
		        	D1 +=  Integer.toHexString(Dlow);
	        	}
	        	else {
	        	D1 = Integer.toHexString(Dhigh); 
	        	D1 +=  Integer.toHexString(Dlow);
	        	}
	        	
	        	int Dtmp = toSignedByte(Integer.parseInt(D1, 16),2);
	        	D = Dtmp & 0xFFFF;
	        	entry2 = toSignedByte(Integer.parseInt(D1, 16) , 2);
	        	entry1Bin16 = DecimalToTwosComplement16(entry1);
	            entry2Bin16 = DecimalToTwosComplement16(entry2);
	        	res = toSignedByte(D , 2);
	            
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	A=Dhigh & 0xFF;
	        	B=Dlow & 0xFF;
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1));
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	            
	            if(B<16) {
	        		D2 = Integer.toHexString(A);
	        		D2 += "0";
		        	D2 +=  Integer.toHexString(B);
	        	}
	        	else {
	        	D2 = Integer.toHexString(A); 
	        	D2 +=  Integer.toHexString(B);
	        	}
	        	
	        	int D_AB = toSignedByte(Integer.parseInt(D2, 16),2);
	        	D=D_AB;
	        }
	        else if (P1[k].equalsIgnoreCase("ADDD")) {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = D;
	        	Dhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
	        	Dlow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
	        	
	        	String D1 = "";
	        	String D2 = "";
	        	
	        	if(Dlow<16) {
	        		D1 = Integer.toHexString(Dhigh);
	        		D1 += "0";
		        	D1 +=  Integer.toHexString(Dlow);
	        	}
	        	else {
	        	D1 = Integer.toHexString(Dhigh); 
	        	D1 +=  Integer.toHexString(Dlow);
	        	}
	        	
	        	int Dtmp = toSignedByte(Integer.parseInt(D1, 16),2);
	        	D = toSignedByte(D,2);
	        	D = (D + Dtmp) & 0xFFFF;
	        	entry2 = Dtmp;
	        	entry1Bin16 = DecimalToTwosComplement16(entry1);
	            entry2Bin16 = DecimalToTwosComplement16(entry2);
	        	res = toSignedByte(D , 2);
	        	
	        	if(B<16) {
	        		D2 = Integer.toHexString(A);
	        		D2 += "0";
		        	D2 +=  Integer.toHexString(B);
	        	}
	        	else {
	        	D2 = Integer.toHexString(A); 
	        	D2 +=  Integer.toHexString(B);
	        	}
	        	
	        	int D_AB = toSignedByte(Integer.parseInt(D2, 16),2);
	        	D_AB +=Dtmp & 0xFFFF;
	        	
	        	int D_ABhigh = (D_AB >> 8) & 0xFF;
	            int D_ABlow  = D_AB & 0xFF;
	            
	        	flags[6]=CheckCarry16(entry1Bin16,entry2Bin16);
	        	//flags[2]=CheckHalfCarry16(entry1Bin16,entry2Bin16);
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	A=D_ABhigh & 0xFF;
	        	B=D_ABlow & 0xFF;
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1));
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	            D=D_AB;
	        }
	        else if (P1[k].equalsIgnoreCase("SUBA")) {
	        	
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = A;
	        	
	        	A = (A - ValueROM[Temp - 1]) & 0xFF;
	        	entry2 = ValueROM[Temp - 1];
	        	entry1Bin8 = DecimalToTwosComplement8(entry1);
	            entry2Bin8 = DecimalToTwosComplement8(entry2);
	        	res = toSignedByte(B , 1);
	            
	        	flags[0]=CheckCarry8(entry1Bin8,entry2Bin8);
	            flags[1]=CheckOverFlow(entry1,entry2,res);
	        	flags[2]=CheckZero(res);
	        	flags[3]=CheckSigne(res);
	            flags[4]=CheckParity(res);
	        	flags[5]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	        }
	    	
	        else if (P1[k].equalsIgnoreCase("SUBB")) {
	        	
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = B;
	        	
	        	B = (B - ValueROM[Temp - 1]) & 0xFF;
	        	entry2 = ValueROM[Temp - 1];
	        	entry1Bin8 = DecimalToTwosComplement8(entry1);
	            entry2Bin8 = DecimalToTwosComplement8(entry2);
	        	res = toSignedByte(B , 1);
	            
	        	flags[0]=CheckCarry8(entry1Bin8,entry2Bin8);
	            flags[1]=CheckOverFlow(entry1,entry2,res);
	        	flags[2]=CheckZero(res);
	        	flags[3]=CheckSigne(res);
	            flags[4]=CheckParity(res);
	        	flags[5]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
	        	
	        	CCR.add(flags.clone());
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	        }
	    	
	        else if (P1[k].equalsIgnoreCase("SUBD")) {
	        	
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = D;
	        	Dhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
	        	Dlow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
	        	
	        	String D1 = "";
	        	String D2 = "";
	        	
	        	if(Dlow<16) {
	        		D1 = Integer.toHexString(Dhigh);
	        		D1 += "0";
		        	D1 +=  Integer.toHexString(Dlow);
	        	}
	        	else {
	        	D1 = Integer.toHexString(Dhigh); 
	        	D1 +=  Integer.toHexString(Dlow);
	        	}
	        	
	        	int Dtmp = toSignedByte(Integer.parseInt(D1, 16),2);
	        	D = toSignedByte(D,2);
	        	D = (D - Dtmp) & 0xFFFF;
	        	entry2 = Dtmp;
	        	entry1Bin16 = DecimalToTwosComplement16(entry1);
	            entry2Bin16 = DecimalToTwosComplement16(entry2);
	        	res = toSignedByte(D , 2);
	        	
	        	if(B<16) {
	        		D2 = Integer.toHexString(A);
	        		D2 += "0";
		        	D2 +=  Integer.toHexString(B);
	        	}
	        	else {
	        	D2 = Integer.toHexString(A); 
	        	D2 +=  Integer.toHexString(B);
	        	}
	        	
	        	int D_AB = toSignedByte(Integer.parseInt(D2, 16),2);
	        	D_AB -=Dtmp & 0xFFFF;
	        	
	        	int D_ABhigh = (D_AB >> 8) & 0xFF;
	            int D_ABlow  = D_AB & 0xFF;
	            
	        	flags[6]=CheckCarry16(entry1Bin16,entry2Bin16);
	        	flags[2]=CheckHalfCarry16(entry1Bin16,entry2Bin16);
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	
	        	A=D_ABhigh & 0xFF;
	        	B=D_ABlow & 0xFF;
	        	
	        	Valram.add(valram.clone());
	            valeursA.add(toSignedByte(A , 1));
	            valeursB.add(toSignedByte(B , 1));
	            valeursDP.add(toSignedByte(DP , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	            D=D_AB;
	        }
	        else if (P1[k].equalsIgnoreCase("ORA")) {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = A;
	        	entry1Bin8 = DecimalToTwosComplement8(entry1);
	        	entry2 = toSignedByte( ValueROM[Temp - 1] , 1);
	        	entry2Bin8 = DecimalToTwosComplement8(entry2);
	            
	        	int tempOR[] = new int [8];
	        	 tempOR = OR_8bits(entry1Bin8 , entry2Bin8);
	        	 A = toSignedByte(Binary8_ToInt(tempOR), 1);
	        	 res = A;
//	        	 	flags[0]=CheckCarry8(entry1Bin8,entry2Bin8);
//		            flags[1]=CheckOverFlow(entry1,entry2,res);
		        	flags[5]=CheckZero(res);
		        	flags[4]=CheckSigne(res);
		            flags[0]=CheckParity(res);
//		        	flags[5]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
	        }
	        	else if (P1[k].equalsIgnoreCase("ORB")) {
	        		
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = B;
	        	entry1Bin8 = DecimalToTwosComplement8(entry1);
	        	entry2 = toSignedByte( ValueROM[Temp - 1] , 1);
	        	entry2Bin8 = DecimalToTwosComplement8(entry2);
	            
	        	int tempOR[] = new int [8];
	        	 tempOR = OR_8bits(entry1Bin8 , entry2Bin8);
	        	 B = toSignedByte(Binary8_ToInt(tempOR), 1);
	        	 res = B;
	        	 
//	        	 	flags[0]=CheckCarry8(entry1Bin8,entry2Bin8);
//		            flags[1]=CheckOverFlow(entry1,entry2,res);
		        	flags[5]=CheckZero(res);
		        	flags[4]=CheckSigne(res);
		            flags[0]=CheckParity(res);
//		        	flags[5]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
	        }
	        		else if (P1[k].equalsIgnoreCase("ANDA")) {
	        		
		        	
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = A;
		        	entry1Bin8 = DecimalToTwosComplement8(entry1);
		        	entry2 = toSignedByte( ValueROM[Temp - 1] , 1);
		        	entry2Bin8 = DecimalToTwosComplement8(entry2);
		            
		        	int tempAND[] = new int [8];
		        	tempAND = AND_8bits(entry1Bin8 , entry2Bin8);
		        	 A = toSignedByte(Binary8_ToInt(tempAND), 1);
		        	 
			        	res = A;
		        	 
			        	flags[6]=CheckCarry16(entry1Bin16,entry2Bin16);
			        	flags[2]=CheckHalfCarry16(entry1Bin16,entry2Bin16);
			        	flags[0]=CheckParity(res);
			        	flags[4]=CheckSigne(res);
			        	flags[5]=CheckZero(res);
			        	flags[7]=CheckOverFlow(entry1,entry2,res);
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
		        }
	        	else if (P1[k].equalsIgnoreCase("ANDB")) {
	        		
		        	
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = B;
		        	entry1Bin8 = DecimalToTwosComplement8(entry1);
		        	entry2 = toSignedByte( ValueROM[Temp - 1] , 1);
		        	entry2Bin8 = DecimalToTwosComplement8(entry2);
		            
		        	int tempAND[] = new int [8];
		        	tempAND = AND_8bits(entry1Bin8 , entry2Bin8);
		        	 B = toSignedByte(Binary8_ToInt(tempAND), 1);
		        	 
			        	res = B;
		        	 
			        	flags[6]=CheckCarry16(entry1Bin16,entry2Bin16);
			        	flags[2]=CheckHalfCarry16(entry1Bin16,entry2Bin16);
			        	flags[0]=CheckParity(res);
			        	flags[4]=CheckSigne(res);
			        	flags[5]=CheckZero(res);
			        	flags[7]=CheckOverFlow(entry1,entry2,res);
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
		        }
	    	
	        	else if (P1[k].equalsIgnoreCase("CMPA")) {
	        		
		        	
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = A;
		        	entry2 = ValueROM[Temp - 1];
		        	res = entry2 - entry1;
		        		        	 
		        	flags[6]=CheckCarry16(entry1Bin16,entry2Bin16);
		        	flags[2]=CheckHalfCarry16(entry1Bin16,entry2Bin16);
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=CheckOverFlow(entry1,entry2,res);
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
		        }
	    	
	        	else if (P1[k].equalsIgnoreCase("CMPB")) {
	        		
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = B;
		        	entry2 = ValueROM[Temp - 1];
		        	
		        	res = entry2 - entry1;
		        	
		        	
		        	flags[6]=CheckCarry16(entry1Bin16,entry2Bin16);
		        	flags[2]=CheckHalfCarry16(entry1Bin16,entry2Bin16);
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=CheckOverFlow(entry1,entry2,res);
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
		        }
	        	else if (P1[k].equalsIgnoreCase("CMPS"))
		        {
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = S;
		        	Shigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
		        	Slow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
		        	
		        	String S1 = "";
		        	
		        	if(Slow<16) {
		        		S1 = Integer.toHexString(Shigh);
		        		S1 += "0";
			        	S1 +=  Integer.toHexString(Slow);
		        	}
		        	else {
		        	S1 = Integer.toHexString(Shigh); 
		        	S1 +=  Integer.toHexString(Slow);
		        	}
		        	
		        	entry2 = Integer.parseInt(S1, 16) & 0xFFFF;
		        	res = entry2 - entry1;
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
//		        	flags[7]=CheckOverFlow(entry1,entry2,res);
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
	        	else if (P1[k].equalsIgnoreCase("CMPY"))
		        {
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = Y;
		        	Yhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
		        	Ylow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
		        	
		        	String Y1 = "";
		        	
		        	if(Ylow<16) {
		        		Y1 = Integer.toHexString(Yhigh);
		        		Y1 += "0";
			        	Y1 +=  Integer.toHexString(Ylow);
		        	}
		        	else {
		        	Y1 = Integer.toHexString(Yhigh); 
		        	Y1 +=  Integer.toHexString(Ylow);
		        	}
		        	
		        	entry2 = Integer.parseInt(Y1, 16) & 0xFFFF;
		        	res = entry2 - entry1;
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
//		        	flags[7]=CheckOverFlow(entry1,entry2,res);
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));	
		        }
		        else if (P1[k].equalsIgnoreCase("CMPX"))
		        {
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = X;
		        	Xhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
		        	Xlow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
		        	
		        	String X1 = "";
		        	
		        	if(Xlow<16) {
		        		X1 = Integer.toHexString(Xhigh);
		        		X1 += "0";
			        	X1 +=  Integer.toHexString(Xlow);
		        	}
		        	else {
		        	X1 = Integer.toHexString(Xhigh); 
		        	X1 +=  Integer.toHexString(Xlow);
		        	}
		        	
		        	entry2 = Integer.parseInt(X1, 16) & 0xFFFF;
		        	res = entry2 - entry1;
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
//		        	flags[7]=CheckOverFlow(entry1,entry2,res);
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (P1[k].equalsIgnoreCase("CMPU"))
		        {
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = U;
		        	Uhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
		        	Ulow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
		        	
		        	String U1 = "";
		        	
		        	if(Ulow<16) {
		        		U1 = Integer.toHexString(Uhigh);
		        		U1 += "0";
			        	U1 +=  Integer.toHexString(Ulow);
		        	}
		        	else {
		        	U1 = Integer.toHexString(Uhigh); 
		        	U1 +=  Integer.toHexString(Ulow);
		        	}
		        	
		        	entry2 = Integer.parseInt(U1, 16) & 0xFFFF;
		        	res = entry2 - entry1;
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
//		        	flags[7]=CheckOverFlow(entry1,entry2,res);
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (P1[k].equalsIgnoreCase("CMPD"))
		        {
		        	entry1 = 0; entry2 = 0; res = 0;
		        	entry1 = toSignedByte(D,2);
		        	Dhigh= toSignedByte(ValueROM[Temp - 2] , 1) & 0xFF;
		        	Dlow = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
		        	
		        	String D1 = "";
		        	String D2 = "";
		        	
		        	if(Dlow<16) {
		        		D1 = Integer.toHexString(Dhigh);
		        		D1 += "0";
			        	D1 +=  Integer.toHexString(Dlow);
		        	}
		        	else {
		        	D1 = Integer.toHexString(Dhigh); 
		        	D1 +=  Integer.toHexString(Dlow);
		        	}
		        	
		        	entry2 = Integer.parseInt(D1);
		        	res = entry2 - entry1;
		            
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
//		        	flags[7]=CheckOverFlow(entry1,entry2,res);
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1));
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		            
		            if(B<16) {
		        		D2 = Integer.toHexString(A);
		        		D2 += "0";
			        	D2 +=  Integer.toHexString(B);
		        	}
		        	else {
		        	D2 = Integer.toHexString(A); 
		        	D2 +=  Integer.toHexString(B);
		        	}
		        	
		        	int D_AB = toSignedByte(Integer.parseInt(D2, 16),2);
		        	D=D_AB;
		        }
		        else if (P1[k].equalsIgnoreCase("PSHS")) {
	        		entry1 = ValueROM[Temp - 1];
	        		entry1Bin8 = DecimalToTwosComplement8(entry1);
	        		
		        		if(entry1Bin8[7]==1)
		        		{
		        			 S = S - 1;
		        			 entry1 = (PC[k+1] >> 8) & 0xFF;
		        			 valram[S] =  entry1;
		        			 S = S - 1;
		        			 entry2 = PC[k+1] & 0xFF;
		        			 valram[S] =  entry2;
		        		}
		        		
		        		if(entry1Bin8[6]==1)
		        		{
		        			 S = S - 1;
		        			 valram[S] =  Uhigh;
		        			 S = S - 1;
		        			 valram[S] =  Ulow;
		        		}
		        		if(entry1Bin8[5]==1)
		        		{
		        			 S = S - 1;
		        			 valram[S] =  Yhigh;
		        			 S = S - 1;
		        			 valram[S] =  Ylow;
		        		}
		        		if(entry1Bin8[4]==1)
		        		{
		        			 S = S - 1;
		        			 valram[S] =  Xhigh;
		        			 S = S - 1;
		        			 valram[S] =  Xlow;
		        		}
		        		if(entry1Bin8[3]==1)
		        		{
		        			S = S - 1;
		        			valram[S] = 0x00;
		        		}
		        		if(entry1Bin8[2]==1)
		        		{
		        			 S = S - 1;
		        			valram[S] = A;
		        		}
		        		if(entry1Bin8[1]==1)
		        		{
		        			 S = S - 1;
		        			valram[S] = B;
		        		}
		        		if(entry1Bin8[0]==1)
		        		{
		        			 S = S - 1;
		        			valram[S] = SignedBinaryToInteger(flags);
		        		}
	        		
	        		CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
	        		
	        	}
		        else if (P1[k].equalsIgnoreCase("PSHU")) {
		    		entry1 = ValueROM[Temp - 1];
		    		entry1Bin8 = DecimalToTwosComplement8(entry1);
		    		
		        		if(entry1Bin8[7]==1)
		        		{
		        			 U = U - 1;
		        			 entry1 = (PC[k+1] >> 8) & 0xFF;
		        			 valram[U] =  entry1;
		        			 U = U - 1;
		        			 entry2 = PC[k+1] & 0xFF;
		        			 valram[U] =  entry2;
		        		}
		        		
		        		if(entry1Bin8[6]==1)
		        		{
		        			 U = U - 1;
		        			 valram[U] =  Uhigh;
		        			 U = U - 1;
		        			 valram[U] =  Ulow;
		        		}
		        		if(entry1Bin8[5]==1)
		        		{
		        			 U = U - 1;
		        			 valram[U] =  Yhigh;
		        			 U = U - 1;
		        			 valram[U] =  Ylow;
		        		}
		        		if(entry1Bin8[4]==1)
		        		{
		        			 U = U - 1;
		        			 valram[U] =  Xhigh;
		        			 U = U - 1;
		        			 valram[U] =  Xlow;
		        		}
		        		if(entry1Bin8[3]==1)
		        		{
		        			U = U - 1;
		        			valram[U] = 0x00;
		        		}
		        		if(entry1Bin8[2]==1)
		        		{
		        			 U = U - 1;
		        			valram[U] = A;
		        		}
		        		if(entry1Bin8[1]==1)
		        		{
		        			 U = U - 1;
		        			valram[U] = B;
		        		}
		        		if(entry1Bin8[0]==1)
		        		{
		        			 U = U - 1;
		        			valram[U] = SignedBinaryToInteger(flags);
		        		}
		    		
		    		CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		    		
		    	}
		        else {};
	    	}
		        if (OTH_INS.equalsIgnoreCase("TFRA,B"))
		        {
		        	B = A;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRB,A"))
		        {
		        	A = B;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRS,U"))
		        {
		        	U = S;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRS,X"))
		        {
		        	X = S;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRS,Y"))
		        {
		        	Y = S;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRS,D"))
		        {
		        	D = S;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRU,S"))
		        {
		        	S = U;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRU,X"))
		        {
		        	X = U;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRU,Y"))
		        {
		        	Y = U;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRU,D"))
		        {
		        	D = U;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRX,S"))
		        {
		        	S = X;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRX,U"))
		        {
		        	S = X;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRX,Y"))
		        {
		        	Y = X;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRX,D"))
		        {
		        	D = X;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRY,S"))
		        {
		        	S = Y;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRY,U"))
		        {
		        	U = Y;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRY,X"))
		        {
		        	X = Y;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRY,D"))
		        {
		        	D = Y;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRD,S"))
		        {
		        	S = D;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRD,U"))
		        {
		        	U = D;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRD,X"))
		        {
		        	X = D;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("TFRD,Y"))
		        {
		        	Y = D;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
	        
	        	//EXG****************************************
	        
		        else if (OTH_INS.equalsIgnoreCase("EXGA,B"))
		        {
		        	int tmp = A; A = B; B = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGB,A"))
		        {
		        	int tmp = A; A = B; B = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGS,U"))
		        {
		        	int tmp = S; S = U; U = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGS,X"))
		        {
		        	int tmp = S; S = X; X = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGS,Y"))
		        {
		        	int tmp = S; S = Y; Y = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGS,D"))
		        {
		        	int tmp = S; S = D; D = tmp;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGU,S"))
		        {
		        	int tmp = U; U = S; S = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGU,X"))
		        {
		        	int tmp = U; U = X; X = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGU,Y"))
		        {
		        	int tmp = U; U = Y; Y = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGU,D"))
		        {
		        	int tmp = U; U = D; D = tmp;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGX,S"))
		        {
		        	int tmp = X; X = S; S = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGX,U"))
		        {
		        	int tmp = X; X = U; U = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGX,Y"))
		        {
		        	int tmp = X; X = Y; Y = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGX,D"))
		        {
		        	int tmp = X; X = D; D = tmp;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGY,S"))
		        {
		        	int tmp = Y; Y = S; S = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGY,U"))
		        {
		        	int tmp = Y; Y = U; U = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGY,X"))
		        {
		        	int tmp = Y; Y = X; X = tmp;
		        	Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGY,D"))
		        {
		        	int tmp = Y; Y = D; D = tmp;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGD,S"))
		        {
		        	int tmp = D; D = S; S = tmp;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGD,U"))
		        {
		        	int tmp = D; D = U; U = tmp;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGD,X"))
		        {
		        	int tmp = D; D = X; X = tmp;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("EXGD,Y"))
		        {
		        	int tmp = D; D = Y; Y = tmp;
		        	int D_ABhigh = (D >> 8) & 0xFF;
		            int D_ABlow  = D & 0xFF;
		            A=D_ABhigh;  B=D_ABlow;
		            Valram.add(valram.clone());CCR.add(flags.clone());valeursA.add(toSignedByte(A , 1));valeursB.add(toSignedByte(B , 1));valeursDP.add(toSignedByte(DP , 1)); valeursS.add(toSignedByte(S , 2));valeursY.add(toSignedByte(Y , 2)); valeursX.add(toSignedByte(X , 2));valeursU.add(toSignedByte(U , 2));
		        }
		        
		 
		        
		        else if (OTH_INS.equalsIgnoreCase("ABX"))
		        {
		        	X = (X + B) & 0xFFFF;
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("CLRA"))
		        {
		        	A = 0x00;
		        	flags[0]=1;
		        	flags[5]=1;
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("CLRB"))
		        {
		        	B = 0x00;
		        	flags[0]=1;
		        	flags[5]=1;
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("DECA"))
		        {
		        	A--;
		        	flags[0]=CheckParity(A);
		        	flags[4]=CheckSigne(A);
		        	flags[5]=CheckZero(A);
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("DECB"))
		        {
		        	B--;
		        	flags[0]=CheckParity(B);
		        	flags[4]=CheckSigne(B);
		        	flags[5]=CheckZero(B);
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("INCA"))
		        {
		        	A++;
		        	flags[0]=CheckParity(A);
		        	flags[4]=CheckSigne(A);
		        	flags[5]=CheckZero(A);
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("INCB"))
		        {
		        	B++;
		        	flags[0]=CheckParity(B);
		        	flags[4]=CheckSigne(B);
		        	flags[5]=CheckZero(B);
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("NOP"))
		        {
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (OTH_INS.equalsIgnoreCase("MUL"))
		        {
		        	D = (A * B) & 0xFFFF;
		        	Dhigh = (D >> 8) & 0xFF;
		        	Dlow = D & 0xFF;
		        	flags[0]=CheckParity(D);
		        	flags[5]=CheckZero(D);
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(Dhigh , 1)); 
		            valeursB.add(toSignedByte(Dlow , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        
		        
		        if(P21[k]=='\0') {      
			        if (P1[k].equalsIgnoreCase("STA")) {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1,16);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}

		        	if (idxRAM != -1) {
		        		if(idxRAM<200)
			        		valram[idxRAM]=A;
			        		else {}
		        	}

		            res = toSignedByte(A , 1);
		            
		            flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
			        else if (P1[k].equalsIgnoreCase("STB")) {
			        	res = 0;
			        	AdHigh= toSignedByte(ValueROM[Temp - 2],1)  & 0xFF;
			        	AdLow = toSignedByte(ValueROM[Temp - 1],1)  & 0xFF;
			        	String Ad1 = "";
			        	if(AdLow<16) {
			        		Ad1 = Integer.toHexString(AdHigh);
			        		Ad1 += "0";
				        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	else {
			        	Ad1 = Integer.toHexString(AdHigh); 
			        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	
			        	Ad = Integer.parseInt(Ad1) & 0xFFFF;
			        	
			        	int idxRAM = -1;
			        	
			        	for (int i = 0; i < ADRAM.length; i++) {
			        		ADRAM[i]= toSignedByte(ADRAM[i],1) ;
			        	    if (ADRAM[i] == Ad) {
			        	        idxRAM = i;
			        	        break;
			        	    }
			        	}

			        	if (idxRAM != -1) {
			        		if(idxRAM<200)
				        		valram[idxRAM]=B;
				        		else {}
			        	}

			            res = toSignedByte(B , 1);
			            
			            flags[0]=CheckParity(res);
			        	flags[4]=CheckSigne(res);
			        	flags[5]=CheckZero(res);
			        	flags[7]=0;
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
			        }
			        
			        else if (P1[k].equalsIgnoreCase("STD")) {
			        	res = 0;
			        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
			        	AdLow = ValueROM[Temp - 1]  & 0xFF;
			        	String Ad1 = "";
			        	if(AdLow<16) {
			        		Ad1 = Integer.toHexString(AdHigh);
			        		Ad1 += "0";
				        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	else {
			        	Ad1 = Integer.toHexString(AdHigh); 
			        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	
			        	Ad = Integer.parseInt(Ad1 , 16) & 0xFFFF;
			        	
			        	int idxRAM = -1;

			        	for (int i = 0; i < ADRAM.length; i++) {
			        	    if (ADRAM[i] == Ad) {
			        	        idxRAM = i;
			        	        break;
			        	    }
			        	}

			        	if (idxRAM != -1) {
			        		if(idxRAM<200)
			        		valram[idxRAM]=A;
			        		else {}
			        		
			        		if((idxRAM+1)<200)
			        		valram[idxRAM+1]=B;
			        		else {}
			        	}

			            res = toSignedByte(D , 1);
			            
			            flags[0]=CheckParity(res);
			        	flags[4]=CheckSigne(res);
			        	flags[5]=CheckZero(res);
			        	flags[7]=0;
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
			        }
			        else if (P1[k].equalsIgnoreCase("STS")) {
			        	res = 0;
			        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
			        	AdLow = ValueROM[Temp - 1]  & 0xFF;
			        	String Ad1 = "";
			        	if(AdLow<16) {
			        		Ad1 = Integer.toHexString(AdHigh);
			        		Ad1 += "0";
				        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	else {
			        	Ad1 = Integer.toHexString(AdHigh); 
			        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	
			        	Ad = Integer.parseInt(Ad1 , 16) & 0xFFFF;
			        	
			        	int idxRAM = -1;

			        	for (int i = 0; i < ADRAM.length; i++) {
			        	    if (ADRAM[i] == Ad) {
			        	        idxRAM = i;
			        	        break;
			        	    }
			        	}
			        	Shigh = (S >> 8) & 0xFF;
			        	Slow  = S & 0xFF;

			        	if (idxRAM != -1) {
			        		if(idxRAM<200)
			        		valram[idxRAM]=Shigh;
			        		else {}
			        		
			        		if((idxRAM+1)<200)
			        		valram[idxRAM+1]=Slow;
			        		else {}
			        	}

			            res = toSignedByte(S , 1);
			            
			            flags[0]=CheckParity(res);
			        	flags[4]=CheckSigne(res);
			        	flags[5]=CheckZero(res);
			        	flags[7]=0;
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
			        }
			        else if (P1[k].equalsIgnoreCase("STU")) {
			        	res = 0;
			        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
			        	AdLow = ValueROM[Temp - 1]  & 0xFF;
			        	String Ad1 = "";
			        	if(AdLow<16) {
			        		Ad1 = Integer.toHexString(AdHigh);
			        		Ad1 += "0";
				        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	else {
			        	Ad1 = Integer.toHexString(AdHigh); 
			        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	
			        	Ad = Integer.parseInt(Ad1 , 16) & 0xFFFF;
			        	
			        	int idxRAM = -1;

			        	for (int i = 0; i < ADRAM.length; i++) {
			        	    if (ADRAM[i] == Ad) {
			        	        idxRAM = i;
			        	        break;
			        	    }
			        	}
			        	Uhigh = (U >> 8) & 0xFF;
			        	Ulow  = U & 0xFF;

			        	if (idxRAM != -1) {
			        		if(idxRAM<200)
			        		valram[idxRAM]=Uhigh;
			        		else {}
			        		
			        		if((idxRAM+1)<200)
			        		valram[idxRAM+1]=Ulow;
			        		else {}
			        	}

			            res = toSignedByte(U , 1);
			            
			            flags[0]=CheckParity(res);
			        	flags[4]=CheckSigne(res);
			        	flags[5]=CheckZero(res);
			        	flags[7]=0;
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
			        }
			        else if (P1[k].equalsIgnoreCase("STX")) {
			        	res = 0;
			        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
			        	AdLow = ValueROM[Temp - 1]  & 0xFF;
			        	String Ad1 = "";
			        	if(AdLow<16) {
			        		Ad1 = Integer.toHexString(AdHigh);
			        		Ad1 += "0";
				        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	else {
			        	Ad1 = Integer.toHexString(AdHigh); 
			        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	
			        	Ad = Integer.parseInt(Ad1 , 16) & 0xFFFF;
			        	
			        	int idxRAM = -1;

			        	for (int i = 0; i < ADRAM.length; i++) {
			        	    if (ADRAM[i] == Ad) {
			        	        idxRAM = i;
			        	        break;
			        	    }
			        	}
			        	Xhigh = (X >> 8) & 0xFF;
			        	Xlow  = X & 0xFF;

			        	if (idxRAM != -1) {
			        		if(idxRAM<200)
			        		valram[idxRAM]=Xhigh;
			        		else {}
			        		
			        		if((idxRAM+1)<200)
			        		valram[idxRAM+1]=Xlow;
			        		else {}
			        	}

			            res = toSignedByte(X , 1);
			            
			            flags[0]=CheckParity(res);
			        	flags[4]=CheckSigne(res);
			        	flags[5]=CheckZero(res);
			        	flags[7]=0;
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
			        }
			        else if (P1[k].equalsIgnoreCase("STY")) {
			        	res = 0;
			        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
			        	AdLow = ValueROM[Temp - 1]  & 0xFF;
			        	String Ad1 = "";
			        	if(AdLow<16) {
			        		Ad1 = Integer.toHexString(AdHigh);
			        		Ad1 += "0";
				        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	else {
			        	Ad1 = Integer.toHexString(AdHigh); 
			        	Ad1 +=  Integer.toHexString(AdLow);
			        	}
			        	
			        	Ad = Integer.parseInt(Ad1 , 16) & 0xFFFF;
			        	
			        	int idxRAM = -1;

			        	for (int i = 0; i < ADRAM.length; i++) {
			        	    if (ADRAM[i] == Ad) {
			        	        idxRAM = i;
			        	        break;
			        	    }
			        	}
			        	Yhigh = (Y >> 8) & 0xFF;
			        	Ylow  = Y & 0xFF;

			        	if (idxRAM != -1) {
			        		if(idxRAM<200)
			        		valram[idxRAM]=Yhigh;
			        		else {}
			        		
			        		if((idxRAM+1)<200)
			        		valram[idxRAM+1]=Ylow;
			        		else {}
			        	}

			            res = toSignedByte(Y , 1);
			            
			            flags[0]=CheckParity(res);
			        	flags[4]=CheckSigne(res);
			        	flags[5]=CheckZero(res);
			        	flags[7]=0;
			        	
			        	CCR.add(flags.clone());
			        	Valram.add(valram.clone());
			            valeursA.add(toSignedByte(A , 1)); 
			            valeursB.add(toSignedByte(B , 1));
			            valeursDP.add(toSignedByte(DP , 1));
			            valeursS.add(toSignedByte(S , 2));
			            valeursY.add(toSignedByte(Y , 2));
			            valeursX.add(toSignedByte(X , 2));
			            valeursU.add(toSignedByte(U , 2));
			        }
		        else if (P1[k].equalsIgnoreCase("LDA"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}

		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		A=valram[idxRAM] & 0xFF;
			        		else {}
		        	}

		            res = toSignedByte(A , 1);
		            
		            flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));

		        }
		        else if (P1[k].equalsIgnoreCase("LDB"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}

		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		B=valram[idxRAM] & 0xFF;
			        		else {}
		        	}

		            res = toSignedByte(B , 1);
		            
		            flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));

		        }
		        else if (P1[k].equalsIgnoreCase("LDS"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}
		        	
		        	String S1 = "";
		        	
		        	
		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		Shigh=valram[idxRAM] & 0xFF;
			        		else {}
		        		if(idxRAM+1<1280)
			        		Slow=valram[idxRAM+1] & 0xFF;
			        		else {}
		        	}
		        	
		        	if(Slow<16) {
		        		S1 = Integer.toHexString(Shigh);
		        		S1 += "0";
			        	S1 +=  Integer.toHexString(Slow);
		        	}
		        	else {
		        	S1 = Integer.toHexString(Shigh); 
		        	S1 +=  Integer.toHexString(Slow);
		        	}
		        	
		        	S = Integer.parseInt(S1, 16) & 0xFFFF;
		        	
		        	res = toSignedByte(S , 2);
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));

		        }
		        else if (P1[k].equalsIgnoreCase("LDU"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}
		        	
		        	String U1 = "";
		        	
		        	
		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		Uhigh=valram[idxRAM] & 0xFF;
			        		else {}
		        		if(idxRAM+1<1280)
			        		Ulow=valram[idxRAM+1] & 0xFF;
			        		else {}
		        	}
		        	
		        	if(Ulow<16) {
		        		U1 = Integer.toHexString(Uhigh);
		        		U1 += "0";
			        	U1 +=  Integer.toHexString(Ulow);
		        	}
		        	else {
		        	U1 = Integer.toHexString(Uhigh); 
		        	U1 +=  Integer.toHexString(Ulow);
		        	}
		        	
		        	U = Integer.parseInt(U1, 16) & 0xFFFF;
		        	
		        	res = toSignedByte(U , 2);
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (P1[k].equalsIgnoreCase("LDX"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}
		        	
		        	String X1 = "";
		        	
		        	
		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		Xhigh=valram[idxRAM] & 0xFF;
			        		else {}
		        		if(idxRAM+1<1280)
			        		Xlow=valram[idxRAM+1] & 0xFF;
			        		else {}
		        	}
		        	
		        	if(Xlow<16) {
		        		X1 = Integer.toHexString(Xhigh);
		        		X1 += "0";
			        	X1 +=  Integer.toHexString(Xlow);
		        	}
		        	else {
		        	X1 = Integer.toHexString(Xhigh); 
		        	X1 +=  Integer.toHexString(Xlow);
		        	}
		        	
		        	X = Integer.parseInt(X1, 16) & 0xFFFF;
		        	
		        	res = toSignedByte(X , 2);
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (P1[k].equalsIgnoreCase("LDY"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}
		        	
		        	String Y1 = "";
		        	
		        	
		        	if (idxRAM != -1) {
		        		if(idxRAM+1<1280)
			        		Yhigh=valram[idxRAM] & 0xFF;
			        		else {}
		        		if(idxRAM+1<1280)
			        		Ylow=valram[idxRAM+1] & 0xFF;
			        		else {}
		        	}
		        	
		        	if(Ylow<16) {
		        		Y1 = Integer.toHexString(Yhigh);
		        		Y1 += "0";
			        	Y1 +=  Integer.toHexString(Ylow);
		        	}
		        	else {
		        	Y1 = Integer.toHexString(Yhigh); 
		        	Y1 +=  Integer.toHexString(Ylow);
		        	}
		        	
		        	Y = Integer.parseInt(Y1, 16) & 0xFFFF;
		        	
		        	res = toSignedByte(Y , 2);
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));

		        }
		        else if (P1[k].equalsIgnoreCase("LDD"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}
		        	
		        	String D1 = "";
		        	
		        	
		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		Dhigh=valram[idxRAM] & 0xFF;
			        		else {}
		        		if(idxRAM+1 < 1280)
			        		Dlow=valram[idxRAM+1] & 0xFF;
			        		else {}
		        	}
		        	
		        	if(Dlow<16) {
		        		D1 = Integer.toHexString(Dhigh);
		        		D1 += "0";
			        	D1 +=  Integer.toHexString(Dlow);
		        	}
		        	else {
		        	D1 = Integer.toHexString(Dhigh); 
		        	D1 +=  Integer.toHexString(Dlow);
		        	}
		        	
		        	D = Integer.parseInt(D1, 16) & 0xFFFF;
		        	
		        	res = toSignedByte(D , 2);
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(Dhigh , 1)); 
		            valeursB.add(toSignedByte(Dlow , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else if (P1[k].equalsIgnoreCase("ADDA"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}

		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		A= (A + valram[idxRAM]) & 0xFF;
			        		else {}
		        	}

		            res = toSignedByte(A , 1);
		            
		            flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));

		        }
		        else if (P1[k].equalsIgnoreCase("ADDB"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}

		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		B= (B + valram[idxRAM]) & 0xFF;
			        		else {}
		        	}

		            res = toSignedByte(B , 1);
		            
		            flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));

		        }
		        else if (P1[k].equalsIgnoreCase("ADDD"))
		        {
		        	res = 0;
		        	AdHigh= ValueROM[Temp - 2]  & 0xFF;
		        	AdLow = ValueROM[Temp - 1]  & 0xFF;
		        	String Ad1 = "";
		        	if(AdLow<16) {
		        		Ad1 = Integer.toHexString(AdHigh);
		        		Ad1 += "0";
			        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	else {
		        	Ad1 = Integer.toHexString(AdHigh); 
		        	Ad1 +=  Integer.toHexString(AdLow);
		        	}
		        	
		        	Ad = Integer.parseInt(Ad1);
		        	
		        	int idxRAM = -1;

		        	for (int i = 0; i < ADRAM.length; i++) {
		        	    if (ADRAM[i] == Ad) {
		        	        idxRAM = i;
		        	        break;
		        	    }
		        	}
		        	
		        	String D1 = "";
		        	String D2 = "";
		        	if(B<16) {
		        		D1 = Integer.toHexString(A);
		        		D1 += "0";
			        	D1 +=  Integer.toHexString(B);
		        	}
		        	else {
		        	D1 = Integer.toHexString(A); 
		        	D1 +=  Integer.toHexString(B);
		        	}
		        	
		        	int D11 = Integer.parseInt(D1, 16) & 0xFFFF;
		        	
		        	if (idxRAM != -1) {
		        		if(idxRAM<1280)
			        		Dhigh=valram[idxRAM] & 0xFF;
			        		else {}
		        		if(idxRAM+1 < 1280)
			        		Dlow=valram[idxRAM+1] & 0xFF;
			        		else {}
		        	}
		        	
		        	if(Dlow<16) {
		        		D2 = Integer.toHexString(Dhigh);
		        		D2 += "0";
			        	D2 +=  Integer.toHexString(Dlow);
		        	}
		        	else {
		        	D2 = Integer.toHexString(Dhigh); 
		        	D2 +=  Integer.toHexString(Dlow);
		        	}
		        	
		        	int D22 = Integer.parseInt(D2, 16) & 0xFFFF;
		        	
		        	D = (D11 + D22) & 0xFFFF;
		        	
		        	Dhigh = (D >> 8) & 0xFF;
		        	Dlow = D & 0xFF;
		        	
		        	res = toSignedByte(D , 2);
		        	
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=0;
		        	
		        	CCR.add(flags.clone());
		        	Valram.add(valram.clone());
		            valeursA.add(toSignedByte(Dhigh , 1)); 
		            valeursB.add(toSignedByte(Dlow , 1));
		            valeursDP.add(toSignedByte(DP , 1));
		            valeursS.add(toSignedByte(S , 2));
		            valeursY.add(toSignedByte(Y , 2));
		            valeursX.add(toSignedByte(X , 2));
		            valeursU.add(toSignedByte(U , 2));
		        }
		        else
		        {}
		    }
		        else if(P21[k]=='<')
		 	   {
		 		   
		 		   
		 			   int Addhaut;
		 			   int AddBas;
		 			   int ADD;
		 			   
		 			   // on est dans le mode directe : 
		 			   
		 			   if(P1[k].equalsIgnoreCase("LDA"))
		 			   {
		 				   
		 				    entry1 = 0; entry2 = 0; res = 0;
		 		        	entry1 = 0;
		 		        	
		 		        	Addhaut= DP;
		 		        	AddBas = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
		 		        	
		 		        	
		 		        	
		 			String DirectADD = "";		
		 			
		 		        	if(AddBas<16) {
		 		        		DirectADD = Integer.toHexString(Addhaut);
		 		        		DirectADD += "0";
		 		        		DirectADD +=  Integer.toHexString(AddBas);
		 		        	}
		 		        	
		 		        	else {
		 		        		DirectADD = Integer.toHexString(Addhaut); 
		 		        		DirectADD +=  Integer.toHexString(AddBas);
		 		        	}
		 		        	
		 		        	ADD = Integer.parseInt( DirectADD , 16) & 0xFFFF;
		 		        	A = toSignedByte(valram[ADD] , 2);
		 		        	res = A;		        	
		 		        	
		 		        	flags[5]=CheckZero(res);
		 		        	flags[4]=CheckSigne(res);
		 		            flags[0]=CheckParity(res);
		 		        	
		 		        	CCR.add(flags.clone());
		 		        	Valram.add(valram.clone());
		 		            valeursA.add(toSignedByte(A , 1)); 
		 		            valeursB.add(toSignedByte(B , 1));
		 		            valeursS.add(toSignedByte(S , 2));
		 		            valeursY.add(toSignedByte(Y , 2));
		 		            valeursX.add(toSignedByte(X , 2));
		 		            valeursU.add(toSignedByte(U , 2));
		 				    valeursDP.add(toSignedByte(DP,1));
		 				    
		 			   }
		 			   if(P1[k].equalsIgnoreCase("LDB"))
		 			   {
		 				   
		 				    entry1 = 0; entry2 = 0; res = 0;
		 		        	entry1 = 0;
		 		        	
		 		        	Addhaut= DP;
		 		        	AddBas = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
		 		        	
		 		        	
		 		        	
		 			String DirectADD = "";		
		 			
		 		        	if(AddBas<16) {
		 		        		DirectADD = Integer.toHexString(Addhaut);
		 		        		DirectADD += "0";
		 		        		DirectADD +=  Integer.toHexString(AddBas);
		 		        	}
		 		        	
		 		        	else {
		 		        		DirectADD = Integer.toHexString(Addhaut); 
		 		        		DirectADD +=  Integer.toHexString(AddBas);
		 		        	}
		 		        	
		 		        	ADD = Integer.parseInt( DirectADD , 16) & 0xFFFF;
		 		        	B = toSignedByte(valram[ADD] , 2);
		 		        	res = B;		        	
		 		        	
		 		        	flags[5]=CheckZero(res);
		 		        	flags[4]=CheckSigne(res);
		 		            flags[0]=CheckParity(res);
		 		        	
		 		        	CCR.add(flags.clone());
		 		        	Valram.add(valram.clone());
		 		            valeursA.add(toSignedByte(A , 1)); 
		 		            valeursB.add(toSignedByte(B , 1));
		 		            valeursS.add(toSignedByte(S , 2));
		 		            valeursY.add(toSignedByte(Y , 2));
		 		            valeursX.add(toSignedByte(X , 2));
		 		            valeursU.add(toSignedByte(U , 2));
		 				    valeursDP.add(toSignedByte(DP,1));

		 				   
		 			   }
		 			  if(P1[k].equalsIgnoreCase("LDD"))
					   {
						   
						    entry1 = 0; entry2 = 0; res = 0;
				        	entry1 = 0;
				        	
				        	Addhaut= DP;
				        	AddBas = toSignedByte(ValueROM[Temp - 1] , 1) & 0xFF;
				        	
				        	
				        	
					String DirectADD = "";		
					
				        	if(AddBas<16) {
				        		DirectADD = Integer.toHexString(Addhaut);
				        		DirectADD += "0";
				        		DirectADD +=  Integer.toHexString(AddBas);
				        	}
				        	
				        	else {
				        		DirectADD = Integer.toHexString(Addhaut); 
				        		DirectADD +=  Integer.toHexString(AddBas);
				        	}
				        	
				        	ADD = Integer.parseInt( DirectADD , 16) & 0xFFFF;
				        	A = toSignedByte(valram[ADD] , 1);
				        	B = toSignedByte(valram[ADD + 1] , 1);
				        	
				       String D2 = "";
				            if(B<16) {
				        		D2 = Integer.toHexString(A);
				        		D2 += "0";
					        	D2 +=  Integer.toHexString(B);
				        	}
				        	else {
				        	D2 = Integer.toHexString(A); 
				        	D2 +=  Integer.toHexString(B);
				        	}
				        	
				        	int D_AB = toSignedByte(Integer.parseInt(D2, 16),2);
				        	D=D_AB;
				        	flags[5]=CheckZero(D);
		 		        	flags[4]=CheckSigne(D);
		 		            flags[0]=CheckParity(D);
				        	
				        	
				        	CCR.add(flags.clone());
				            valeursA.add(toSignedByte(A , 1)); 
				            valeursB.add(toSignedByte(B , 1));
				            valeursS.add(toSignedByte(S , 2));
				            valeursY.add(toSignedByte(Y , 2));
				            valeursX.add(toSignedByte(X , 2));
				            valeursU.add(toSignedByte(U , 2));
						    valeursDP.add(toSignedByte(DP,1));

				        }
		 		   }
	        
	        else {}
	        k++;
	    }

	    CalculMembers VALEURS = new CalculMembers(valeursA, valeursB ,valeursS , valeursY ,valeursX, valeursU, valeursDP, CCR, Valram);
	    
	   return VALEURS;
	}
}





