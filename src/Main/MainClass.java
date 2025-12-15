package Main;


import javax.swing.SwingUtilities;

import graphicUserInterface.GUIClass;

public class MainClass {
	public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIClass::new);
	}

}
