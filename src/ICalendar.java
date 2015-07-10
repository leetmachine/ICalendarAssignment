//TEAM ANDRASTE ICS314 ICALENDAR PROJECT
//Main, Holds JavaFX interface
import javafx.scene.layout.FlowPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.event.*;
import javafx.geometry.Pos;


public class ICalendar extends Application {
	
	//application label
	Label label = new Label("Team Andraste Event Application");
	
	//name of event
	Label labelEventSummary = new Label("Enter event title:");
	TextField eventSummary = new TextField();
	
	//Start time of event selector
	TextField startTime = new TextField("");
	Label labelTimeStart = new Label("Enter start time as hour and minute, select period");
	/*ChoiceBox timeStartBox = new ChoiceBox(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));*/
	ChoiceBox<String> periodStartBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"am","pm"));
	
	//End time of event	selector
	Label labelEndTime = new Label("Enter end time as hour and minute, select period");
	TextField endTime = new TextField("");
	/*ChoiceBox timeEndBox = new ChoiceBox(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));*/
	ChoiceBox<String> periodEndBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"am","pm"));
	
	//Start Date of event
	Label labelDateStart = new Label("Select start month and day, enter year");
	ChoiceBox<String> monthStartBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
	ChoiceBox<String> dayStartBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12","13","14","15","16","17","18","19","20",
			"21","22","23","24","25","26","27","28","29","30","31"));
	TextField startYear = new TextField();
	
	//End date of event
	Label labelDateEnd = new Label("Select end date month and day, enter year");
	ChoiceBox<String> monthEndBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
	ChoiceBox<String> dayEndBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12","13","14","15","16","17","18","19","20",
			"21","22","23","24","25","26","27","28","29","30","31"));
	TextField endYear = new TextField();
	
	//Location settings
	Label labelLocation = new Label("Enter Location:");
	TextField location= new TextField("");
	
	//optional
	Label optional = new Label("Optional fields");
	//Latitude and Longitude coordinates (optional, must be supported)
	//Must be cast to a pair of float datatypes.
	Label labelGeoPosition = new Label("enter Latitude, Longitude");
	TextField geoPosition = new TextField("");
	//Classification field (optional, must be supported)
	Label labelClassification = new Label("Select classification");
	TextField classification = new TextField("");

	//save button
	Button saveButton = new Button("save");
	
	//Must leave blank. Only ICalendar.launch() can exist here
	public static void main(String[] args) {
		ICalendar.launch();
		
	}
	
	
	@Override
	public void start(Stage stage) {
		BorderPane border = new BorderPane();
		border.setTop(label);
		
		eventSummary.setMaxWidth(Double.MAX_VALUE);
			eventSummary.setPromptText("event title");
		startTime.setMaxWidth(Double.MAX_VALUE);
			startTime.setPromptText("enter start time of event, hour/period");
		location.setMaxWidth(Double.MAX_VALUE);
			location.setPromptText("location");
		optional.setMaxWidth(Double.MAX_VALUE);
		geoPosition.setMaxWidth(Double.MAX_VALUE);
			geoPosition.setPromptText("enter coordinates as Latitude, Longitude");
		classification.setMaxWidth(Double.MAX_VALUE);
			classification.setPromptText("classification");
		saveButton.setMaxWidth(Double.MAX_VALUE);
		
		
		//Dropdowns for start time selector
		HBox startTimeBox = new HBox();
		startTimeBox.getChildren().addAll(startTime, periodStartBox);
		
		
		//dropdowns for end time selector
				HBox endTimeBox = new HBox();
				endTimeBox.getChildren().addAll(endTime, periodEndBox);
		
				
		//Dropdowns for start date selector
		HBox startDateBox = new HBox();
		startDateBox.getChildren().addAll(monthStartBox, dayStartBox, startYear);
		
		//dropdowns for end date selector
		HBox endDateBox = new HBox();
		endDateBox.getChildren().addAll(monthEndBox, dayEndBox, endYear);
		
		
		
		VBox fieldsBox = new VBox();
		fieldsBox.setSpacing(5);
		fieldsBox.setPadding(new Insets(10, 10, 10, 20));
		fieldsBox.getChildren().addAll(labelEventSummary, eventSummary,
									labelTimeStart, startTimeBox,
									labelEndTime, endTimeBox,
									labelDateStart, startDateBox,
									labelDateEnd, endDateBox, 
									labelLocation, location,
									optional, 
									labelGeoPosition, geoPosition,
									labelClassification, classification, 
									saveButton);
		
		
		border.setLeft(fieldsBox);
		
		Scene scene = new Scene(border, 600, 600);
		scene.setFill(Color.LIGHTGREY);
		stage.setTitle("ICS314 iCalendar Event Creator");
		saveButton.setOnAction(new ButtonHandler());
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	//BUTTON HANDLER, when "save" is pressed, this controls what happens.
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle (ActionEvent ae) {
			if (ae.getSource() == saveButton) {
				//if saveButton is pressed call the EventCreator method, which will write the file
				String saveEventSummary = eventSummary.getText();
				String saveTimeStart = StartTimeConverter();
				String saveTimeEnd = EndTimeConverter();
				String saveLocation = location.getText();
				String saveGeoPosition = geoPosition.getText();
				String saveClassification = classification.getText();
				

				
				
				//AFtering getting all the fields, throw them into the makeEvent method which writes the file
				//makeEvent will print to the console once the file is written for log.
				EventCreator.makeEvent(saveEventSummary, saveTimeStart, saveTimeEnd, saveLocation, saveGeoPosition, saveClassification);
				
			}
		}
	}
	
	//converts start time to DTSTART format
	private String StartTimeConverter() {
	 String date = startYear.getText() + (String) monthStartBox.getValue() + (String) dayStartBox.getValue(); 
	 String hour = startTime.getText();
	 String time = ("TZID=Pacific/Honolulu:" + date + "T" + hour + "00");
	 System.out.println(time);
		return time;
	}
	
	//converts end time to DTEND format
	private String EndTimeConverter() {
		String date = endYear.getText() + (String) monthEndBox.getValue() + (String) dayEndBox.getValue(); 
		 String hour = endTime.getText();
		 String time = ("TZID=Pacific/Honolulu:" +date + "T" + hour + "00");
		 System.out.println(time);
			return time;
	}
	

	
	
	

}


/*// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);

System.out.println("iCal .ics file creator \n");

//call to prompt user for new event
EventCreator.makeEvent();*/