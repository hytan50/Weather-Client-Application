package main;

import GUI.concreteMelbourneHomeScreen;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//launch application interface
		concreteMelbourneHomeScreen homeScreen = new concreteMelbourneHomeScreen();
		homeScreen.frmMelbourneWeather.setVisible(true);
		
	}

}
