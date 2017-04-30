package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;
import designPattern.WeatherObserver;
import main.LocationGrabber;
import testWeatherService.TestWeatherService;

public class concreteMelbourneMonitor extends monitor{
	int delay = 1000;
	String dateString=null;
	int locationIndex;
	String timeString=null;
	String currTemperature; 
	String currRainfall; 
	String currTimestamp;
	private WeatherObserver observer;
	public concreteMelbourneMonitor(LocationGrabber locationGrabber, String locationName, int locationIndex, boolean tempCheckboxState,
			boolean rainCheckboxState) {		
		super(locationName, locationIndex, tempCheckboxState, rainCheckboxState);
		// TODO Auto-generated constructor stub
		this.locationIndex= locationIndex;
		this.observer = new WeatherObserver(locationGrabber.getGrabber(locationIndex));
	}
		@Override
		public void setMonitorTitle(String locationName){
		frmMelbourneWeather.setTitle("Melbourne Weather 2 - " + locationName);
		}
		@Override
		public void updateData(){
			TestWeatherService getWeatherData = new TestWeatherService();
			try {
				currTimestamp= getWeatherData.getTime(locationIndex);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				currTemperature= getWeatherData.getTemp(locationIndex);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				currRainfall= getWeatherData.getRain(locationIndex);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			String[] splited = currTimestamp.split("\\s+");
		    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		    Date date=null;
			try {
				date = format1.parse(splited[0]);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    DateFormat format2 = new SimpleDateFormat("dd MMMM yyyy");
		    dateString = format2.format(date);
		    timeString = splited[1];
            lblTimestamp.setText("TimeStamp:  "  +timeString+"     "+dateString);
            if(tempCheckboxState){
            	tempLabel.setVisible(true);
            	tempLabel.setText("Temperature :  " +currTemperature);
            }
            else
            	tempLabel.setVisible(false);
            if(rainCheckboxState){
            	rainlabel.setVisible(true);
            	rainlabel.setText("Rainfall:  " +currRainfall);
            }
            else
            	rainlabel.setVisible(false);
			try {
				
				final Timer timer = new Timer(delay, null);
				timer.setDelay(delay); 
				timer.setRepeats(true); 
	              timer.addActionListener(new ActionListener() {
						
	                  public void actionPerformed(ActionEvent evt){
	                	  String currTimestamp;
	                	  frmMelbourneWeather.addWindowListener(new WindowAdapter() {
	                          public void windowClosing(WindowEvent ev) {  //stop when user closes frame  
	                        	  frmMelbourneWeather.dispose();                        	  
	                        	  timer.stop();
	                          }
	                      });
	                        try {
	                        	currTimestamp= getWeatherData.getTime(locationIndex);
								String[] splited = currTimestamp.split("\\s+");
							    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
							    Date date = format1.parse(splited[0]);
							    DateFormat format2 = new SimpleDateFormat("dd MMMM yyyy");
							    dateString = format2.format(date);
							    timeString = splited[1];
	                        } catch (Exception e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                        lblTimestamp.setText("TimeStamp:  "  +timeString+"     "+dateString);
	                        if(tempCheckboxState){
	                        	tempLabel.setVisible(true);
	                        	try {
									tempLabel.setText("Temperature :  " +getWeatherData.getTemp(locationIndex));
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	                        }
	                        else
	                        	tempLabel.setVisible(false);
	                        if(rainCheckboxState){
	                        	rainlabel.setVisible(true);
	                        	try {
									rainlabel.setText("Rainfall:  " +getWeatherData.getRain(locationIndex));
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	                        }
	                        else
	                        	rainlabel.setVisible(false);
	                  }
	              });
				              
				 timer.start();  	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}