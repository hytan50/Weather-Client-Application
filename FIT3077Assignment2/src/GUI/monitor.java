package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;

public class monitor {

	private JFrame frmMelborneWeather;
	/**
	 * Launch the application.
	 */
	public static void main(String locationName) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					monitor window = new monitor(locationName);
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
	public monitor(String locationName) {
		initialize(locationName);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String locationName) {
		frmMelborneWeather = new JFrame();
		frmMelborneWeather.setTitle("Melborne Weather 2 - " + locationName);
		frmMelborneWeather.setBounds(100, 100, 450, 300);
		frmMelborneWeather.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMelborneWeather.getContentPane().setLayout(null);
		
		JLabel labelLocationName = new JLabel(locationName);
		labelLocationName.setBounds(30, 30, 434, 30);
		labelLocationName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmMelborneWeather.getContentPane().add(labelLocationName);
		
	}

}
