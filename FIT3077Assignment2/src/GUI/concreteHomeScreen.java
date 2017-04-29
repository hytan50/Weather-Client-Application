package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class concreteHomeScreen extends homeScreen{

	private JFrame frmMelbourneWeather;
	
	public concreteHomeScreen() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homeScreen window = new concreteHomeScreen();
					window.frmMelbourneWeather.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
