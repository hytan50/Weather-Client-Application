package GUI;
import javax.swing.DefaultComboBoxModel;
import main.LocationGrabber;
import melbourneweather2.MelbourneWeather2Stub;
import melbourneweather2.MelbourneWeather2Stub.GetLocationsResponse;

public class concreteMelbourneHomeScreen extends homeScreen{
	LocationGrabber locationGrabber;
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
			if (locationGrabber.getGrabber(locationIndex)==null){
				locationGrabber.addGrabber(locationIndex);
			}
			monitor newMonitor = new concreteMelbourneMonitor(locationGrabber, selectedLocation, locationIndex, tempCheckbox.getState(), rainCheckbox.getState());
			newMonitor.frmMelbourneWeather.setVisible(true);
			try {
				newMonitor.updateData();     //updates monitor's labels 5 minutes
          } catch (Exception e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
		}		 
	}

	@Override
	public void addLocationToComboBox() throws Exception{
		final MelbourneWeather2Stub MelbourneWeatherService = new MelbourneWeather2Stub();
		GetLocationsResponse LocationsResponse = MelbourneWeatherService.getLocations();
		String[] locationList = LocationsResponse.get_return();
		final DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<Object>(locationList);
		locationComboBox.setModel(model);	
		int locationSize = locationList.length;
		locationGrabber = new LocationGrabber(locationSize);
	}
	@Override
	public void setApplicationTitle(){
		frmMelbourneWeather.setTitle("Melbourne Weather 2 Desktop Application");
	}
}