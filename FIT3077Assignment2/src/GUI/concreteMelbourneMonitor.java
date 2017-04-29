package GUI;
import java.awt.EventQueue;

import designPattern.WeatherObserver;
import main.LocationGrabber;

public class concreteMelbourneMonitor extends monitor{
	private WeatherObserver observer;
	
	public concreteMelbourneMonitor(LocationGrabber locationGrabber, String locationName, int locationIndex, boolean tempCheckboxState,
			boolean rainCheckboxState) {
		
		super(locationName, locationIndex, tempCheckboxState, rainCheckboxState);
		// TODO Auto-generated constructor stub
		this.observer = new WeatherObserver(locationGrabber.getGrabber(locationIndex));
		
		
	}
	/*
	public void main(String locationName, int locationIndex, boolean tempCheckboxState, boolean rainCheckboxState) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					monitor window = new concreteMelbourneMonitor(locationName, locationIndex, tempCheckboxState, rainCheckboxState);
					window.frmMelbourneWeather.setVisible(true);			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/*
	public void calculate(int locationIndex,boolean tempCheckboxState, boolean rainCheckboxState){
			
			TestWeatherService getWeatherData = new TestWeatherService();
			
			try {
				String lbl=null;			//gets and sets a time stamp for the timeStamp label
				String dateString=null;
				String timeString=null;
				lbl = getWeatherData.getTime(locationIndex);
				String[] splited = lbl.split("\\s+");
			    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
			    Date date = format1.parse(splited[0]);
			    DateFormat format2 = new SimpleDateFormat("dd MMMM, yyyy");
			    dateString = format2.format(date);
			    timeString = splited[1];
	            lblTimestamp.setText("TimeStamp:  " + timeString+"      "+dateString);
				final Timer timer = new Timer(delay, null);
				timer.setDelay(delay); 
				timer.setRepeats(true); 
	              timer.addActionListener(new ActionListener() {
	            	  String lbl=null;			//time stamp
						String dateString=null;
						String timeString=null;
	                  public void actionPerformed(ActionEvent evt){
	
	                	  frmMelbourneWeather.addWindowListener(new WindowAdapter() {
	                          public void windowClosing(WindowEvent ev) {  //stop when user closes frame  
	                        	  frmMelbourneWeather.dispose();
	                        	  timer.stop();
	                          }
	                      });
	                	  lblTimestamp.setVisible(true);
	                        try {
	                            lbl = getWeatherData.getTime(locationIndex);
								String[] splited = lbl.split("\\s+");
							    DateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
							    Date date = format1.parse(splited[0]);
							    DateFormat format2 = new SimpleDateFormat("dd MMMM, yyyy");
							    dateString = format2.format(date);
							    timeString = splited[1];
	                        } catch (Exception e) {
	                            // TODO Auto-generated catch block
	                            e.printStackTrace();
	                        }
	                        lblTimestamp.setText("TimeStamp:  " + timeString+"      "+dateString);
	                  }
	              });
				              
				 timer.start();  	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (tempCheckboxState){
				try {
					String temp =null;				//this all sets the temperature for the temperature label
					temp = getWeatherData.getTemp(locationIndex);
					tempLabel.setText("Temperature :  "+temp);
					final Timer timer = new Timer(delay, null);
					timer.setDelay(delay); 
					timer.setRepeats(true); 
		              timer.addActionListener(new ActionListener() {
		            	  String temp =null;
		                  public void actionPerformed(ActionEvent evt){
		
		                	  frmMelbourneWeather.addWindowListener(new WindowAdapter() {
		                          public void windowClosing(WindowEvent ev) {  //stop when user closes frame  
		                        	  frmMelbourneWeather.dispose();
		                        	  timer.stop();
		                          }
		                      });
		                	  tempLabel.setVisible(true);
		                        try {
		                            temp = getWeatherData.getTemp(locationIndex);
		                        } catch (Exception e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                        tempLabel.setText("Temperature :  " + temp);
		                  }
		              });
					              
					 timer.start();  	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				tempLabel.setVisible(false);
			}
			if (rainCheckboxState){
				try { 	//this sets the rainfall information for the label
					final Timer timer = new Timer(delay, null);
					String currRainfall = null;
					currRainfall = getWeatherData.getRain(locationIndex);
					rainlabel.setText("Rainfall:  " + currRainfall);
					timer.setDelay(delay); 
					timer.setRepeats(true); 
		              timer.addActionListener(new ActionListener() {
		            	  String currRainfall = null;
		            	  
		                  public void actionPerformed(ActionEvent evt){
		
		                	  frmMelbourneWeather.addWindowListener(new WindowAdapter() {
		                          public void windowClosing(WindowEvent ev) {  //stop when user closes frame  
		                        	  frmMelbourneWeather.dispose();
		                        	  
		                        	  timer.stop();
		                          }
		                      });
		                	  rainlabel.setVisible(true);
		                        try {
		                        	currRainfall = getWeatherData.getRain(locationIndex);
		                        } catch (Exception e) {
		                            // TODO Auto-generated catch block
		                            e.printStackTrace();
		                        }
		                        rainlabel.setText("Rainfall:  " + currRainfall);
		                  }
		              });              
					 timer.start();  
	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				rainlabel.setVisible(false);
			}
		}
		*/
		@Override
		public void setMonitorTitle(String locationName){
		frmMelbourneWeather.setTitle("Melbourne Weather 2 - " + locationName);
		}
		
	}