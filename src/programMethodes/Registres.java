package programMethodes;

public class Registres {

	public int[] PC (int [] P1_NumberOctets , int P22_NumberOctets[] , int AddROM[] , int taille)
	{
		int[] PC = new int[taille + 1];
		
		int k = 0;
		int temp = 0;
		while(k<taille)
		{
			PC[k] = AddROM[ temp ];
			temp += P1_NumberOctets[k] + P22_NumberOctets[k];
			k++;
		}
		PC[k] = AddROM[temp];
		return PC;	
	}

}




