package programMethodes;

import java.util.ArrayList;

public class UAL {
	Decodage UAL_DEC = new Decodage();
	// --- Binary (display only) ---
	public int[] IntToBinary8SUB(int d) {
	    int[] b = new int[8];
	    int v = d & 0xFF;
	    for (int i = 0; i < 8; i++) {
	        b[i] = (v >> i) & 1;
	    }
	    return b;
	}

	public int[] IntToBinary16SUB(int d) {
	    int[] b = new int[16];
	    int v = d & 0xFFFF;
	    for (int i = 0; i < 16; i++) {
	        b[i] = (v >> i) & 1;
	    }
	    return b;
	}

	// --- Carry → interpreted as SUB C flag (1 = no borrow, 0 = borrow) ---
	public int CheckCarry8SUB(int[] A, int[] B) {
	    int ua = 0, ub = 0;
	    for (int i = 0; i < 8; i++) {
	        ua |= (A[i] & 1) << i;
	        ub |= (B[i] & 1) << i;
	    }
	    return (ua < ub) ? 0 : 1;
	}

	public int CheckCarry16SUB(int[] A, int[] B) {
	    int ua = 0, ub = 0;
	    for (int i = 0; i < 16; i++) {
	        ua |= (A[i] & 1) << i;
	        ub |= (B[i] & 1) << i;
	    }
	    return (ua < ub) ? 0 : 1;
	}

	// --- Half-carry → interpreted as HALF-BORROW ---
	public int CheckHalfCarry8SUB(int[] A, int[] B) {
	    int la = 0, lb = 0;
	    for (int i = 0; i < 4; i++) {
	        la |= (A[i] & 1) << i;
	        lb |= (B[i] & 1) << i;
	    }
	    return (la < lb) ? 1 : 0;
	}

	public int CheckHalfCarry16SUB(int[] A, int[] B) {
	    int la = 0, lb = 0;
	    for (int i = 0; i < 8; i++) {
	        la |= (A[i] & 1) << i;
	        lb |= (B[i] & 1) << i;
	    }
	    return (la < lb) ? 1 : 0;
	}

	// --- Sign ---
	public int CheckSigneSUB(int Result) {
	    return (Result < 0) ? 1 : 0;
	}

	// --- Zero ---
	public int CheckZeroSUB(int Result) {
	    return (Result == 0) ? 1 : 0;
	}

	// --- Parity (even result, same semantics as original) ---
	public int CheckParitySUB(int Result) {
	    return ((Result & 1) == 0) ? 1 : 0;
	}

	// --- Overflow (SUBTRACTION ONLY): A - B ---
	public int CheckOverFlowSUB(int entr1, int entr2, int Result) {
	    int s1 = (entr1 < 0) ? 1 : 0;
	    int s2 = (entr2 < 0) ? 1 : 0;
	    int sr = (Result < 0) ? 1 : 0;
	    return (s1 != s2 && sr != s1) ? 1 : 0;
	}
	
	
	//***************************************************************************************************
	//***************************************************************************************************
	//***************************************************************************************************
	//***************************************************************************************************

	
	public int[] IntToBinary8( int d )
	{
		int ToBinary[] = new int[8];
		if( d<0 )
			ToBinary[7] = 1;
		else 
			ToBinary[7] = 0;
		d = Math.abs(d);   // maintenant d est positif!
		
		int temp = 0;
		int counter = 0;
		
		while(d>1)
		{  
			temp = d%2;
			ToBinary[counter] = temp;
			d = d/2;
		   counter++;
		}
		ToBinary[counter] = 1;
		return ToBinary;
	}
	public int[] IntToBinary16( int d )
	{
		int ToBinary[] = new int[16];
		if( d<0 )
			ToBinary[15] = 1;
		else 
			ToBinary[15] = 0;
		d = Math.abs(d);   // maintenant d est positif!
		
		int temp = 0;
		int counter = 0;
		
		while(d>1)
		{  
			temp = d%2;
			ToBinary[counter] = temp;
			d = d/2;
		   counter++;
		}
		ToBinary[counter] = 1;
		return ToBinary;
	}
	
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
	
	public static class CalculMembers {
		public ArrayList<Integer> A;
		public ArrayList<Integer> B;
		public ArrayList<Integer> S;
		public ArrayList<Integer> U;
		public ArrayList<Integer> X;
		public ArrayList<Integer> Y;
		public ArrayList<Integer> D;
		public ArrayList<int[]> CCR;

		public CalculMembers (ArrayList<Integer> A, ArrayList<Integer> B ,ArrayList<Integer> S , ArrayList<Integer> Y
				,ArrayList<Integer> X, ArrayList<Integer> U, ArrayList<int[]> CCR) 
		     {this.A=A; this.B=B; this.S=S; this.Y=Y; this.X=X; this.U=U; this.CCR=CCR;}
	}
	
	  public int toSignedByte(int x, int nbOctet ) {
		 if(nbOctet == 1)
			 return (int) (byte) (x & 0xFF);
		 else 
			 return (int) (short) (x & 0xFFFF);  
		 
}


