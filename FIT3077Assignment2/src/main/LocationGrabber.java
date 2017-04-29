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
	
	public void addGrabber(int locationIndex){
		if (grabberList.get(locationIndex) == null){
			WeatherGrabber grabber = new WeatherGrabber();
			grabberList.set(locationIndex, grabber);
		}
		else{
			System.out.println("Grabber existed.");
		}
	}
	
	public void deleteGrabber(int locationIndex){
		grabberList.set(locationIndex, null);
	}
	
	public WeatherGrabber getGrabber(int locationIndex){
		WeatherGrabber returnGrabber = grabberList.get(locationIndex);
		return returnGrabber;
	}
}
