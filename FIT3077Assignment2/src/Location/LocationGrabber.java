package Location;

import java.util.ArrayList;
import designPattern.WeatherGrabber;

public class LocationGrabber {
	//this class keep tracks of all grabber created
	
	private ArrayList<WeatherGrabber> grabberList;
	
	public LocationGrabber(int size){
		grabberList = new ArrayList<WeatherGrabber>();
		for (int i = 0; i<size; i++){
			grabberList.add(null);
		}
	}
	
	//add grabber to grabberList
	public void addGrabber(int locationIndex){
		if (grabberList.get(locationIndex) == null){
			WeatherGrabber grabber = new WeatherGrabber(this);
			grabberList.set(locationIndex, grabber);
		}
		else{
			System.out.println("Grabber existed.");
		}
	}
	
	//delete grabber from grabberList
	public void deleteGrabber(int locationIndex){
		grabberList.set(locationIndex, null);
		
		//the line below is used to check if the grabber at locationIndex is deleted
		//System.out.println(grabberList.get(locationIndex));
	}
	
	//get the grabber from grabberList
	public WeatherGrabber getGrabber(int locationIndex){
		WeatherGrabber returnGrabber = grabberList.get(locationIndex);
		return returnGrabber;
	}
	
	//get the grabber's index from grabberList 
	public int getGrabberIndex(WeatherGrabber grabber){
		//System.out.println(grabberList.indexOf(grabber));
		return grabberList.indexOf(grabber);
	}
}
