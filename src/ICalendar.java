//TEAM ANDRASTE ICS314 ICALENDAR PROJECT
//Main, Holds JavaFX interface
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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


public class ICalendar extends Application {
	
	int startTime = 0;
	int endTime = 0;
	String timezoneCode = "";
	String dateStart = "";
	String hourStart = "";
	String minuteStart = "";
	String dateEnd  = "";
	String hourEnd = "";
	String minuteEnd = "";
	String saveTZID = "";
	String periodStartBoxText = "";
	String periodEndBoxText = "";
	
	List<EventFile> sortedEvents = new ArrayList<EventFile>();
	String sortedOrder = "";
	//application label
	Label label = new Label("Team Adrastea Event Application");
	
	//name of event
	Label labelEventSummary = new Label("Enter event title:");
	TextField eventSummary = new TextField();
	
	//Start time of event selector
	//TextField startTime = new TextField("");
	Label labelTimeStart = new Label("hours/minutes/Timezone");
	Label enterStartTime = new Label("Enter Start Time:");
	
	ChoiceBox<String> timeStartBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
	

	ChoiceBox<String> timeStartMinutesBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
			"23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
			"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"));
	
	
	ChoiceBox<String> periodStartBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"am","pm"));
	ChoiceBox<String> timezoneBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"UTC", "EDT","CDT","MDT","PDT","AKDT","HST"));
	
	
	//End time of event	selector
	Label enterEndTime = new Label("Enter End Time:");
	Label labelTimeEnd = new Label("hours/minutes");
	
	ChoiceBox<String> timeEndBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));
	ChoiceBox<String> periodEndBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"am","pm"));
	
	ChoiceBox<String> timeEndMinutesBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
			"23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
			"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"));
	
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
	ChoiceBox<String> classification = new ChoiceBox<String>(FXCollections.observableArrayList(
			"PUBLIC", "PRIVATE", "CONFIDENTIAL"));
	
	//TextField classification = new TextField("");

	//save button
	Button saveButton = new Button("save");
	Label errorLabel = new Label("");
	
	
	
	//Select folder with .ics files
	Label selectLabel = new Label("Enter complete folder path:                                    ");
	TextField userFolder = new TextField("Users/keegangladstone/Desktop/OurCalendarEvents/");
	Button selectButton = new Button("Grab Items from Folder");
	
	//may need to be static
	//static Label folderLabel = new Label("THIS IS THE folderLabel");
	Label sortLabel = new Label("Sorted Event Entries:");
	Label sortedLabel = new Label("");
	
	
	
	
	
	//Must leave blank. Only ICalendar.launch() can exist here
	public static void main(String[] args) {
		ICalendar.launch();
		
	}
	
	
	@Override
	public void start(Stage stage) {
		BorderPane border = new BorderPane();
		border.setTop(label);
		
		//Left Vbox (make event)
		eventSummary.setMaxWidth(Double.MAX_VALUE);
			eventSummary.setPromptText("event title");
		timeStartBox.setMaxWidth(Double.MAX_VALUE);
		timeStartBox.setValue("12");
		timeStartMinutesBox.setMaxWidth(Double.MAX_VALUE);
		timeStartMinutesBox.setValue("00");
			labelTimeStart.setMaxWidth(Double.MAX_VALUE);
		periodStartBox.setMaxWidth(Double.MAX_VALUE);
		periodStartBox.setValue("am");
		timezoneBox.setMaxWidth(Double.MAX_VALUE);
		timezoneBox.setValue("UTC");
		timeEndBox.setMaxWidth(Double.MAX_VALUE);
		timeEndBox.setValue("12");
		timeEndMinutesBox.setMaxWidth(Double.MAX_VALUE);
		timeEndMinutesBox.setValue("00");
		periodEndBox.setMaxWidth(Double.MAX_VALUE);
		periodEndBox.setValue("am");
			labelTimeEnd.setMaxWidth(Double.MAX_VALUE);
			
		monthStartBox.setMaxWidth(Double.MAX_VALUE);
		monthStartBox.setValue("01");
		dayStartBox.setMaxWidth(Double.MAX_VALUE);
		dayStartBox.setValue("01");
		startYear.setMaxWidth(Double.MAX_VALUE);
		startYear.setText("2015");
		monthEndBox.setMaxWidth(Double.MAX_VALUE);
		monthEndBox.setValue("01");
		dayEndBox.setMaxWidth(Double.MAX_VALUE);
		dayEndBox.setValue("01");
		endYear.setMaxWidth(Double.MAX_VALUE);
		endYear.setText("2015");
		location.setMaxWidth(Double.MAX_VALUE);
			location.setPromptText("location");
		optional.setMaxWidth(Double.MAX_VALUE);
		geoPosition.setMaxWidth(Double.MAX_VALUE);
			geoPosition.setPromptText("Latitude;Longitude");
		classification.setMaxWidth(Double.MAX_VALUE);
			classification.getSelectionModel().selectFirst();
		saveButton.setMaxWidth(Double.MAX_VALUE);
		
		//selectBox
		selectLabel.setMaxWidth(Double.MAX_VALUE);
		//folderLabel.setMaxWidth(Double.MAX_VALUE); 
		selectButton.setMaxWidth(Double.MAX_VALUE);
		sortedLabel.setMaxWidth(Double.MAX_VALUE);
		sortLabel.setMaxWidth(Double.MAX_VALUE);
		userFolder.setMaxWidth(Double.MAX_VALUE);
		

		
		
		//Dropdowns for start time selector
		HBox startTimeBox = new HBox();
		startTimeBox.getChildren().addAll(timeStartBox, timeStartMinutesBox, periodStartBox, timezoneBox);
		
		
		//dropdowns for end time selector
				HBox endTimeBox = new HBox();
				endTimeBox.getChildren().addAll(timeEndBox, timeEndMinutesBox, periodEndBox);
		
				
		//Dropdowns for start date selector
		HBox startDateBox = new HBox();
		startDateBox.getChildren().addAll(monthStartBox, dayStartBox, startYear);
		
		//dropdowns for end date selector
		HBox endDateBox = new HBox();
		endDateBox.getChildren().addAll(monthEndBox, dayEndBox, endYear);
		
		
		
		VBox fieldsBox = new VBox();
		fieldsBox.setSpacing(5);
		fieldsBox.setPadding(new Insets(10, 10, 10, 10));
		fieldsBox.getChildren().addAll(labelEventSummary, eventSummary,
									 enterStartTime, labelTimeStart, startTimeBox,
									 labelTimeEnd, endTimeBox,
									labelDateStart, startDateBox,
									labelDateEnd, endDateBox, 
									labelLocation, location,
									optional, 
									labelGeoPosition, geoPosition,
									labelClassification, classification, 
									saveButton, errorLabel);
		
		

		
		//left Vbox (sort events)
		VBox selectBox = new VBox();
		selectBox.setSpacing(5);
		selectBox.setPadding(new Insets(10, 10, 10, 10));
		selectBox.getChildren().addAll(selectLabel, userFolder,selectButton, sortLabel, sortedLabel);
		
		
		HBox mainHBox = new HBox();
		selectBox.setSpacing(5);
		selectBox.setPadding(new Insets(10, 10, 10, 10));
		mainHBox.getChildren().addAll(fieldsBox, selectBox);
		
		
		border.setLeft(mainHBox);

		
		Scene scene = new Scene(border, 800, 600);
		scene.setFill(Color.LIGHTGREY);
		stage.setTitle("ICS314 iCalendar Event Creator");
		saveButton.setOnAction(new SaveButtonHandler());
		selectButton.setOnAction(new SelectButtonHandler());
		stage.setScene(scene);
		stage.show();
		
	}
	
	/*BUTTON HANDLER, when "save" is pressed, this gathers all of the data in the fields
	 runs the converter methods below, and calls the makeEvent method which writes it all to the file*/
	private class SaveButtonHandler implements EventHandler<ActionEvent> {
		public void handle (ActionEvent ae) {
			if (ae.getSource() == saveButton) {
				timezoneCode = timezoneBox.getValue();
				saveTZID = timezoneConverter(timezoneCode);
				 dateStart = startYear.getText() +monthStartBox.getValue() +dayStartBox.getValue(); 
				 hourStart = timeStartBox.getValue();
				 minuteStart = timeStartMinutesBox.getValue();
				 dateEnd = endYear.getText() +monthEndBox.getValue() +dayEndBox.getValue(); 
				 hourEnd = timeEndBox.getValue();
				 minuteEnd = timeEndMinutesBox.getValue();
				 periodStartBoxText = periodStartBox.getValue();
				 periodEndBoxText = periodEndBox.getValue();
				
				
				
				String saveEventSummary = eventSummary.getText();
				String saveTimeStart = StartTimeConverter(saveTZID, dateStart, hourStart, minuteStart, periodStartBoxText);
				String saveTimeEnd = EndTimeConverter(saveTZID, dateEnd, hourEnd, minuteEnd, periodEndBoxText);
				String saveLocation = location.getText();
				String saveGeoPosition = geoPosition.getText();
				String saveClassification = classification.getValue();
		
				if(timeCheck(startTime, endTime) == true) {
					errorLabel.setText("ERROR! please make sure the end Time is after the start Time.");
		
				}
				else {
					errorLabel.setText("No Errors.");
				EventCreator.makeEvent(saveEventSummary, saveTimeStart, saveTimeEnd, saveLocation, saveGeoPosition, saveClassification);
				}
			}
		}
	}
	
	private class SelectButtonHandler implements EventHandler<ActionEvent> {
		public void handle (ActionEvent ae) {
			if (ae.getSource() == selectButton) {

				//SelectedFolder.chooser()
				System.out.println("Select Button Pressed");

				try {
					sortedEvents = SelectedFolder.Chooser(userFolder.getText());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Chooser ran!");
				System.out.println("Sorted List Entries:");
				sortedOrder = "";
				for(EventFile e: sortedEvents) {
					
					
					
					if(e.comment == null) {
						sortedOrder += (e.getEventSummary() + " at " + e.getEventStartTime() + "\n");
					}
					
					else {
						sortedOrder += (e.getEventSummary() + " at " + e.getEventStartTime()+ " and is "+ e.comment + " miles away from next event.\n");
					}

				}	
					//sets the label on the GUI.
					sortedLabel.setText(sortedOrder);
					

				//set folderLabel to directory path (helps to store the path in a string format so we can use getText()
				//send folder path to eventSorter, which will read in all of the files and do the sort work. 
			}
		}
	}
	
	public static boolean timeCheck(int startTime, int endTime){
		if(startTime > endTime) {
			return true;
		}
		else return false;
	}
	
	//converts start time to DTSTART format
	public static String StartTimeConverter(String tzid, String day, String hour, String minute, String period) {
		String saveTZID = tzid;
		String dateStart = day;
		String hourStart = hour;
		String minuteStart = minute;
		String periodStartBox = period;
		 
		 
		if (periodStartBox == "pm" && hourStart == "12") {
			 System.out.println("Start hour Not Changed, stays " + hourStart);
		 } 
		else if (periodStartBox  == "pm") {
			 System.out.println("period start box if-statement entered.");
			 int intHour = Integer.parseInt(hourStart) + 12;
			 System.out.println("hour changed to" + intHour);
			 hourStart = Integer.toString(intHour);
		 }
		 
		 else if (periodStartBox == "am" && hourStart == "12" ) {
			 hourStart ="00";
		 }
		 
		 int startTime = Integer.parseInt(hourStart + minuteStart);
		 System.out.println("Start Time is: " +startTime);
		 String time = ("TZID="+ saveTZID + dateStart + "T" + hourStart + minuteStart + "00");
		 System.out.println(time);
			return time;
	}
	
	
	
	//converts end time to DTEND format
	public static String EndTimeConverter(String tzid, String day, String hour, String minute, String period) {
		String saveTZID = tzid;
		String dateEnd = day;
		 String hourEnd = hour;
		 String minuteEnd = minute;
		 String periodEndBox = period;
		 
		 
		 if (periodEndBox == "pm" && hourEnd == "12") {
			 System.out.println("End hour Not Changed, stays " + hourEnd);
		 }
		 else if (periodEndBox == "pm") {
			 System.out.println("period end box if-statement entered.");
			 int intHour = Integer.parseInt(hourEnd) + 12;
			 System.out.println("hour changed to" + intHour);
			 hourEnd = Integer.toString(intHour);
		 }
		 else if (periodEndBox == "am" && hourEnd == "12" ) {
			 hourEnd ="00";
		 }
		 
		 int endTime = Integer.parseInt(hourEnd + minuteEnd);
		 System.out.println("endTime is : " +endTime);
		 String time = ("TZID="+ saveTZID +dateEnd + "T" + hourEnd + minuteEnd + "00");
		 System.out.println(time);
			return time;
	}
	
	
	//Converts the timezone abreviation into the usable TZID string for the time formatted.
	public static String timezoneConverter(String timezone) {
		String timezoneCode = timezone;
		String tzid = null;
		
		switch (timezoneCode) {
			case "UTC": tzid = "Africa/Morocco:";
				break;
			case "EDT": tzid = "America/New_York:";
				break;
			case "CDT": tzid = "America/Kansas_City:";
				break;
			case "MDT": tzid = "America/Denver:";
				break;
			case "PDT": tzid = "America/Los_Angeles:";
				break;
			case "AKDT": tzid = "America/Fairbanks:";
				break;
			case "HST": tzid = "Pacific/Honolulu:";
				break;
		}
		
		System.out.println(tzid);
		return tzid;
	}
}
