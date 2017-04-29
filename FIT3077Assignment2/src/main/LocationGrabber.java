package main;

import java.util.ArrayList;
import designPattern.WeatherGrabber;

public class LocationGrabber {
	private ArrayList<WeatherGrabber> grabberList;
	
	public LocationGrabber(int size){
		grabberList = new ArrayList<WeatherGrabber>();
		for (int i = 0; i<size; i++){
			grabberList.add(null);
		}
	}
	
	public void addGrabber(int locationIndex, WeatherGrabber grabber){
		grabberList.set(locationIndex, grabber);
	}
	
	public void deleteGrabber(int locationIndex){
		grabberList.set(locationIndex, null);
	}
	
	public WeatherGrabber getGrabber(int locationIndex){
		WeatherGrabber returnGrabber = grabberList.get(locationIndex);
		return returnGrabber;
	}
}
