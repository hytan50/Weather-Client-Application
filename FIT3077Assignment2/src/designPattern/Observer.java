package designPattern;

public interface Observer {
	//update the monitor for latest information
	public void update(String temperature, String rainfall, String timestamp);
}
