package programMethodes;

public class Decodage {

	public int hexToSignedInt(String hexString) {
		
	   
	    int val = Integer.parseInt(hexString, 16);
	    
	    byte octetSigne = (byte) val;
	    
	    return octetSigne;
	    
	}
	
	public int HexaStringToInt(String A) {
		if (A == null) throw new NumberFormatException("null string");

	    A = A.trim();

	    return Integer.parseInt(A, 16);
	}
	
	public String toOpCodeImmediat(String P1)
	{
		String X="";
		if(!P1.equals(null)) {
		// pour LD : 
		if(P1.equalsIgnoreCase("LDA"))
			X = "86";
		else if(P1.equalsIgnoreCase("LDB"))
			X = "C6";
		else if(P1.equalsIgnoreCase("LDD"))
			X = "CC";
		else if(P1.equalsIgnoreCase("LDS"))
			X = "10CE";
		else if(P1.equalsIgnoreCase("LDU"))
			X = "CE";
		else if(P1.equalsIgnoreCase("LDX"))
			X = "8E";
		else if(P1.equalsIgnoreCase("LDY"))
			X = "108E";
		// pour ADD : 
		else if(P1.equalsIgnoreCase("ADDA"))
			X = "8B";
		else if(P1.equalsIgnoreCase("ADDB"))
			X = "CB";
		else if(P1.equalsIgnoreCase("ADDD"))
			X = "C3";
		
		}
		return X;
	}
}




