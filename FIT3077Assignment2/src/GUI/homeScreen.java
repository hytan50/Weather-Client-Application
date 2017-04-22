package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import GUI.monitor;
import melbourneweather2.*;
import melbourneweather2.MelbourneWeather2Stub.GetLocationsResponse;
import java.awt.Checkbox;

public class homeScreen {

	private JFrame frmMelbourneWeather;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeScreen window = new homeScreen();
					window.frmMelbourneWeather.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public homeScreen() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		
		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		
		String[] locationList = LocationsResponse.get_return();
		frmMelbourneWeather = new JFrame();
		frmMelbourneWeather.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMelbourneWeather.setTitle("Melbourne Weather 2 Desktop Application");
		frmMelbourneWeather.setBounds(100, 100, 450, 300);
		frmMelbourneWeather.getContentPane().setLayout(null);
		
		JComboBox locationComboBox = new JComboBox(locationList);
		locationComboBox.setBounds(117, 49, 147, 20);
		frmMelbourneWeather.getContentPane().add(locationComboBox);
		
		Checkbox tempCheckbox = new Checkbox("Temperature");
		tempCheckbox.setBounds(141, 116, 95, 22);
		frmMelbourneWeather.getContentPane().add(tempCheckbox);
		
		Checkbox rainCheckbox = new Checkbox("Rainfall");
		rainCheckbox.setBounds(141, 161, 95, 22);
		frmMelbourneWeather.getContentPane().add(rainCheckbox);
		
		
		JButton showButton = new JButton("Show Weather");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedLocation = locationComboBox.getSelectedItem().toString();
				int locationIndex = locationComboBox.getSelectedIndex();
				if(!rainCheckbox.getState() && !tempCheckbox.getState()){}
				else{
				monitor newMonitor = new monitor(selectedLocation, locationIndex, tempCheckbox.getState(), rainCheckbox.getState());
				newMonitor.frmMelborneWeather.setVisible(true);
				}
				
			}
		});
		showButton.setBounds(141, 227, 137, 23);
		frmMelbourneWeather.getContentPane().add(showButton);
		
		
		
	}
}