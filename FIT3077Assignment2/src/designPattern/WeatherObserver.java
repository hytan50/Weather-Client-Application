package designPattern;

public class WeatherObserver implements Observer{
	
	private float temperature;
	private float rainfall;
	
	private Subject weatherGrabber;
	
	private int observerID;
	private static int observerIDTraker = 0;
	
	public WeatherObserver(Subject weatherGrabber){
		this.weatherGrabber = weatherGrabber;
		
		this.observerID = ++observerIDTraker;
		
		weatherGrabber.register(this);
	}
	
	@Override
	public void update(Float temperatureObject, Float rainfallObject) {
		
		if(temperatureObject != null){
			float temp = temperatureObject;
			this.temperature = temp;
		}
		
		if(rainfallObject != null){
			float rain = rainfallObject;
			this.rainfall = rain;
		}
		
	}
}