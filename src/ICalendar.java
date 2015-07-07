//Keegan Gladstone
//Main, Holds JavaFX interface
import javafx.scene.layout.FlowPane;
import javafx.application.Application;
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
	TextField eventSummary = new TextField("");
	//time settings for event
	TextField timeStart = new TextField("");
	TextField timeEnd = new TextField("");
	//date settings for event
	TextField dateStart = new TextField("");
	TextField dateEnd = new TextField("");
	//Location settings
	TextField location= new TextField("");
	
	//optional
	Label optional = new Label("Optional fields");
	//Latitude and Longitude coordinates (optional, must be supported)
	//Must be cast to a pair of float datatypes.
	TextField geoPosition = new TextField("");
	//Classification field (optional, must be supported)
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
		timeStart.setMaxWidth(Double.MAX_VALUE);
		timeEnd.setMaxWidth(Double.MAX_VALUE);
		dateStart.setMaxWidth(Double.MAX_VALUE);
		dateEnd.setMaxWidth(Double.MAX_VALUE);
		location.setMaxWidth(Double.MAX_VALUE);
		optional.setMaxWidth(Double.MAX_VALUE);
		geoPosition.setMaxWidth(Double.MAX_VALUE);
		classification.setMaxWidth(Double.MAX_VALUE);
		saveButton.setMaxWidth(Double.MAX_VALUE);
		
		VBox fieldsBox = new VBox();
		fieldsBox.setSpacing(5);
		fieldsBox.setPadding(new Insets(10, 10, 10, 20));
		fieldsBox.getChildren().addAll(eventSummary, timeStart, timeEnd, dateStart, dateEnd, location, optional, geoPosition, classification, saveButton);
		
		border.setLeft(fieldsBox);
		
		Scene scene = new Scene(border, 500, 500);
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
				String saveTimeStart = timeStart.getText();
				String saveTimeEnd = timeEnd.getText();
				String saveDateStart = dateStart.getText();
				String saveDateEnd = dateEnd.getText();
				String saveLocation = location.getText();
				String saveGeoPosition = geoPosition.getText();
				String saveClassification = classification.getText();
				
				//AFtering getting all the fields, throw them into the makeEvent method which writes the file
				//makeEvent will print to the console once the file is written for log.
				EventCreator.makeEvent(saveEventSummary, saveTimeStart, saveTimeEnd, saveDateStart, saveDateEnd, saveLocation, saveGeoPosition, saveClassification);
				
			}
		}
	}

}


/*// TODO Auto-generated method stub
Scanner input = new Scanner(System.in);

System.out.println("iCal .ics file creator \n");

//call to prompt user for new event
EventCreator.makeEvent();*/