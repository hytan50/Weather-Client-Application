package main;

import GUI.concreteMelbourneHomeScreen;
import designPattern.WeatherGrabber;
import designPattern.WeatherObserver;
import testWeatherService.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//launch application interface
		concreteMelbourneHomeScreen homeScreen = new concreteMelbourneHomeScreen();
		homeScreen.frmMelbourneWeather.setVisible(true);
		
	}

}
