import java.io.*;

//Keegan Gladstone
//Class for prompting user for information to create the .ics file.

public class EventCreator {
	



//method for prompting user for information for new event
	//NOTE: geoPosition and Classification are optional fields that may be passed in as "". Must handle with and IF statement.
public static void makeEvent(String eventSummary, String timeStart, String timeEnd, String location, String geoPosition, String classification) {
	
	//writes new file to user home folder, on mac this is HD/Users/"username"
	try {
		String filename = (eventSummary +".ics");
		System.out.println(filename);
		String userHomeFolder = System.getProperty("user.home");
		File icsFile = new File(userHomeFolder, filename);
		FileWriter fileWriter = new FileWriter(icsFile);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		//Write to file
		bufferedWriter.write("BEGIN:VCALENDAR\n");
		bufferedWriter.write("VERSION:2.0\n");
		bufferedWriter.write("CALSCALE:GREGORIAN\n");
		bufferedWriter.write("BEGIN:VEVENT\n");
		bufferedWriter.write("CREATED:20150705T234637Z\n");
		bufferedWriter.write("DTEND;" + timeEnd + "\n");
		bufferedWriter.write("TRANSP:OPAQUE\n");
		bufferedWriter.write("SUMMARY:" + eventSummary  +"\n");
		bufferedWriter.write("CLASS:" + classification +"\n");
		bufferedWriter.write("DTSTART;"+ timeStart + "\n");
		bufferedWriter.write("LOCATION:" + location + "\n");
		
		//check for geoPosition text
		if (geoPosition != "") {
				bufferedWriter.write("GEO:"+ geoPosition + "\n");	
		}
		
		bufferedWriter.write("DESCRIPTION:\n");
		bufferedWriter.write("END:VEVENT\n");
		bufferedWriter.write("END:VCALENDAR\n");
		
		
		
		bufferedWriter.close();
		System.out.println("File Saved.");
		System.out.println(icsFile.getAbsolutePath());
		
	} catch (IOException e) {
		System.out.println("Error Writing to file newEvent.ics");
		e.printStackTrace();
	}
		
	
}



}


/*WORKING DRAG AND DROP CODE. Remove all other, place into try block.
bufferedWriter.write("BEGIN:VCALENDAR\n");
bufferedWriter.write("VERSION:2.0\n");
bufferedWriter.write("CALSCALE:GREGORIAN\n");
bufferedWriter.write("BEGIN:VTIMEMODE\n");
bufferedWriter.write("TZID:Pacific/Honolulu\n");
bufferedWriter.write("BEGIN:DAYLIGHT\n");
bufferedWriter.write("TZOFFSETFROM:-1030\n");
bufferedWriter.write("DTSTART:19330430T020000\n");
bufferedWriter.write("TZNAME:HDT\n");
bufferedWriter.write("TZOFFSETTO:-930\n");
bufferedWriter.write("RDATE:19330430T020000\n");
bufferedWriter.write("RDATE:19420209T020000\n");
bufferedWriter.write("END:DAYLIGHT\n");
bufferedWriter.write("BEGIN:STANDARD\n");
bufferedWriter.write("TZOFFSETFROM:-1030\n");
bufferedWriter.write("DTSTART:19470608T020000\n");
bufferedWriter.write("TZNAME:HST\n");
bufferedWriter.write("TZOFFSETTO:-1000\n");
bufferedWriter.write("RDATE:19470608T020000\n");
bufferedWriter.write("END:STANDARD\n");
bufferedWriter.write("END:VTIMEMODE\n");
bufferedWriter.write("BEGIN:VEVENT\n");
bufferedWriter.write("CREATED:20150705T234637Z\n");
bufferedWriter.write("UID:80764A07-220B-4CA1-93DE-D4D4352A87E6\n");
bufferedWriter.write("DTEND;TZID=Pacific/Honolulu:20150705T101500\n");
bufferedWriter.write("TRANSP:OPAQUE\n");
bufferedWriter.write("SUMMARY:iCalendar first deliverable due\n");
bufferedWriter.write("DTSTART;TZID=Pacific/Honolulu:20150705T091500\n");
bufferedWriter.write("DTSTAMP:20150705T234637Zv\n");
bufferedWriter.write("LOCATION:University of Hawaiʻi at Mānoa\n2500 Campus Rd\nHonolulu HI 96822"
			+ "X-APPLE-STRUCTURED-LOCATION;VALUE=URI;X-ADDRESS=2500 Campus Rd\\nHonolulu HI 96822;"
			+ "X-APPLE-RADIUS=103.6942387013834;X-TITLE=University of Hawaiʻi at Mānoa:"
			+ "geo:21.298121,-157.818711\n");
bufferedWriter.write("SEQUENCE:0\n");
bufferedWriter.write("DESCRIPTION: due online for ICS314\n");
bufferedWriter.write("END:VEVENT\n");
bufferedWriter.write("END:VCALENDAR\n");*/
