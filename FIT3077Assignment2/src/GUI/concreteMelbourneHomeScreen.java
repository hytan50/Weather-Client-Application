package GUI;

import javax.swing.DefaultComboBoxModel;
import melbourneweather2.MelbourneWeather2Stub;
import melbourneweather2.MelbourneWeather2Stub.GetLocationsResponse;

public class concreteMelbourneHomeScreen extends homeScreen{

	
	public concreteMelbourneHomeScreen() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public void showButtonClicked(){
		
		String selectedLocation = locationComboBox.getSelectedItem().toString();
		int locationIndex = locationComboBox.getSelectedIndex();
		if(!rainCheckbox.getState() && !tempCheckbox.getState()){}
		else{
		monitor newMonitor = new concreteMelbourneMonitor(selectedLocation, locationIndex, tempCheckbox.getState(), rainCheckbox.getState());
		newMonitor.frmMelbourneWeather.setVisible(true);
		}
		 
	}
	
	
	@Override
	public void addLocationToComboBox() throws Exception{
		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		
		String[] locationList = LocationsResponse.get_return();
		final DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<Object>(locationList);
		locationComboBox.setModel(model);
	}
	
	@Override
	public void setApplicationTitle(){
		frmMelbourneWeather.setTitle("Melbourne Weather 2 Desktop Application");
	}

}
