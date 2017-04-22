package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import testWeatherService.TestWeatherService;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class monitor {
	JFrame frmMelborneWeather;
	 JLabel tempLabel = new JLabel("Temperature: ");
	 JLabel rainlabel = new JLabel("Rainfall:  ");
	 JLabel lblTimestamp = new JLabel("TimeStamp:  ");
	/**
	 * Launch the application.
	 */
	public void main(String locationName, int locationIndex, boolean tempCheckboxState, boolean rainCheckboxState) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					monitor window = new monitor(locationName, locationIndex, tempCheckboxState, rainCheckboxState);
					window.frmMelborneWeather.setVisible(true);			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public monitor(String locationName, int locationIndex, boolean tempCheckboxState, boolean rainCheckboxState) {
		initialize(locationName, locationIndex, tempCheckboxState, rainCheckboxState);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String locationName, int locationIndex, boolean tempCheckboxState, boolean rainCheckboxState) {
		frmMelborneWeather = new JFrame();
		frmMelborneWeather.setTitle("Melborne Weather 2 - " + locationName);
		frmMelborneWeather.setBounds(100, 100, 450, 300);
		frmMelborneWeather.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMelborneWeather.getContentPane().setLayout(null);
		
		JLabel labelLocationName = new JLabel(locationName);
		labelLocationName.setBounds(30, 30, 434, 30);
		labelLocationName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmMelborneWeather.getContentPane().add(labelLocationName);
		
		tempLabel.setBounds(42, 94, 200, 14);
		frmMelborneWeather.getContentPane().add(tempLabel);
		
		rainlabel.setBounds(42, 146, 200, 14);
		frmMelborneWeather.getContentPane().add(rainlabel);
		
		lblTimestamp.setBounds(43, 194, 300, 16);
		frmMelborneWeather.getContentPane().add(lblTimestamp);
		
		TestWeatherService getWeatherData = new TestWeatherService();
		
		try {
			int delay = 300000;           //milliseconds 
			lblTimestamp.setText("timeStamp :  "+"Calculating...");
			final Timer timer = new Timer(delay, null);
			timer.setDelay(delay); 
			timer.setRepeats(true); 
              timer.addActionListener(new ActionListener() {
            	  String lbl=null;			//time stamp
					String dateString=null;
					String timeString=null;
                  public void actionPerformed(ActionEvent evt){

                	  frmMelborneWeather.addWindowListener(new WindowAdapter() {
                          public void windowClosing(WindowEvent ev) {  //stop when user closes frame  
                        	  frmMelborneWeather.dispose();
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
				int delay = 300000;           //milliseconds 
				tempLabel.setText("Temperature :  "+"Calculating...");
				final Timer timer = new Timer(delay, null);
				timer.setDelay(delay); 
				timer.setRepeats(true); 
	              timer.addActionListener(new ActionListener() {
	            	  String temp =null;
	                  public void actionPerformed(ActionEvent evt){
	
	                	  frmMelborneWeather.addWindowListener(new WindowAdapter() {
	                          public void windowClosing(WindowEvent ev) {  //stop when user closes frame  
	                        	  frmMelborneWeather.dispose();
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
			try {
				int delay = 300000;           //milliseconds    
				
				final Timer timer = new Timer(delay, null);
				rainlabel.setText("Rainfall:  " + "Calculating...");
				timer.setDelay(delay); 
				timer.setRepeats(true); 
	              timer.addActionListener(new ActionListener() {
	            	  String currRainfall = null;
	            	  
	                  public void actionPerformed(ActionEvent evt){
	
	                	  frmMelborneWeather.addWindowListener(new WindowAdapter() {
	                          public void windowClosing(WindowEvent ev) {  //stop when user closes frame  
	                        	  frmMelborneWeather.dispose();
	                        	  
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
}