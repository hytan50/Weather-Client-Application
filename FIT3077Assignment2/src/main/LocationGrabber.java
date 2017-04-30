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
			WeatherGrabber grabber = new WeatherGrabber(this);
			grabberList.set(locationIndex, grabber);
		}
		else{
			System.out.println("Grabber existed.");
		}
	}
	
	public void deleteGrabber(int locationIndex){
		grabberList.set(locationIndex, null);
		
		//the line below is used to check if the grabber at locationIndexis deleted
		//System.out.println(grabberList.get(locationIndex));
	}
	
	public WeatherGrabber getGrabber(int locationIndex){
		WeatherGrabber returnGrabber = grabberList.get(locationIndex);
		return returnGrabber;
	}
	
	public int getGrabberIndex(WeatherGrabber grabber){
		//System.out.println(grabberList.indexOf(grabber));
		return grabberList.indexOf(grabber);
	}
}
