import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;




//file selector method for when the "select" button is pressed
public class SelectedFolder {

	String[] files;
	int n = 0;
	static List<EventFile> events = new ArrayList<EventFile>();
	static String eventSummary;
	static String dtStartTime;
	String geo;
	static String latitude;
	static String longitude;
	static int startTime = 0;
	
	

	public static List<EventFile> Chooser(String folderPath) throws FileNotFoundException {
		
		//grabs all files in the folder
		String userHomeFolder = System.getProperty("user.home");
		System.out.println("line27 " + folderPath);
		ICalendar.folderLabel.setText(folderPath);
	
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
				                	String[] latAndLong = latLong.split(";");
				                	latitude = latAndLong[0];
				                	longitude = latAndLong[1];
				                	System.out.println(latitude + " " + longitude);
			                	}
			                }
			            }
			            scanner.close();
	 
			        } catch (FileNotFoundException e) {
			            e.printStackTrace();
			        }
				 EventFile myEvent = new EventFile(eventSummary, dtStartTime, latitude, longitude );
				 events.add(myEvent);

			 }			 
			 Collections.sort(events,new startTimeComp());
			 
			 return events;
	}

}

//Author  java2novice.com
class startTimeComp implements Comparator<EventFile> {
	@Override
	public int compare(EventFile e1, EventFile e2) {
		if(e1.getEventStartTime() > e2.getEventStartTime()) {
			return 1;
		
		}
		else return -1;
		
	}
}
