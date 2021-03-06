package testWeatherService;

import java.lang.Exception;
import java.util.Timer;
import melbourneweather2.MelbourneWeather2Stub;
import melbourneweather2.MelbourneWeather2Stub.*;
	

public class TestWeatherService extends Timer{

	// set up some constants to index into the result arrays
	private static final int TimestampIndex = 0;
	private static final int RainfallIndex = 1;
	private static String[] tempResponse = new String[40];
	private static final int TemperatureIndex = 1;
	String[] output = new String[200];

	public String getTemp(int index) throws Exception{
		//get temperature for specific location
		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		
		// Get the available locations from the web service
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		String[] Locations = LocationsResponse.get_return();
		GetTemperature TemperatureRequest = new GetTemperature();
		TemperatureRequest.setLocation(Locations[index]);
		GetTemperatureResponse TemperatureResponse = MelbourneWeatherService.getTemperature(TemperatureRequest);
		tempResponse = TemperatureResponse.get_return();
		String temp = tempResponse[TemperatureIndex];
		return temp;
	}
	
	public String getRain(int index) throws Exception{
		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		
		// Get the available locations from the web service
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		String[] Locations = LocationsResponse.get_return();
		String[] Rainfall = new String[2];
		String[] Rainfalls2 = new String[Locations.length];
		GetRainfall RainfallRequest = new GetRainfall();
		RainfallRequest.setLocation(Locations[index]);
		GetRainfallResponse RainfallResponse = MelbourneWeatherService.getRainfall(RainfallRequest);
		Rainfall = RainfallResponse.get_return();
		Rainfalls2[index] = Rainfall[RainfallIndex];
		String rain2 = Rainfalls2[index];
		return rain2;
	}
	
	public String getTime(int index) throws Exception{
		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		
		// Get the available locations from the web service
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		String[] Locations = LocationsResponse.get_return();
		String[] Rainfall = new String[2];
		String[] Rainfalls1 = new String[Locations.length];
		GetRainfall RainfallRequest = new GetRainfall();
		RainfallRequest.setLocation(Locations[index]);
		GetRainfallResponse RainfallResponse = MelbourneWeatherService.getRainfall(RainfallRequest);
		Rainfall = RainfallResponse.get_return();
		Rainfalls1[index] = Rainfall[TimestampIndex];
		String rain1 = Rainfalls1[index];
		return rain1;
	}
	
	

}
