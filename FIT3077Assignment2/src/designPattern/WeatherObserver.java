package designPattern;

public class WeatherObserver implements Observer{
	
	private String temperature;
	private String rainfall;
	
	private Subject weatherGrabber;
	
	private int observerID;
	private static int observerIDTraker = 0;
	
	public WeatherObserver(Subject weatherGrabber){
		this.weatherGrabber = weatherGrabber;
		
		this.observerID = ++observerIDTraker;
		
		weatherGrabber.register(this);
	}
	
	@Override
	public void update(String temperatureObject, String rainfallObject, String timestamp) {
		
		if(temperatureObject != null){
			String temp = temperatureObject;
			this.temperature = temp;
		}
		
		if(rainfallObject != null){
			String rain = rainfallObject;
			this.rainfall = rain;
		}
		
	}
}