package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.apache.axis2.AxisFault;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import GUI.monitor;
import testWeatherService.*;
import melbourneweather2.*;
import melbourneweather2.MelbourneWeather2Stub.GetLocationsResponse;

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
		frmMelbourneWeather.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelbourneWeather.setTitle("Melbourne Weather 2 Desktop Application");
		frmMelbourneWeather.setBounds(100, 100, 450, 300);
		frmMelbourneWeather.getContentPane().setLayout(null);
		
		JComboBox locationComboBox = new JComboBox(locationList);
		locationComboBox.setBounds(117, 49, 147, 20);
		frmMelbourneWeather.getContentPane().add(locationComboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selectedLocation = locationComboBox.getSelectedItem().toString();
				monitor Newmonitor = new monitor(selectedLocation);
				Newmonitor.main(selectedLocation);
			}
		});
		btnNewButton.setBounds(171, 227, 89, 23);
		frmMelbourneWeather.getContentPane().add(btnNewButton);
		
		
	}
}
