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
	
	public String toOpCodeImmediat(String P1,String T)
	{
		String X="";
		String INSTRS = T;
    	INSTRS = INSTRS.replaceAll("\\s+", "");
    	String Etendu = T;
    	Etendu = Etendu.substring(0, 5);
		if(!P1.equals(null)) {
		// pour LD : 
		if(P1.equalsIgnoreCase("LDA") && !Etendu.equalsIgnoreCase("LDA $"))
			X = "86";
		else if(P1.equalsIgnoreCase("LDB") && !Etendu.equalsIgnoreCase("LDB $"))
			X = "C6";
		else if(P1.equalsIgnoreCase("LDD") && !Etendu.equalsIgnoreCase("LDD $"))
			X = "CC";
		else if(P1.equalsIgnoreCase("LDS") && !Etendu.equalsIgnoreCase("LDS $"))
			X = "10CE";
		else if(P1.equalsIgnoreCase("LDU") && !Etendu.equalsIgnoreCase("LDU $"))
			X = "CE";
		else if(P1.equalsIgnoreCase("LDX") && !Etendu.equalsIgnoreCase("LDX $"))
			X = "8E";
		else if(P1.equalsIgnoreCase("LDY") && !Etendu.equalsIgnoreCase("LDY $"))
			X = "108E";
		// pour ADD : 
		else if(P1.equalsIgnoreCase("ADDA"))
			X = "8B";
		else if(P1.equalsIgnoreCase("ADDB"))
			X = "CB";
		else if(P1.equalsIgnoreCase("ADDD"))
			X = "C3";
		// pour SUB :
		else if(P1.equalsIgnoreCase("SUBA"))
			X = "80";
		else if(P1.equalsIgnoreCase("SUBB"))
			X = "C0";
		else if(P1.equalsIgnoreCase("SUBD"))
			X = "83";
		// pour AND :
		else if(P1.equalsIgnoreCase("ANDA"))
			X = "84";
		else if(P1.equalsIgnoreCase("ANDB"))
			X = "C4";
		// pour OR :
		else if(P1.equalsIgnoreCase("ORA"))
			X = "8A";
		else if(P1.equalsIgnoreCase("ORB"))
			X = "CA";
		// pour CMP :
		else if(P1.equalsIgnoreCase("CMPA"))
			X = "81";
		else if(P1.equalsIgnoreCase("CMPB"))
			X = "C1";
		else if(P1.equalsIgnoreCase("CMPX"))
			X = "8C";
		else if(P1.equalsIgnoreCase("CMPY"))
			X = "108C";
		else if(P1.equalsIgnoreCase("CMPS"))
			X = "118C";
		else if(P1.equalsIgnoreCase("CMPU"))
			X = "1183";
		else if(P1.equalsIgnoreCase("CMPD"))
			X = "1083";
		// pour TFR & EXG :
		else if(INSTRS.equalsIgnoreCase("TFRA,B")) 
		    X = "1F89";
		else if(INSTRS.equalsIgnoreCase("EXGA,B")) 
		    X = "1E89";

		else if(INSTRS.equalsIgnoreCase("TFRB,A")) 
		    X = "1F98";
		else if(INSTRS.equalsIgnoreCase("EXGB,A")) 
		    X = "1E98";

		else if(INSTRS.equalsIgnoreCase("TFRS,U")) 
		    X = "1F34";
		else if(INSTRS.equalsIgnoreCase("EXGS,U")) 
		    X = "1E34";

		else if(INSTRS.equalsIgnoreCase("TFRS,X")) 
		    X = "1F41";
		else if(INSTRS.equalsIgnoreCase("EXGS,X")) 
		    X = "1E41";

		else if(INSTRS.equalsIgnoreCase("TFRS,Y")) 
		    X = "1F42";
		else if(INSTRS.equalsIgnoreCase("EXGS,Y")) 
		    X = "1E42";

		else if(INSTRS.equalsIgnoreCase("TFRS,D")) 
		    X = "1F40";
		else if(INSTRS.equalsIgnoreCase("EXGS,D")) 
		    X = "1E40";

		else if(INSTRS.equalsIgnoreCase("TFRU,S")) 
		    X = "1F31";
		else if(INSTRS.equalsIgnoreCase("EXGU,S")) 
		    X = "1E31";

		else if(INSTRS.equalsIgnoreCase("TFRU,X")) 
		    X = "1F33";
		else if(INSTRS.equalsIgnoreCase("EXGU,X")) 
		    X = "1E33";

		else if(INSTRS.equalsIgnoreCase("TFRU,Y")) 
		    X = "1F32";
		else if(INSTRS.equalsIgnoreCase("EXGU,Y")) 
		    X = "1E32";

		else if(INSTRS.equalsIgnoreCase("TFRU,D")) 
		    X = "1F30";
		else if(INSTRS.equalsIgnoreCase("EXGU,D")) 
		    X = "1E30";

		else if(INSTRS.equalsIgnoreCase("TFRX,S")) 
		    X = "1F11";
		else if(INSTRS.equalsIgnoreCase("EXGX,S")) 
		    X = "1E11";

		else if(INSTRS.equalsIgnoreCase("TFRX,U")) 
		    X = "1F13";
		else if(INSTRS.equalsIgnoreCase("EXGX,U")) 
		    X = "1E13";

		else if(INSTRS.equalsIgnoreCase("TFRX,Y")) 
		    X = "1F12";
		else if(INSTRS.equalsIgnoreCase("EXGX,Y")) 
		    X = "1E12";

		else if(INSTRS.equalsIgnoreCase("TFRX,D")) 
		    X = "1F14";
		else if(INSTRS.equalsIgnoreCase("EXGX,D")) 
		    X = "1E14";

		else if(INSTRS.equalsIgnoreCase("TFRY,S")) 
		    X = "1F21";
		else if(INSTRS.equalsIgnoreCase("EXGY,S")) 
		    X = "1E21";

		else if(INSTRS.equalsIgnoreCase("TFRY,U")) 
		    X = "1F23";
		else if(INSTRS.equalsIgnoreCase("EXGY,U")) 
		    X = "1E23";

		else if(INSTRS.equalsIgnoreCase("TFRY,X")) 
		    X = "1F21";
		else if(INSTRS.equalsIgnoreCase("EXGY,X")) 
		    X = "1E21";

		else if(INSTRS.equalsIgnoreCase("TFRY,D")) 
		    X = "1F20";
		else if(INSTRS.equalsIgnoreCase("EXGY,D")) 
		    X = "1E20";

		else if(INSTRS.equalsIgnoreCase("TFRD,S")) 
		    X = "1F01";
		else if(INSTRS.equalsIgnoreCase("EXGD,S")) 
		    X = "1E01";

		else if(INSTRS.equalsIgnoreCase("TFRD,U")) 
		    X = "1F03";
		else if(INSTRS.equalsIgnoreCase("EXGD,U")) 
		    X = "1E03";

		else if(INSTRS.equalsIgnoreCase("TFRD,X")) 
		    X = "1F04";
		else if(INSTRS.equalsIgnoreCase("EXGD,X")) 
		    X = "1E04";

		else if(INSTRS.equalsIgnoreCase("TFRD,Y")) 
		    X = "1F02";
		else if(INSTRS.equalsIgnoreCase("EXGD,Y")) 
		    X = "1E02";
		// pour STOCK :
		else if(P1.equalsIgnoreCase("STA"))
			X = "B7";
		else if(P1.equalsIgnoreCase("STB"))
			X = "F7";
		else if(P1.equalsIgnoreCase("STD"))
			X = "FD";
		else if(P1.equalsIgnoreCase("STS"))
			X = "10FF";
		else if(P1.equalsIgnoreCase("STU"))
			X = "FF";
		else if(P1.equalsIgnoreCase("STX"))
			X = "BF";
		else if(P1.equalsIgnoreCase("STY"))
			X = "10BF";
		// pour PUSH :
		else if(P1.equalsIgnoreCase("PSHS"))
			X = "34";
		else if(P1.equalsIgnoreCase("PSHU"))
			X = "36";
		// pour INHERANT :
		else if(INSTRS.equalsIgnoreCase("ABX")) 
		    X = "3A";
		else if(INSTRS.equalsIgnoreCase("CLRA")) 
		    X = "4F";
		else if(INSTRS.equalsIgnoreCase("CLRB")) 
		    X = "5F";
		else if(INSTRS.equalsIgnoreCase("DECA")) 
		    X = "4A";
		else if(INSTRS.equalsIgnoreCase("DECB")) 
		    X = "5A";
		else if(INSTRS.equalsIgnoreCase("INCA")) 
		    X = "4C";
		else if(INSTRS.equalsIgnoreCase("INCB")) 
		    X = "5C";
		else if(INSTRS.equalsIgnoreCase("NOP")) 
		    X = "12";
		else if(INSTRS.equalsIgnoreCase("MUL")) 
		    X = "3D";
		else if(Etendu.equalsIgnoreCase("LDA $")) 
		    X = "B6";
		else if(Etendu.equalsIgnoreCase("LDB $")) 
		    X = "F6";
		else if(Etendu.equalsIgnoreCase("LDS $")) 
		    X = "10FE";
		else if(Etendu.equalsIgnoreCase("LDU $")) 
		    X = "FE";
		else if(Etendu.equalsIgnoreCase("LDX $")) 
		    X = "BE";
		else if(Etendu.equalsIgnoreCase("LDY $")) 
		    X = "10BE";
		else if(Etendu.equalsIgnoreCase("LDD $")) 
		    X = "FC";
		else if(Etendu.equalsIgnoreCase("ADDA $")) 
		    X = "BB";
		else if(Etendu.equalsIgnoreCase("ADDB $")) 
		    X = "FB";
		else if(Etendu.equalsIgnoreCase("ADDD $")) 
		    X = "F3";
		}
		return X;
	}
}




