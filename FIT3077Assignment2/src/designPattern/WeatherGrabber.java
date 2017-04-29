package designPattern;

import java.util.ArrayList;

public class WeatherGrabber implements Subject{
	
	private ArrayList<Observer> observers;
	private float temperature;
	private float rainfall;
	
	public WeatherGrabber(){
		
		observers = new ArrayList<Observer>();
		
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
		System.out.println(deleteObserver +" at index " + indexObserver +" is deleted.");
		
	}

	@Override
	public void notifyObserver() {
		//tell the observer to update the information
		for (Observer observer :observers){
			observer.update(temperature, rainfall);
		}
	}
	
	public void setTemperature(float latestTemperature){
		this.temperature = latestTemperature;
		notifyObserver();
	}
	
	public void setRainfall(float latestRainfall){
		this.rainfall = latestRainfall;
		notifyObserver();
	}
	
}
