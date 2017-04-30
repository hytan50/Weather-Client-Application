package designPattern;

import java.util.ArrayList;

import Location.LocationGrabber;

public class WeatherGrabber implements Subject{
	
	private ArrayList<Observer> observers;
	private String temperature;
	private String rainfall;
	private String timestamp;
	private LocationGrabber locationGrabber;
	
	public WeatherGrabber(LocationGrabber grabberList){
		
		observers = new ArrayList<Observer>();
		this.locationGrabber = grabberList;
		
	}

	@Override
	public void register(Observer newObserver) {
		//add monitor that needs to observe
		observers.add(newObserver);
		
	}

	@Override
	public void unregister(Observer deleteObserver) {
		//close the monitor that needs to observe
		int indexObserver = observers.indexOf(deleteObserver);
		observers.remove(indexObserver);
		System.out.println(deleteObserver +" at index " + indexObserver +" is deleted.\n");
		if (observers.size() == 0){
			this.locationGrabber.deleteGrabber(this.locationGrabber.getGrabberIndex(this));
			//System.out.println("the grabber is empty, hence deleted.");
			//the line above is used to check if the grabber is deleted
		}
		
	}

	@Override
	public void notifyObserver() {
		//tell the observer to update the information
		for (Observer observer :observers){
			observer.update(temperature, rainfall, timestamp);
		}
	}
	
	public void setTemperature(String latestTemperature){
		this.temperature = latestTemperature;
		notifyObserver();
	}
	
	public void setRainfall(String latestRainfall){
		this.rainfall = latestRainfall;
		notifyObserver();
	}
	
	public void setTimeStamp(String latestTimestamp){
		this.timestamp = latestTimestamp;
		notifyObserver();
	}
	
}
