package graphicUserInterface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import programMethodes.Erreurs;
import programMethodes.Instructions;
import programMethodes.Memoire;
import programMethodes.Registres;
import programMethodes.UAL;


public class GUIClass {
	public GUIClass() {
		initComponents();
	}
	Memoire MEM = new Memoire();
	Erreurs ERR = new Erreurs();
	Instructions INST = new Instructions();
	UAL UAL = new UAL();
	Registres REG = new Registres();
	
	private int AdROM[] = MEM.AdressROM();
	private int AdRAM[] = MEM.AdressRAM();
	private int ValROM[] = MEM.InitValeurROM();
	private int ValROMInitial[] = MEM.InitValeurROM();
	private int ValRAM[] = MEM.InitValeurRAM();
	private int ValRAMInitial[] = MEM.InitValeurRAM();
	private int step=0;
	private int stepA=0;
	private int stepB=0;
	private int stepS=0;
	private int stepX=0;
	private int stepY=0;
	private int stepDP=0;
	private int stepCCR=0;
	private int stepRAM=0;
	ArrayList<String> T1 = new ArrayList<>();
	private String[] InstructionName;
	private String[] P2;
	private char[] AdressageMode;
	private String[] Valeur;
	ArrayList<Integer> A_val = new ArrayList<>();
	ArrayList<Integer> B_val = new ArrayList<>();
	ArrayList<Integer> S_val = new ArrayList<>();
	ArrayList<Integer> X_val = new ArrayList<>();
	ArrayList<Integer> Y_val = new ArrayList<>();
	ArrayList<Integer> DP_val = new ArrayList<>();
	ArrayList<int[]> RAM_val = new ArrayList<>();
	ArrayList<int[]> CCR = new ArrayList<>();
	private int[] PC_val = new int[512];