	public CalculMembers Calcule(String P1[], int ValueROM[] , int P1_NumberOctets[] , int P22_NumberOctets []) {
	    int A = 0x00;
	    int B = 0x00;
	    
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
	    
	    
	    ArrayList<Integer> valeursA = new ArrayList<>();
	    ArrayList<Integer> valeursB = new ArrayList<>();
	    ArrayList<Integer> valeursS = new ArrayList<>();
	    ArrayList<Integer> valeursY = new ArrayList<>();
	    ArrayList<Integer> valeursX = new ArrayList<>();
	    ArrayList<Integer> valeursU = new ArrayList<>();
	    ArrayList<int[]> CCR = new ArrayList<>();



	    int k = 0;
	    int l = 1;
	    int Temp = 0;
	    
	    int entry1 = 0; int entry2 = 0; int res = 0;
    	int entry1Bin8[] = new int [8];  int entry2Bin8[] = new int [8];
    	int entry1Bin16[] = new int [16];  int entry2Bin16[] = new int [16];
    	
    	int [] flags = new int [8];
    	flags[5]=1;
    	flags[0]=1;
    	
    	
    	CCR.add(flags.clone());
    	
	    while (k < P1.length      &&       P1[k] != null      &&      !P1[k].isEmpty()     &&     l<ValueROM.length) 
	    {
	    	Temp += P1_NumberOctets[k] + P22_NumberOctets[k];
	    	
	        if (P1[k].equalsIgnoreCase("LDA")) {
	        	entry1 = 0; entry2 = 0; res = 0;
	        	entry1 = A;
	            A = ValueROM[Temp - 1] & 0xFF;
	            entry2 = ValueROM[Temp - 1];
	            entry1Bin8 = IntToBinary8(entry1);
	            entry2Bin8 = IntToBinary8(entry2);
	            res = toSignedByte(A , 1);
	            
	        	//flags[6]=CheckCarry(entry1Bin,entry2Bin);
	        	//flags[2]=CheckHalfCarry(entry1Bin,entry2Bin);
	            flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
	        	entry1Bin8 = IntToBinary8(entry1);
	            entry2Bin8 = IntToBinary8(entry2);
	        	res = toSignedByte(A , 1);
	            
	        	flags[6]=CheckCarry8(entry1Bin8,entry2Bin8);
	        	flags[2]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
	        	entry1Bin8 = IntToBinary8(entry1);
	            entry2Bin8 = IntToBinary8(entry2);
	        	res = toSignedByte(B , 1);
	            
	        	//flags[6]=CheckCarry(entry1Bin,entry2Bin);
	        	//flags[2]=CheckHalfCarry(entry1Bin,entry2Bin);
	            flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
		        	entry1Bin8 = IntToBinary8(entry1);
		            entry2Bin8 = IntToBinary8(entry2);
		        	res = toSignedByte(B , 1);
		            
		        	flags[6]=CheckCarry8(entry1Bin8,entry2Bin8);
		        	flags[2]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
		        	flags[0]=CheckParity(res);
		        	flags[4]=CheckSigne(res);
		        	flags[5]=CheckZero(res);
		        	flags[7]=CheckOverFlow(entry1,entry2,res);
		        	
		        	CCR.add(flags.clone());
		            valeursA.add(toSignedByte(A , 1)); 
		            valeursB.add(toSignedByte(B , 1));
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
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
	        	entry1Bin16 = IntToBinary16(entry1);
	            entry2Bin16 = IntToBinary16(entry2);
	        	res = toSignedByte(D , 2);
	            
//	        	flags[6]=CheckCarry16(entry1Bin16,entry2Bin16);
//	        	flags[2]=CheckHalfCarry16(entry1Bin16,entry2Bin16);
	        	flags[0]=CheckParity(res);
	        	flags[4]=CheckSigne(res);
	        	flags[5]=CheckZero(res);
	        	flags[7]=CheckOverFlow(entry1,entry2,res);
	        	
	        	CCR.add(flags.clone());
	        	A=Dhigh & 0xFF;
	        	B=Dlow & 0xFF;
	            valeursA.add(toSignedByte(A , 1));
	            valeursB.add(toSignedByte(B , 1));
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
	        	entry1Bin16 = IntToBinary16(entry1);
	            entry2Bin16 = IntToBinary16(entry2);
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
	            valeursA.add(toSignedByte(A , 1));
	            valeursB.add(toSignedByte(B , 1));
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
	        	entry1Bin8 = IntToBinary8(entry1);
	            entry2Bin8 = IntToBinary8(entry2);
	        	res = toSignedByte(B , 1);
	            
	        	flags[0]=CheckCarry8(entry1Bin8,entry2Bin8);
	            flags[1]=CheckOverFlow(entry1,entry2,res);
	        	flags[2]=CheckZero(res);
	        	flags[3]=CheckSigne(res);
	            flags[4]=CheckParity(res);
	        	flags[5]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
	        	
	        	CCR.add(flags.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
	        	entry1Bin8 = IntToBinary8(entry1);
	            entry2Bin8 = IntToBinary8(entry2);
	        	res = toSignedByte(B , 1);
	            
	        	flags[0]=CheckCarry8(entry1Bin8,entry2Bin8);
	            flags[1]=CheckOverFlow(entry1,entry2,res);
	        	flags[2]=CheckZero(res);
	        	flags[3]=CheckSigne(res);
	            flags[4]=CheckParity(res);
	        	flags[5]=CheckHalfCarry8(entry1Bin8,entry2Bin8);
	        	
	        	CCR.add(flags.clone());
	            valeursA.add(toSignedByte(A , 1)); 
	            valeursB.add(toSignedByte(B , 1));
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
	        	entry1Bin16 = IntToBinary16(entry1);
	            entry2Bin16 = IntToBinary16(entry2);
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
	        	
	            valeursA.add(toSignedByte(A , 1));
	            valeursB.add(toSignedByte(B , 1));
	            valeursS.add(toSignedByte(S , 2));
	            valeursY.add(toSignedByte(Y , 2));
	            valeursX.add(toSignedByte(X , 2));
	            valeursU.add(toSignedByte(U , 2));
	            D=D_AB;
        }
	        else {}
	        k++;
	    }

	    CalculMembers VALEURS = new CalculMembers(valeursA, valeursB ,valeursS , valeursY ,valeursX, valeursU, CCR);
	    
	   return VALEURS;
	}
}





