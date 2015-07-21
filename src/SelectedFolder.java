import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.Scanner;




//file selector method for when the "select" button is pressed
public class SelectedFolder {

	String[] files;
	int n = 0;
	static EventFile[] events;
	static String eventSummary;
	static String dtStartTime;
	String geo;
	static String latitude;
	static String longitude;
	

	public static void Chooser() throws FileNotFoundException {
		
		//grabs all files in the folder
		String fileName;
		String userHomeFolder = System.getProperty("user.home");
		System.out.println("line27 " + userHomeFolder);
		ICalendar.folderLabel.setText(userHomeFolder+"/Desktop/OurCalendarEvents/");
	
			/* File folder = new File(userHomeFolder+"/Desktop/OurCalendarEvents/");
			// FileNameExtensionFilter filter = new FileNameExtensionFilter("ics", "text only");
			 File[] listOfFiles = folder.listFiles();*/
			 
			//taken from StackOverflow author "WhiteFang34"
			 File dir = new File(userHomeFolder+"/Desktop/OurCalendarEvents/");
			 File[] listOfFiles = dir.listFiles(new FilenameFilter() {
			     public boolean accept(File dir, String name) {
			         return name.toLowerCase().endsWith(".ics");
			     }
			 });
			 
			 
			 for(int i =0;i<listOfFiles.length;i++) {
				 try {
			            Scanner scanner = new Scanner(listOfFiles[i]);
			            while (scanner.hasNextLine()) {
			                String line = scanner.nextLine();
			                if (line.contains("SUMMARY:")) {
			                	System.out.println(line);
			                	String[] summaryParts = line.split(":");
			                	eventSummary = summaryParts[1];
			                	System.out.println(eventSummary);
			                }
			                if (line.contains("DTSTART;")) {
			                	System.out.println(line);
			                	String[] startParts = line.split(":");
			                	String startTime = startParts[1];
			                	System.out.println(startTime);
			                	String[] moreStartParts = startTime.split("T");
			                	 dtStartTime = moreStartParts[1];
			                	System.out.println(dtStartTime);
			                }
			                if (line.contains("GEO:")) {
			                	System.out.println(line);
			                	//handles exception for GEO: not existing
			                	if (line.length()>4) {
				                	String[] geoParts = line.split(":");
				                	String latLong = geoParts[1];
				                	String[] latAndLong = line.split(";");
				                	latitude = latAndLong[0];
				                	longitude = latAndLong[1];
				                	System.out.println(latitude + " " + longitude);
			                	}
			                }
			                
			                //events[i] = new EventFile(eventSummary, dtStartTime, latitude, longitude);
			                
			            }
			            scanner.close();
	 
			        } catch (FileNotFoundException e) {
			            e.printStackTrace();
			        }
			 }
			 
			 /*for(int i = 0; i< events.length;i++) {
				 System.out.println(events[i].getEventSummary());
			 }*/
			 
	}

}
