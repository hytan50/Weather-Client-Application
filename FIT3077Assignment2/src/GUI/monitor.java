package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import testWeatherService.TestWeatherService;
import java.awt.Font;

public class monitor {

	private JFrame frmMelborneWeather;
	static JLabel tempLabel = new JLabel("Temperature: ");
	static JLabel rainlabel = new JLabel("Rainfall:    ");
	
	
	
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
		
		TestWeatherService getWeatherData = new TestWeatherService();
		
		if (tempCheckboxState){
			try {
				tempLabel.setVisible(true);
				String currTemp = getWeatherData.getTemp(locationIndex);
				tempLabel.setText("Temperature :  " + currTemp);
				
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
				rainlabel.setVisible(true);
				String currRainfall = getWeatherData.getRain(locationIndex);
				 rainlabel.setText("Rainfall            :  " + currRainfall);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			rainlabel.setVisible(false);
		}
	}
	
	public void tempChange(){
		
	}

}
