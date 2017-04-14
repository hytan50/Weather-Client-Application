package testWeatherService;

import java.lang.Exception;
import java.util.Scanner;

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

public class TestWeatherService {

	// set up some constants to index into the result arrays
	private static final int TimestampIndex = 0;
	private static final int RainfallIndex = 1;
	private static final int TemperatureIndex = 1;
	
	public static void main(String[] args) throws Exception {

		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		
		// Get the available locations from the web service
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		
		Scanner input = new Scanner(System.in);  // Reading from System.in
		
		String[] Locations = LocationsResponse.get_return();
		String[] Rainfall = new String[2];
		String[] Rainfalls1 = new String[Locations.length];
		String[] Rainfalls2 = new String[Locations.length];
		String[] Temperature = new String[Locations.length];
		int n;
		
		System.out.println("Enter a location number: [1-22], because we currently have 22 locations ");
		n = input.nextInt();
		GetRainfall RainfallRequest = new GetRainfall();
		RainfallRequest.setLocation(Locations[n-1]);
		GetRainfallResponse RainfallResponse = MelbourneWeatherService.getRainfall(RainfallRequest);
		Rainfall = RainfallResponse.get_return();
		Rainfalls1[n-1] = Rainfall[TimestampIndex];
		Rainfalls2[n-1] = Rainfall[RainfallIndex];
		GetTemperature TemperatureRequest = new GetTemperature();
		TemperatureRequest.setLocation(Locations[n-1]);
		GetTemperatureResponse TemperatureResponse = MelbourneWeatherService.getTemperature(TemperatureRequest);
		Temperature = TemperatureResponse.get_return();
		System.out.print(
				Locations[n-1]
				+ " @ " + Rainfalls1[n-1]
				+ ":\n\tTemperature:\t" + Temperature[TemperatureIndex]
				+ "\n\tRainfall:\t" + Rainfalls2[n-1]
				+ "\n\n"
			);

		
		
		
		
		// Loop over the locations, and display the temperature and rainfall at each
		
		
	}

}
