//package programMethodes;
//
//import java.util.ArrayList;
//
//public class MainTest {
//
//	public static void main(String[] args) {
//		
//		//Les Objets:
//		//DECODAGE DEC = new DECODAGE();
//		Memoire MEM = new Memoire();
//		Erreurs ERR = new Erreurs();
//		Instructions INST = new Instructions();
//		UAL UAL = new UAL();
//		Registres REG = new Registres();
//		
//		
//		ArrayList<String> T1 = INST.tabInstructions();
//		
//		
//	
//		//Decomposition du code Assembleur, chaque ligne en 3 Parties :    Nom_d'instruction  ---  Mode_d'adressage  ---  Valeur
//		String[] InstructionName = INST.GetP1(T1);
//		String[] P2 = INST.GetP2(T1);
//		char[] AdressageMode = INST.GetModeAdressage(P2);
//		String[] Valeur = INST.GetValue(P2);
//		
//		
//		//Affichage des Erreurs de syntax
//		ERR.AfficheCompilation(T1, InstructionName, AdressageMode, Valeur);
//		
//		
//		
//		//Calcul de nombre des erreur
//		int Err = ERR.ErrorNumbers(T1, InstructionName, AdressageMode, Valeur);
//		
//		//Transformation de chaque valeur a un code assembleur en Hexadecimal  ex: LDA #$F5 -->  86 F5 
//		
//		INST.affInstructions(InstructionName, AdressageMode, Valeur);
//		
//	
//		int ValROM[] = MEM.ValeurROM(InstructionName, Valeur, Err);
//		int AdROM[] = MEM.AdressROM();
//		System.out.println("Nom Erreur " + Err);
//		int A = UAL.CalculeA(InstructionName, ValROM);
//		System.out.println("A = "+Integer.toHexString(A).toUpperCase());
//		int[] PC = REG.PC(InstructionName, AdROM);
//		//int AdRAM[] = MEM.AdressRAM();
//	
//		
//		
//		
//		System.out.println("PC: "+Integer.toHexString(PC[2]).toUpperCase());
//		int i=0;
//		while(i<50)
//		{
//			if(ValROM[i]<15)
//				System.out.println(Integer.toHexString(AdROM[i]).toUpperCase()+"   0"+Integer.toHexString(ValROM[i]).toUpperCase());
//			else
//			System.out.println(Integer.toHexString(AdROM[i]).toUpperCase()+"   "+Integer.toHexString(ValROM[i]).toUpperCase());
//			i++;
//		}
//			
//	}
//}
//
//
//
//
