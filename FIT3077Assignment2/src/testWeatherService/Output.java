package testWeatherService;

public class Output {
	String locations;
	String rain1;
	String temp;
	String rain2;
	
	public Output(String w, String x, String y, String z){
		this.locations = w;
		this.rain1 = x;
		this.temp= y; 
		this.rain2 = z;
		
	}
	
	public String out(){
		return(
				locations
						+ " @ " + rain1
						+ ":\n\tTemperature:\t" + temp
						+ "\n\tRainfall:\t" + rain2
						+ "\n\n"
					);
	}

}
