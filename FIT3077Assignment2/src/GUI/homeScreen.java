package GUI;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Checkbox;

public abstract class homeScreen {

	JFrame frmMelbourneWeather;
	JButton showButton = new JButton("");
	Checkbox rainCheckbox = new Checkbox("Rainfall");
	Checkbox tempCheckbox = new Checkbox("Temperature");
	JComboBox<Object> locationComboBox = new JComboBox<Object>();
	
	
	/*
	 * main method is included in the concrete class, not abstract class
	 * 
	 */
	/*
	 * Create the application.
	 * @throws Exception 
	 */
	public homeScreen() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() throws Exception {
		
		//main frame
		frmMelbourneWeather = new JFrame();
		frmMelbourneWeather.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setApplicationTitle();
		frmMelbourneWeather.setBounds(100, 100, 450, 300);
		frmMelbourneWeather.getContentPane().setLayout(null);
		
		//JComboBox
		locationComboBox.setBounds(117, 49, 147, 20);
		frmMelbourneWeather.getContentPane().add(locationComboBox);
		addLocationToComboBox();
		
		//tempCheckbox
		tempCheckbox.setBounds(141, 116, 95, 22);
		frmMelbourneWeather.getContentPane().add(tempCheckbox);
		
		//rainCheckbox
		rainCheckbox.setBounds(141, 161, 95, 22);
		frmMelbourneWeather.getContentPane().add(rainCheckbox);
		
		
		//showButton
		showButton.setText("Show Weather");
		
		  showButton.addActionListener(new ActionListener() {
		 
			public void actionPerformed(ActionEvent arg0) {
				showButtonClicked();
			}
			
		});
		showButton.setBounds(117, 227, 147, 23);
		frmMelbourneWeather.getContentPane().add(showButton);
		
		
		
	}
	
	//showButton action Listener
	public void showButtonClicked(){}
	
	//add location list to combo box
	public void addLocationToComboBox() throws Exception{}
	
	//set Application name
	public void setApplicationTitle(){}
}