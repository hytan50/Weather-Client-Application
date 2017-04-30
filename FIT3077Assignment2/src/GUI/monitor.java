package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public abstract class monitor {
	 boolean tempCheckboxState;
	 boolean rainCheckboxState;
	 JFrame frmMelbourneWeather;
	 JLabel tempLabel = new JLabel("Temperature: ");
	 JLabel rainlabel = new JLabel("Rainfall:  ");
	 JLabel lblTimestamp = new JLabel("TimeStamp:  ");
	public monitor(String locationName, int locationIndex, boolean tempCheckboxState, boolean rainCheckboxState) {
		initialize(locationName, locationIndex, tempCheckboxState, rainCheckboxState);
	}
	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize(String locationName, int locationIndex, boolean tempCheckboxState, boolean rainCheckboxState) {
		this.tempCheckboxState = tempCheckboxState;
		this.rainCheckboxState = rainCheckboxState;
		frmMelbourneWeather = new JFrame();
		frmMelbourneWeather.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				closeMonitor();
			}
		});
		setMonitorTitle(locationName);
		
		frmMelbourneWeather.setBounds(100, 100, 450, 300);
		frmMelbourneWeather.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMelbourneWeather.getContentPane().setLayout(null);
		
		JLabel labelLocationName = new JLabel(locationName);
		labelLocationName.setBounds(30, 30, 434, 30);
		labelLocationName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmMelbourneWeather.getContentPane().add(labelLocationName);
		
		tempLabel.setBounds(42, 94, 200, 14);
		frmMelbourneWeather.getContentPane().add(tempLabel);
		
		rainlabel.setBounds(42, 146, 200, 14);
		frmMelbourneWeather.getContentPane().add(rainlabel);
		
		lblTimestamp.setBounds(43, 194, 300, 16);
		frmMelbourneWeather.getContentPane().add(lblTimestamp);
	}
	
	public void updateData(){}
	
	public void setMonitorTitle(String locationName) {}
	
	public void closeMonitor(){}
}