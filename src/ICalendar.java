//TEAM ANDRASTE ICS314 ICALENDAR PROJECT
//Main, Holds JavaFX interface
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JFileChooser;
import javax.swing.JSeparator;

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
	
	List<EventFile> sortedEvents = new ArrayList<EventFile>();
	String sortedOrder = "";
	//application label
	Label label = new Label("Team Adrastea Event Application");
	
	//name of event
	Label labelEventSummary = new Label("Enter event title:");
	TextField eventSummary = new TextField();
	
	//Start time of event selector
	TextField startTime = new TextField("");
	Label labelTimeStart = new Label("Enter 4-digit start time and select the period and the timezone");
	/*ChoiceBox timeStartBox = new ChoiceBox(FXCollections.observableArrayList(
			"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"));*/
	ChoiceBox<String> periodStartBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"am","pm"));
	ChoiceBox<String> timezoneBox = new ChoiceBox<String>(FXCollections.observableArrayList(
			"UTC", "EDT","CDT","MDT","PDT","AKDT","HST"));
	
	
	//End time of event	selector
	Label labelEndTime = new Label("Enter 4-digit end time and select the period");
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
	ChoiceBox<String> classification = new ChoiceBox<String>(FXCollections.observableArrayList(
			"PUBLIC", "PRIVATE", "CONFIDENTIAL"));
	
	//TextField classification = new TextField("");

	//save button
	Button saveButton = new Button("save");
	
	
	
	//Select folder with .ics files
	Label selectLabel = new Label("Enter complete folder path:");
	TextField userFolder = new TextField("Users/keegangladstone/Desktop/OurCalendarEvents/");
	Button selectButton = new Button("Grab Items from Folder                                                        ");
	Label folderLocationLabel = new Label("Folder location below:");
	static Label folderLabel = new Label("");
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
		startTime.setMaxWidth(Double.MAX_VALUE);
			startTime.setPromptText("0000");
		endTime.setMaxWidth(Double.MAX_VALUE);
			endTime.setPromptText("0000");
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
		folderLabel.setMaxWidth(Double.MAX_VALUE); 
		selectButton.setMaxWidth(Double.MAX_VALUE);
		sortedLabel.setMaxWidth(Double.MAX_VALUE);
		sortLabel.setMaxWidth(Double.MAX_VALUE);
		userFolder.setMaxWidth(Double.MAX_VALUE);
		

		
		
		//Dropdowns for start time selector
		HBox startTimeBox = new HBox();
		startTimeBox.getChildren().addAll(startTime, periodStartBox, timezoneBox);
		
		
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
		fieldsBox.setPadding(new Insets(10, 10, 10, 10));
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
		
		
		//left Vbox (sort events)
		
		
		VBox selectBox = new VBox();
		selectBox.setSpacing(5);
		selectBox.setPadding(new Insets(10, 10, 10, 10));
		selectBox.getChildren().addAll(selectLabel, userFolder,selectButton, folderLocationLabel, folderLabel, sortLabel, sortedLabel);
		
		
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
				//if saveButton is pressed call the EventCreator method, which will write the file
				String saveEventSummary = eventSummary.getText();
				String saveTimeStart = StartTimeConverter();
				String saveTimeEnd = EndTimeConverter();
				String saveLocation = location.getText();
				String saveGeoPosition = geoPosition.getText();
				String saveClassification = classification.getValue();
				

				
				
				//AFtering getting all the fields, throw them into the makeEvent method which writes the file
				//makeEvent will print to the console once the file is written for log.
				EventCreator.makeEvent(saveEventSummary, saveTimeStart, saveTimeEnd, saveLocation, saveGeoPosition, saveClassification);
				
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
						String formattedDistance = String.format(e.comment, 2);
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
	
	//converts start time to DTSTART format
	private String StartTimeConverter() {
		String saveTZID = timezoneConverter();
		 String date = startYear.getText() + (String) monthStartBox.getValue() + (String) dayStartBox.getValue(); 
		 String hour = startTime.getText();
		 
		 if (periodStartBox.getValue() == "pm") {
			 System.out.println("period start box if-statement entered.");
			 int intHour = Integer.parseInt(hour) + 1200;
			 System.out.println("hour changed to" + intHour);
			 hour = Integer.toString(intHour);
		 }
		 	
		 String time = ("TZID="+ saveTZID + date + "T" + hour + "00");
		 System.out.println(time);
			return time;
	}
	
	
	
	//converts end time to DTEND format
	private String EndTimeConverter() {
		String saveTZID = timezoneConverter();
		String date = endYear.getText() + (String) monthEndBox.getValue() + (String) dayEndBox.getValue(); 
		 String hour = endTime.getText();
		 
		 if (periodEndBox.getValue() == "pm") {
			 System.out.println("period end box if-statement entered.");
			 int intHour = Integer.parseInt(hour) + 1200;
			 System.out.println("hour changed to" + intHour);
			 hour = Integer.toString(intHour);
		 }
		 String time = ("TZID="+ saveTZID +date + "T" + hour + "00");
		 System.out.println(time);
			return time;
	}
	
	
	//Converts the timezone abreviation into the usable TZID string for the time formatted.
	private String timezoneConverter() {
		String timezoneCode = (String) timezoneBox.getValue();
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


/*// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);

System.out.println("iCal .ics file creator \n");

//call to prompt user for new event
EventCreator.makeEvent();*/