	private void initComponents() {
		
		MOF6809 = new JFrame("MOF6809");
		BACKGROUNDPanel = new JPanel();
		LogoLabel = new JLabel();
		ramPanel = new JPanel();
		RAM = new JLabel();
		RAMscrollPane = new JScrollPane();
		RAMtable = new JTable();
		romPanel = new JPanel();
		ROM = new JLabel();
		ROMscrollPane = new JScrollPane();
		ROMtable = new JTable();
		TextCodeWindow = new JScrollPane();
		TextCodeArea = new JTextArea();
		ERRORTextField = new JScrollPane();
		ERRORArea = new JTextArea();
		CodeWindow = new JPanel();
		CodeWindowTxt = new JLabel();
		Compile = new JButton();
		Clear_All = new JButton();
		Execute_All = new JButton();
		Step_By_Step = new JButton();
		Reset = new JButton();
		PCPanel = new JPanel();
		PC = new JLabel();
		PCTextField = new JTextField();
		APanel = new JPanel();
		A = new JLabel();
		ATextField = new JTextField();
		BPanel = new JPanel();
		B = new JLabel();
		BTextField = new JTextField();
		SPanel = new JPanel();
		S = new JLabel();
		STextField = new JTextField();
		DPPanel = new JPanel();
		DP = new JLabel();
		DPTextField = new JTextField();
		UPanel = new JPanel();
		U = new JLabel();
		UTextField = new JTextField();
		XPanel = new JPanel();
		X = new JLabel();
		XTextField = new JTextField();
		YPanel = new JPanel();
		Y = new JLabel();
		YTextField = new JTextField();
		CCPanel = new JPanel();
		CC = new JLabel();
		CC1 = new JTextField();
		CC2 = new JTextField();
		CC3 = new JTextField();
		CC4 = new JTextField();
		CC5 = new JTextField();
		CC6 = new JTextField();
		CC7 = new JTextField();
		CC8 = new JTextField();
		INSTRTextField = new JTextField();
		ALUSymbol = new JLabel();
		label1 = new JLabel();
		
		//======== Initial ========
		ATextField.setText("00");
		BTextField.setText("00");
		DPTextField.setText("00");
		PCTextField.setText("0000");
		STextField.setText("0000");
		UTextField.setText("0000");
		XTextField.setText("0000");
		YTextField.setText("0000");
		CC1.setText("0");
		CC2.setText("0");
		CC3.setText("0");
		CC4.setText("0");
		CC5.setText("0");
		CC6.setText("0");
		CC7.setText("0");
		CC8.setText("0");
		
		
		//======= CompileButton ========
		Compile.addActionListener(e -> {
			
			//========  Input  ======== 
	        String CodeAssembly = TextCodeArea.getText();
	        String[] lines = CodeAssembly.split("\\r?\\n", -1);
	        T1.clear();
	        T1.addAll(Arrays.asList(lines));
	        T1.replaceAll(String::toUpperCase);
	        int tai_T1 = T1.size();
	        
	        InstructionName = new String [tai_T1 - 1];
	        P2 = new String [tai_T1 - 1];
	        AdressageMode = new char [tai_T1 - 1];
	        Valeur = new String [tai_T1 - 1];

	        //====== Break_Form ======
	        InstructionName = INST.GetP1(T1);
	        P2 = INST.GetP2(T1);
	        AdressageMode = INST.GetModeAdressage(P2);
	        Valeur = INST.GetValue(P2);
	        int taille = InstructionName.length;
	        
	        for (int i=0; i<taille;i++) {
	        	if (InstructionName[i] != null)
	        		InstructionName[i]=InstructionName[i].trim();
	        }

	        for (int i=0; i<Valeur.length;i++) {
	        	if (Valeur[i] != null)
	        	Valeur[i]=Valeur[i].trim();
	        }
	        
	        int P1_NombreOctets [] = ERR.P1_NumberOctets(T1,InstructionName,AdressageMode, taille);
			int P22_NombreOctets [] = ERR.P22_NumberOctets(Valeur, taille );

	        //======== Errors =========
	        ERRORArea.setText(ERR.AfficheCompilation(T1, InstructionName, AdressageMode, Valeur));
	        int Err = ERR.ErrorNumbers(T1, InstructionName, AdressageMode, Valeur);

	        if (Err == 0) {
	            
	        	
	        	//======= StockROMValues =======
	            ValROM = MEM.ValeurROM(T1,InstructionName,AdressageMode, Valeur, P1_NombreOctets, P22_NombreOctets, taille);
	            DefaultTableModel valrroomm = (DefaultTableModel) ROMtable.getModel();
	            for (int i = 0; i < ValROM.length; i++) {
	                String hexVALROM = String.format("%02X", ValROM[i]);
	                valrroomm.setValueAt(hexVALROM, i, 1);
	            }
	            AdRAM = MEM.AdressRAM();
	            
	            PC_val = REG.PC(P1_NombreOctets, P22_NombreOctets, AdROM, taille); 
	            
	            UAL.CalculMembers Calc = UAL.Calcule(T1, PC_val , InstructionName, AdressageMode, ValROM, AdRAM, P1_NombreOctets, P22_NombreOctets);
	            A_val = Calc.A;
	            B_val = Calc.B;
	            S_val = Calc.S;
	            X_val = Calc.X;
	            Y_val = Calc.Y;
	            DP_val = Calc.DP;
	            RAM_val = Calc.Valram;
	            CCR = Calc.CCR; 
	            
	            step = 0; 
	            stepA = 0;
	            stepB = 0;
	            stepS = 0;
	            stepX = 0;
	            stepY = 0;
	            stepDP = 0;
	            stepCCR = 0;
	            stepRAM = 0;
	            
	            PCTextField.setText(String.format("%04X", PC_val[step]).toUpperCase());
				INSTRTextField.setText(T1.get(step));
				CC1.setText(Integer.toString(CCR.get(step)[0]));
        		CC2.setText(Integer.toString(CCR.get(step)[1]));
        		CC3.setText(Integer.toString(CCR.get(step)[2]));
        		CC4.setText(Integer.toString(CCR.get(step)[3]));
        		CC5.setText(Integer.toString(CCR.get(step)[4]));
        		CC6.setText(Integer.toString(CCR.get(step)[5]));
        		CC7.setText(Integer.toString(CCR.get(step)[6]));
        		CC8.setText(Integer.toString(CCR.get(step)[7]));

	        } else {
	            
	            ATextField.setText("00");
	            BTextField.setText("00");
	            STextField.setText("0000");
	            XTextField.setText("0000");
	            YTextField.setText("0000");
	            PCTextField.setText("0000");
	            INSTRTextField.setText("");
	            CC1.setText("0");
				CC2.setText("0");
				CC3.setText("0");
				CC4.setText("0");
				CC5.setText("0");
				CC6.setText("0");
				CC7.setText("0");
				CC8.setText("0");
	        }
	    });
		
		//======= ExecutionButton ========
		Execute_All.addActionListener(f -> {
			int last = T1.size();
	        if (A_val == null || A_val.size() == 0) {
	            ATextField.setText("00");
	        } 
	        	else {
	        		int idxA = A_val.size() - 1;
	        		ATextField.setText(String.format("%02X", A_val.get(idxA) & 0xFF).toUpperCase());
	        	}
	        
	        
	        if (B_val == null || B_val.size() == 0) {
	        	BTextField.setText("00");
	        } 
	        	else {
	        		int idxB = B_val.size() - 1;
	        		BTextField.setText(String.format("%02X", B_val.get(idxB) & 0xFF).toUpperCase());
	        	}
	        
	        if (S_val == null || S_val.size() == 0) {
	            STextField.setText("0000");
	        } 
	        	else {
	        		int idxS = S_val.size() - 1;
	        		STextField.setText(String.format("%04X", S_val.get(idxS) & 0xFFFF).toUpperCase());
	        	}
	        
	        if (X_val == null || X_val.size() == 0) {
	            XTextField.setText("0000");
	        } 
	        	else {
	        		int idxX = X_val.size() - 1;
	        		XTextField.setText(String.format("%04X", X_val.get(idxX) & 0xFFFF).toUpperCase());
	        	}
	        
	        if (Y_val == null || Y_val.size() == 0) {
	            YTextField.setText("0000");
	        } 
	        	else {
	        		int idxY = Y_val.size() - 1;
	        		YTextField.setText(String.format("%04X", Y_val.get(idxY) & 0xFFFF).toUpperCase());
	        	}
	        if (DP_val == null || DP_val.size() == 0) {
	            DPTextField.setText("00");
	        } 
	        	else {
	        		int idxDP = DP_val.size() - 1;
	        		DPTextField.setText(String.format("%02X", DP_val.get(idxDP) & 0xFF).toUpperCase());
	        	}
	        
	        if (CCR == null || CCR.size() == 0) {
	            CC1.setText("00");CC2.setText("00");CC3.setText("00");CC4.setText("00");CC5.setText("00");CC6.setText("00");CC7.setText("00");CC8.setText("00");
	        } 
	        	else {
	        		int idxCCR = CCR.size() - 1;
	        		CC1.setText(Integer.toString(CCR.get(idxCCR)[0]));
	        		CC2.setText(Integer.toString(CCR.get(idxCCR)[1]));
	        		CC3.setText(Integer.toString(CCR.get(idxCCR)[2]));
	        		CC4.setText(Integer.toString(CCR.get(idxCCR)[3]));
	        		CC5.setText(Integer.toString(CCR.get(idxCCR)[4]));
	        		CC6.setText(Integer.toString(CCR.get(idxCCR)[5]));
	        		CC7.setText(Integer.toString(CCR.get(idxCCR)[6]));
	        		CC8.setText(Integer.toString(CCR.get(idxCCR)[7]));
	        	}
	        
	        if (RAM_val == null || RAM_val.size() == 0) {
	        	DefaultTableModel valrraamm = (DefaultTableModel) RAMtable.getModel();
				for (int i = 0; i < ValRAMInitial.length; i++) {
				    String hexVALRAM = String.format("%02X", 0);
				    valrraamm.setValueAt(hexVALRAM, i, 1);
				}
	        } 
	        	else {
	        		int idxRAM = RAM_val.size() - 1;
	        		
	        		DefaultTableModel valrraamm = (DefaultTableModel) RAMtable.getModel();
	        		int len = Math.min(
	        				ValRAMInitial.length,
	        			    RAM_val.get(idxRAM).length
	        			);

	        			for (int i = 0; i < len; i++) {
	        			    String hexVALRAM = String.format("%02X", RAM_val.get(idxRAM)[i]);
	        			    valrraamm.setValueAt(hexVALRAM, i, 1);
	        			}
	        	}
	        
	        int idxPC = Math.min(PC_val.length - 1, last - 1);
	        if (PC_val != null && PC_val.length > idxPC) {
	            PCTextField.setText(String.format("%04X", PC_val[idxPC]).toUpperCase());
	        } else {
	            PCTextField.setText("0000");
	        }

	        INSTRTextField.setText(last-1 >= 0 && last-1 < T1.size() ? T1.get(last-1) : "");
	    });
		
		
		//======= StepByStepButton ========
		 Step_By_Step.addActionListener(i -> {
		        if (InstructionName == null || T1.size() == 0) {
		            return; 
		        }
		        int idxA = A_val.size() - 1;
		        int idxB = B_val.size() - 1;
		        int idxS = S_val.size() - 1;
		        int idxX = X_val.size() - 1;
		        int idxY = Y_val.size() - 1;
		        int idxDP = DP_val.size() - 1;
		        int idxCCR = CCR.size() - 1;
		        int idxRAM = RAM_val.size() - 1;


		        stepA++;
		        stepB++;
		        stepS++;
		        stepX++;
		        stepY++;
		        stepDP++;
		        stepCCR++;
		        stepRAM++;
		        step++;
		        if (step >= T1.size()) {
		        	
		        }
		        else {
		        
		        	if (stepA >= A_val.size()) stepA = idxA+1;
		        	if (stepB >= B_val.size()) stepB = idxB+1;
		        	if (stepS >= S_val.size()) stepS = idxS+1;
		        	if (stepX >= X_val.size()) stepX = idxX+1;
		        	if (stepY >= Y_val.size()) stepY = idxY+1;
		        	if (stepDP >= DP_val.size()) stepDP = idxDP+1;
		        	if (stepCCR >= CCR.size()) stepCCR = idxCCR+1;
		        	if (stepRAM >= RAM_val.size()) stepRAM = idxRAM+1;
		        ATextField.setText(String.format("%02X", A_val.get(stepA-1) & 0xFF).toUpperCase());
		        BTextField.setText(String.format("%02X", B_val.get(stepB-1) & 0xFF).toUpperCase());
		        DPTextField.setText(String.format("%02X", DP_val.get(stepDP-1) & 0xFF).toUpperCase());
		        STextField.setText(String.format("%04X", S_val.get(stepS-1) & 0xFFFF).toUpperCase());
		        XTextField.setText(String.format("%04X", X_val.get(stepX-1) & 0xFFFF).toUpperCase());
		        YTextField.setText(String.format("%04X", Y_val.get(stepY-1) & 0xFFFF).toUpperCase());
		        PCTextField.setText(String.format("%04X", PC_val[step] & 0xFFFF).toUpperCase());
				INSTRTextField.setText(T1.get(step));
				CC1.setText(Integer.toString(CCR.get(step)[0]));
        		CC2.setText(Integer.toString(CCR.get(step)[1]));
        		CC3.setText(Integer.toString(CCR.get(step)[2]));
        		CC4.setText(Integer.toString(CCR.get(step)[3]));
        		CC5.setText(Integer.toString(CCR.get(step)[4]));
        		CC6.setText(Integer.toString(CCR.get(step)[5]));
        		CC7.setText(Integer.toString(CCR.get(step)[6]));
        		CC8.setText(Integer.toString(CCR.get(step)[7]));
        		
        		DefaultTableModel valrraamm = (DefaultTableModel) RAMtable.getModel();
				int len = Math.min(
					    ValRAMInitial.length,
					    RAM_val.get(idxRAM).length
					);

					for (int r = 0; r < len; r++) {
					    String hexVALRAM = String.format("%02X", RAM_val.get(stepRAM-1)[r]);
					    valrraamm.setValueAt(hexVALRAM, r, 1);
					}
		        }
		    });
		 
		//======= ClearAllButton ========
		Clear_All.addActionListener(h -> {
			TextCodeArea.setText(null);
		});
		
		//======= ResetButton ========
		Reset.addActionListener(g -> {
			ATextField.setText("00");
			BTextField.setText("00");
			DPTextField.setText("00");
			STextField.setText("0000");
            XTextField.setText("0000");
            YTextField.setText("0000");
			PCTextField.setText("0000");
			STextField.setText("0000");
			UTextField.setText("0000");
			XTextField.setText("0000");
			YTextField.setText("0000");
			INSTRTextField.setText(null);
			CC1.setText("0");
			CC2.setText("0");
			CC3.setText("0");
			CC4.setText("0");
			CC5.setText("0");
			CC6.setText("0");
			CC7.setText("0");
			CC8.setText("0");
			step=0; 
			
			InstructionName = null;
	        ValROM = new int[0];
	        A_val = new ArrayList<>();
	        PC_val = new int[0];
			
			DefaultTableModel valrraamm = (DefaultTableModel) RAMtable.getModel();
			for (int i = 0; i < ValRAMInitial.length; i++) {
			    String hexVALRAM = String.format("%02X", ValRAMInitial[i]);
			    valrraamm.setValueAt(hexVALRAM, i, 1);
			}
			
			DefaultTableModel valrroomm = (DefaultTableModel) ROMtable.getModel();
			for (int i = 0; i < ValROMInitial.length; i++) {
			    String hexVALROM = String.format("%02X", ValROMInitial[i]);
			    valrroomm.setValueAt(hexVALROM, i, 1);
			}
			
		});
		
	
		//======== MOF6809 ========
		{
			MOF6809.setBackground(new Color(0xff8d76));
			MOF6809.setPreferredSize(new Dimension(1365, 786));
			MOF6809.setIconImage(
				    new ImageIcon(
				        getClass().getResource("/images/Icon.png")
				    ).getImage()
				);
			Container MOF6809ContentPane = MOF6809.getContentPane();
			MOF6809ContentPane.setLayout(null);

			//======== BACKGROUNDPanel ========
			{
				BACKGROUNDPanel.setBackground(new Color(0xff8d76));
				BACKGROUNDPanel.setPreferredSize(new Dimension(1280, 720));
				BACKGROUNDPanel.setForeground(Color.white);
				BACKGROUNDPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
				( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border
				. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
				. Color. red) ,BACKGROUNDPanel. getBorder( )) ); BACKGROUNDPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
				propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
				; }} );
				BACKGROUNDPanel.setLayout(null);

				//---- LogoLabel ----
				LogoLabel.setIcon(
					    new ImageIcon(
					        getClass().getResource("/images/Logo.png")
					    )
					);

				BACKGROUNDPanel.add(LogoLabel);
				LogoLabel.setBounds(493, 10, 293, 105);

				//======== ramPanel ========
				{
					ramPanel.setBackground(new Color(0xf9745f));
					ramPanel.setBorder(LineBorder.createBlackLineBorder());
					ramPanel.setLayout(null);

					//---- RAM ----
					RAM.setText("RAM");
					RAM.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					RAM.setForeground(Color.white);
					ramPanel.add(RAM);
					RAM.setBounds(48, 5, 55, 25);
				}
				BACKGROUNDPanel.add(ramPanel);
				ramPanel.setBounds(35, 170, 150, 32);

				//======== RAMscrollPane ========
				{

					//---- RAMtable ----
					RAMtable.setBorder(null);
					RAMtable.setShowHorizontalLines(true);
					RAMtable.setShowVerticalLines(true);
					RAMtable.setRowSorter(null);

					DefaultTableModel model = new DefaultTableModel(
					        new String[]{"Adresses", "Valeurs"},
					        1280   // number of rows (0x0000 → 0x04FF)
					) {
					    @Override
					    public boolean isCellEditable(int row, int column) {
					        return false;
					    }

					    @Override
					    public Class<?> getColumnClass(int column) {
					        return Integer.class;
					    }
					};

					RAMtable.setModel(model);

					RAMtable.setFont(new Font("Azeret Mono Light", Font.BOLD, 15));
					RAMscrollPane.setViewportView(RAMtable);
					
					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
					centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

					for (int i = 0; i < RAMtable.getColumnCount(); i++) {
					    RAMtable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
					}
					
					DefaultTableModel adrraamm = (DefaultTableModel) RAMtable.getModel();
					for (int i = 0; i < AdRAM.length; i++) {
					    String hexADRAM = String.format("%04X", AdRAM[i]);
					    adrraamm.setValueAt(hexADRAM, i, 0);
					}
					
					DefaultTableModel valrraamm = (DefaultTableModel) RAMtable.getModel();
					for (int i = 0; i < ValRAM.length; i++) {
					    String hexVALRAM = String.format("%02X", ValRAM[i]);
					    valrraamm.setValueAt(hexVALRAM, i, 1);
					}
				}
				BACKGROUNDPanel.add(RAMscrollPane);
				RAMscrollPane.setBounds(35, 200, 150, 380);

				//======== romPanel ========
				{
					romPanel.setBackground(new Color(0xf9745f));
					romPanel.setBorder(LineBorder.createBlackLineBorder());
					romPanel.setLayout(null);

					//---- ROM ----
					ROM.setText("ROM");
					ROM.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					ROM.setForeground(Color.white);
					romPanel.add(ROM);
					ROM.setBounds(48, 5, 55, 25);
				}
				BACKGROUNDPanel.add(romPanel);
				romPanel.setBounds(195, 170, 150, 32);

				//======== ROMscrollPane ========
				{

					//---- ROMtable ----
					ROMtable.setBorder(null);
					ROMtable.setShowHorizontalLines(true);
					ROMtable.setShowVerticalLines(true);
					ROMtable.setRowSorter(null);

					DefaultTableModel romModel = new DefaultTableModel(
					        new String[]{"Adresses", "Valeurs"},
					        1024   // adjust if ROM size is different
					) {
					    @Override
					    public boolean isCellEditable(int row, int column) {
					        return false;
					    }

					    @Override
					    public Class<?> getColumnClass(int column) {
					        return Integer.class;
					    }
					};

					ROMtable.setModel(romModel);

					ROMtable.setFont(new Font("Azeret Mono Light", Font.BOLD, 15));
					ROMscrollPane.setViewportView(ROMtable);
				}
				BACKGROUNDPanel.add(ROMscrollPane);
				ROMscrollPane.setBounds(195, 200, 150, 380);
				
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

				for (int i = 0; i < ROMtable.getColumnCount(); i++) {
				    ROMtable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
				}
				
				DefaultTableModel adrroomm = (DefaultTableModel) ROMtable.getModel();
				for (int i = 0; i < AdROM.length; i++) {
				    String hexADROM = String.format("%04X", AdROM[i]);
				    adrroomm.setValueAt(hexADROM, i, 0);
				}
				
				DefaultTableModel valrroomm = (DefaultTableModel) ROMtable.getModel();
				for (int i = 0; i < ValROM.length; i++) {
				    String hexVALROM = String.format("%02X", ValROM[i]);
				    valrroomm.setValueAt(hexVALROM, i, 1);
				}
				//======== TextCodeWindow ========
				{

					//---- TextCodeArea ----
					TextCodeArea.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
					TextCodeWindow.setViewportView(TextCodeArea);
				}
				BACKGROUNDPanel.add(TextCodeWindow);
				TextCodeWindow.setBounds(950, 232, 300, 250);

				//======== ERRORTextField ========
				{

					//---- ERRORArea ----
					ERRORArea.setFont(new Font("Azeret Mono Light", Font.ITALIC, 15));
					ERRORArea.setEditable(false);
					ERRORArea.setForeground(Color.gray);
					ERRORTextField.setViewportView(ERRORArea);
					
				}
				BACKGROUNDPanel.add(ERRORTextField);
				ERRORTextField.setBounds(950, 480, 300, 98);
			}
			MOF6809ContentPane.add(BACKGROUNDPanel);
			BACKGROUNDPanel.setBounds(new Rectangle(new Point(0, 0), BACKGROUNDPanel.getPreferredSize()));

			{

				//======== CodeWindow ========
				{
					CodeWindow.setBackground(new Color(0xff8d76));
					CodeWindow.setBorder(LineBorder.createBlackLineBorder());
					CodeWindow.setLayout(null);

					//---- CodeWindowTxt ----
					CodeWindowTxt.setText("Code Window");
					CodeWindowTxt.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					CodeWindowTxt.setForeground(Color.white);
					CodeWindow.add(CodeWindowTxt);
					CodeWindowTxt.setBounds(75, 5, 150, 25);
				}
				BACKGROUNDPanel.add(CodeWindow);
				CodeWindow.setBounds(950, 170, 300, 32);

				//---- Compile ----
				Compile.setText("Compile");
				Compile.setBackground(new Color(0xf9745f));
				Compile.setBorder(LineBorder.createBlackLineBorder());
				Compile.setFont(new Font("Bahnschrift", Font.BOLD, 18));
				Compile.setForeground(Color.white);
				BACKGROUNDPanel.add(Compile);
				Compile.setBounds(950, 200, 150, 32);

				//---- Clear_All ----
				Clear_All.setText("Clear All");
				Clear_All.setBackground(new Color(0xf9745f));
				Clear_All.setBorder(LineBorder.createBlackLineBorder());
				Clear_All.setFont(new Font("Bahnschrift", Font.BOLD, 18));
				Clear_All.setForeground(Color.white);
				BACKGROUNDPanel.add(Clear_All);
				Clear_All.setBounds(1100, 200, 150, 32);

				//---- Execute_All ----
				Execute_All.setText("Execute All");
				Execute_All.setBackground(new Color(0xf9745f));
				Execute_All.setBorder(LineBorder.createBlackLineBorder());
				Execute_All.setFont(new Font("Bahnschrift", Font.BOLD, 18));
				Execute_All.setForeground(Color.white);
				BACKGROUNDPanel.add(Execute_All);
				Execute_All.setBounds(415, 590, 150, 32);

				//---- Step_By_Step ----
				Step_By_Step.setText("Step By Step");
				Step_By_Step.setBackground(new Color(0xf9745f));
				Step_By_Step.setBorder(LineBorder.createBlackLineBorder());
				Step_By_Step.setFont(new Font("Bahnschrift", Font.BOLD, 18));
				Step_By_Step.setForeground(Color.white);
				BACKGROUNDPanel.add(Step_By_Step);
				Step_By_Step.setBounds(575, 590, 150, 32);

				//---- Reset ----
				Reset.setText("Reset");
				Reset.setBackground(new Color(0xf9745f));
				Reset.setBorder(LineBorder.createBlackLineBorder());
				Reset.setFont(new Font("Bahnschrift", Font.BOLD, 18));
				Reset.setForeground(Color.white);
				BACKGROUNDPanel.add(Reset);
				Reset.setBounds(735, 590, 150, 32);

				//======== PCPanel ========
				{
					PCPanel.setBackground(new Color(0xff8d76));
					PCPanel.setBorder(LineBorder.createBlackLineBorder());
					PCPanel.setLayout(null);

					//---- PC ----
					PC.setText("PC");
					PC.setFont(new Font("Bahnschrift", Font.BOLD, 20));
					PC.setForeground(Color.white);
					PCPanel.add(PC);
					PC.setBounds(5, 2, 35, 30);
				}
				BACKGROUNDPanel.add(PCPanel);
				PCPanel.setBounds(390, 210, 40, 30);

				//---- PCTextField ----
				PCTextField.setEditable(false);
				PCTextField.setHorizontalAlignment(SwingConstants.CENTER);
				PCTextField.setBorder(LineBorder.createBlackLineBorder());
				PCTextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(PCTextField);
				PCTextField.setBounds(430, 210, 210, 30);
				

				//======== APanel ========
				{
					APanel.setBackground(new Color(0xff8d76));
					APanel.setBorder(LineBorder.createBlackLineBorder());
					APanel.setLayout(null);

					//---- A ----
					A.setText("A");
					A.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					A.setForeground(Color.white);
					APanel.add(A);
					A.setBounds(12, 5, A.getPreferredSize().width, 25);
				}
				BACKGROUNDPanel.add(APanel);
				APanel.setBounds(390, 310, 40, 30);

				//---- ATextField ----
				ATextField.setEditable(false);
				ATextField.setHorizontalAlignment(SwingConstants.CENTER);
				ATextField.setBorder(LineBorder.createBlackLineBorder());
				ATextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(ATextField);
				ATextField.setBounds(430, 310, 60, 30);

				//======== BPanel ========
				{
					BPanel.setBackground(new Color(0xff8d76));
					BPanel.setBorder(LineBorder.createBlackLineBorder());
					BPanel.setLayout(null);

					//---- B ----
					B.setText("B");
					B.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					B.setForeground(Color.white);
					BPanel.add(B);
					B.setBounds(12, 5, B.getPreferredSize().width, 25);
				}
				BACKGROUNDPanel.add(BPanel);
				BPanel.setBounds(390, 360, 40, 30);

				//---- BTextField ----
				BTextField.setEditable(false);
				BTextField.setHorizontalAlignment(SwingConstants.CENTER);
				BTextField.setBorder(LineBorder.createBlackLineBorder());
				BTextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(BTextField);
				BTextField.setBounds(430, 360, 60, 30);

				//======== SPanel ========
				{
					SPanel.setBackground(new Color(0xff8d76));
					SPanel.setBorder(LineBorder.createBlackLineBorder());
					SPanel.setLayout(null);

					//---- S ----
					S.setText("S");
					S.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					S.setForeground(Color.white);
					SPanel.add(S);
					S.setBounds(12, 5, S.getPreferredSize().width, 25);
				}
				BACKGROUNDPanel.add(SPanel);
				SPanel.setBounds(460, 260, 40, 30);

				//---- STextField ----
				STextField.setEditable(false);
				STextField.setHorizontalAlignment(SwingConstants.CENTER);
				STextField.setBorder(LineBorder.createBlackLineBorder());
				STextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(STextField);
				STextField.setBounds(500, 260, 90, 30);

				//======== DPPanel ========
				{
					DPPanel.setBackground(new Color(0xff8d76));
					DPPanel.setBorder(LineBorder.createBlackLineBorder());
					DPPanel.setLayout(null);

					//---- DP ----
					DP.setText("DP");
					DP.setFont(new Font("Bahnschrift", Font.BOLD, 20));
					DP.setForeground(Color.white);
					DPPanel.add(DP);
					DP.setBounds(5, 2, 35, 30);
				}
				BACKGROUNDPanel.add(DPPanel);
				DPPanel.setBounds(450, 410, 40, 30);

				//---- DPTextField ----
				DPTextField.setEditable(false);
				DPTextField.setHorizontalAlignment(SwingConstants.CENTER);
				DPTextField.setBorder(LineBorder.createBlackLineBorder());
				DPTextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(DPTextField);
				DPTextField.setBounds(490, 410, 60, 30);

				//======== UPanel ========
				{
					UPanel.setBackground(new Color(0xff8d76));
					UPanel.setBorder(LineBorder.createBlackLineBorder());
					UPanel.setLayout(null);

					//---- U ----
					U.setText("U");
					U.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					U.setForeground(Color.white);
					UPanel.add(U);
					U.setBounds(12, 5, U.getPreferredSize().width, 25);
				}
				BACKGROUNDPanel.add(UPanel);
				UPanel.setBounds(690, 260, 40, 30);

				//---- UTextField ----
				UTextField.setEditable(false);
				UTextField.setHorizontalAlignment(SwingConstants.CENTER);
				UTextField.setBorder(LineBorder.createBlackLineBorder());
				UTextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(UTextField);
				UTextField.setBounds(730, 260, 90, 30);

				//======== XPanel ========
				{
					XPanel.setBackground(new Color(0xff8d76));
					XPanel.setBorder(LineBorder.createBlackLineBorder());
					XPanel.setLayout(null);

					//---- X ----
					X.setText("X");
					X.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					X.setForeground(Color.white);
					XPanel.add(X);
					X.setBounds(12, 5, X.getPreferredSize().width, 25);
				}
				BACKGROUNDPanel.add(XPanel);
				XPanel.setBounds(460, 490, 40, 30);

				//---- XTextField ----
				XTextField.setEditable(false);
				XTextField.setHorizontalAlignment(SwingConstants.CENTER);
				XTextField.setBorder(LineBorder.createBlackLineBorder());
				XTextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(XTextField);
				XTextField.setBounds(500, 490, 90, 30);

				//======== YPanel ========
				{
					YPanel.setBackground(new Color(0xff8d76));
					YPanel.setBorder(LineBorder.createBlackLineBorder());
					YPanel.setLayout(null);

					//---- Y ----
					Y.setText("Y");
					Y.setFont(new Font("Bahnschrift", Font.BOLD, 23));
					Y.setForeground(Color.white);
					YPanel.add(Y);
					Y.setBounds(12, 5, Y.getPreferredSize().width, 25);
				}
				BACKGROUNDPanel.add(YPanel);
				YPanel.setBounds(690, 490, 40, 30);

				//---- YTextField ----
				YTextField.setEditable(false);
				YTextField.setHorizontalAlignment(SwingConstants.CENTER);
				YTextField.setBorder(LineBorder.createBlackLineBorder());
				YTextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(YTextField);
				YTextField.setBounds(730, 490, 90, 30);

				//======== CCPanel ========
				{
					CCPanel.setBackground(new Color(0xff8d76));
					CCPanel.setBorder(LineBorder.createBlackLineBorder());
					CCPanel.setLayout(null);

					//---- CC ----
					CC.setText("CC");
					CC.setFont(new Font("Bahnschrift", Font.BOLD, 20));
					CC.setForeground(Color.white);
					CCPanel.add(CC);
					CC.setBounds(5, 2, 35, 30);
				}
				BACKGROUNDPanel.add(CCPanel);
				CCPanel.setBounds(590, 410, 40, 30);

				//---- CC1 ----
				CC1.setEditable(false);
				CC1.setHorizontalAlignment(SwingConstants.CENTER);
				CC1.setBorder(LineBorder.createBlackLineBorder());
				CC1.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(CC1);
				CC1.setBounds(630, 410, 30, 30);

				//---- CC2 ----
				CC2.setEditable(false);
				CC2.setHorizontalAlignment(SwingConstants.CENTER);
				CC2.setBorder(LineBorder.createBlackLineBorder());
				CC2.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(CC2);
				CC2.setBounds(660, 410, 30, 30);

				//---- CC3 ----
				CC3.setEditable(false);
				CC3.setHorizontalAlignment(SwingConstants.CENTER);
				CC3.setBorder(LineBorder.createBlackLineBorder());
				CC3.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(CC3);
				CC3.setBounds(690, 410, 30, 30);

				//---- CC4 ----
				CC4.setEditable(false);
				CC4.setHorizontalAlignment(SwingConstants.CENTER);
				CC4.setBorder(LineBorder.createBlackLineBorder());
				CC4.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(CC4);
				CC4.setBounds(720, 410, 30, 30);

				//---- CC5 ----
				CC5.setEditable(false);
				CC5.setHorizontalAlignment(SwingConstants.CENTER);
				CC5.setBorder(LineBorder.createBlackLineBorder());
				CC5.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(CC5);
				CC5.setBounds(750, 410, 30, 30);

				//---- CC6 ----
				CC6.setEditable(false);
				CC6.setHorizontalAlignment(SwingConstants.CENTER);
				CC6.setBorder(LineBorder.createBlackLineBorder());
				CC6.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(CC6);
				CC6.setBounds(780, 410, 30, 30);

				//---- CC7 ----
				CC7.setEditable(false);
				CC7.setHorizontalAlignment(SwingConstants.CENTER);
				CC7.setBorder(LineBorder.createBlackLineBorder());
				CC7.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(CC7);
				CC7.setBounds(810, 410, 30, 30);

				//---- CC8 ----
				CC8.setEditable(false);
				CC8.setHorizontalAlignment(SwingConstants.CENTER);
				CC8.setBorder(LineBorder.createBlackLineBorder());
				CC8.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(CC8);
				CC8.setBounds(840, 410, 30, 30);

				//---- INSTRTextField ----
				INSTRTextField.setEditable(false);
				INSTRTextField.setHorizontalAlignment(SwingConstants.CENTER);
				INSTRTextField.setBorder(LineBorder.createBlackLineBorder());
				INSTRTextField.setFont(new Font("Azeret Mono Light", Font.PLAIN, 20));
				BACKGROUNDPanel.add(INSTRTextField);
				INSTRTextField.setBounds(650, 210, 250, 30);

				//---- ALUSymbol ----
				ALUSymbol.setIcon(
					    new ImageIcon(
					        getClass().getResource("/images/UAL.png")
					    )
					);

				BACKGROUNDPanel.add(ALUSymbol);
				ALUSymbol.setBounds(490, 305, 255, 110);

				//---- label1 ----
				label1.setText("P    F    H     I    N    Z    C    V");
				label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 5f));
				label1.setForeground(Color.white);
				BACKGROUNDPanel.add(label1);
				label1.setBounds(639, 440, 255, 30);
			}
			MOF6809ContentPane.add(BACKGROUNDPanel);
			BACKGROUNDPanel.setBounds(new Rectangle(new Point(0, 0), BACKGROUNDPanel.getPreferredSize()));

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < MOF6809ContentPane.getComponentCount(); i++) {
					Rectangle bounds = MOF6809ContentPane.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = MOF6809ContentPane.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				MOF6809ContentPane.setMinimumSize(preferredSize);
				MOF6809ContentPane.setPreferredSize(preferredSize);
			}
			MOF6809.pack();
			MOF6809.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			MOF6809.setVisible(true);
			MOF6809.setLocationRelativeTo(MOF6809.getOwner());
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
	// Generated using JFormDesigner Evaluation license - Oussama AIT MENDIL
	private JFrame MOF6809;
	private JPanel BACKGROUNDPanel;
	private JLabel LogoLabel;
	private JPanel ramPanel;
	private JLabel RAM;
	private JScrollPane RAMscrollPane;
	private JTable RAMtable;
	private JPanel romPanel;
	private JLabel ROM;
	private JScrollPane ROMscrollPane;
	private JTable ROMtable;
	private JScrollPane TextCodeWindow;
	private JTextArea TextCodeArea;
	private JPanel CodeWindow;
	private JLabel CodeWindowTxt;
	private JButton Compile;
	private JButton Clear_All;
	private JButton Execute_All;
	private JButton Step_By_Step;
	private JButton Reset;
	private JPanel PCPanel;
	private JLabel PC;
	private JTextField PCTextField;
	private JPanel APanel;
	private JLabel A;
	private JTextField ATextField;
	private JPanel BPanel;
	private JLabel B;
	private JTextField BTextField;
	private JPanel SPanel;
	private JLabel S;
	private JTextField STextField;
	private JPanel DPPanel;
	private JLabel DP;
	private JTextField DPTextField;
	private JPanel UPanel;
	private JLabel U;
	private JTextField UTextField;
	private JPanel XPanel;
	private JLabel X;
	private JTextField XTextField;
	private JPanel YPanel;
	private JLabel Y;
	private JTextField YTextField;
	private JPanel CCPanel;
	private JLabel CC;
	private JTextField CC1;
	private JTextField CC2;
	private JTextField CC3;
	private JTextField CC4;
	private JTextField CC5;
	private JTextField CC6;
	private JTextField CC7;
	private JTextField CC8;
	private JTextField INSTRTextField;
	private JLabel ALUSymbol;
	private JLabel label1;
	private JScrollPane ERRORTextField;
	private JTextArea ERRORArea;
}




