package designPattern;

public class WeatherObserver implements Observer{
	
	@SuppressWarnings("unused")
	private String temperature;
	@SuppressWarnings("unused")
	private String rainfall;
	@SuppressWarnings("unused")
	private String time;
	public Subject weatherGrabber;
	
	@SuppressWarnings("unused")
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
		
		if(timestamp != null){
			String time = timestamp;
			this.time = time;
		}
	}
}