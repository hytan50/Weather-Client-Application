package testWeatherService;

import java.lang.Exception;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import melbourneweather2.MelbourneWeather2Stub;
import melbourneweather2.MelbourneWeather2Stub.*;

/*
 * Basic example of use of MelbourneWeather2 Axis2 web services in Java
 * IMPORTANT: This is not intended as an example of good design. It is
 * simply an illustration of the basics.
 * 
 * Author:  David.Squire@monash.edu
 * Last Modified: 20170405
 */		

public class TestWeatherService extends Timer{

	// set up some constants to index into the result arrays
	private static final int TimestampIndex = 0;
	private static final int RainfallIndex = 1;
	private static String[] lol = new String[40];
	private static final int TemperatureIndex = 1;
	String[] output = new String[200];

	public String getTemp(int index) throws Exception{
		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		
		// Get the available locations from the web service
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		String[] Locations = LocationsResponse.get_return();
		String[] Temperature = new String[Locations.length];
		GetTemperature TemperatureRequest = new GetTemperature();
		TemperatureRequest.setLocation(Locations[index]);
		GetTemperatureResponse TemperatureResponse = MelbourneWeatherService.getTemperature(TemperatureRequest);
		lol = TemperatureResponse.get_return();
		String temp = lol[TemperatureIndex];
		return temp;
	}
	
	public String getRain(int index) throws Exception{
		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		
		// Get the available locations from the web service
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		String[] Locations = LocationsResponse.get_return();
		String[] Rainfall = new String[2];
		String[] Rainfalls1 = new String[Locations.length];
		String[] Rainfalls2 = new String[Locations.length];
		GetRainfall RainfallRequest = new GetRainfall();
		RainfallRequest.setLocation(Locations[index]);
		GetRainfallResponse RainfallResponse = MelbourneWeatherService.getRainfall(RainfallRequest);
		Rainfall = RainfallResponse.get_return();
		Rainfalls1[index] = Rainfall[TimestampIndex];
		Rainfalls2[index] = Rainfall[RainfallIndex];
		String rain1 = Rainfalls1[index];
		String rain2 = Rainfalls2[index];
		return rain2;
	}

}
