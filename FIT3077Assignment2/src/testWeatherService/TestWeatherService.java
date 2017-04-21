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
		lol = TemperatureResponse.get_return();
		String temp = lol[TemperatureIndex];
		String rain1 = Rainfalls1[n-1];
		String rain2 = Rainfalls2[n-1];
		String locations = Locations[n-1];
		
		
		Output a = new Output(locations,rain1,temp,rain2);
		a.out();
		//Timer timer = new Timer();
		//timer.schedule(run(Locations,n,Rainfalls2, Temperature, Rainfalls1), 0, 5000);
		/*
		timer.schedule(new TimerTask() {
		    public void run() {
		       System.out.println(
						Locations[n-1]
								+ " @ " + Rainfalls1[n-1]
								+ ":\n\tTemperature:\t" + lol[TemperatureIndex]
								+ "\n\tRainfall:\t" + Rainfalls2[n-1]
								+ "\n\n"
							);
		    }
		}, 0, 300000);
		
		*/
		
		
		
		
		// Loop over the locations, and display the temperature and rainfall at each
		
		
	}

}
