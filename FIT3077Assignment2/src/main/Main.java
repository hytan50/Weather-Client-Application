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
		
		TestWeatherService getWeatherData = new TestWeatherService();
		
		
		WeatherGrabber weatherGrabber = new WeatherGrabber();
		WeatherObserver weatherObserver =  new WeatherObserver(weatherGrabber);
		
		int locationIndex = homeScreen.locationComboBox.getSelectedIndex();
		String temp = getWeatherData.getTemp(locationIndex);
		weatherGrabber.setTemperature(temp);
		
		
		

	}

}
