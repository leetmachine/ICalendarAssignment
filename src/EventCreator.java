import java.io.*;

//Keegan Gladstone
//Class for prompting user for information to create the .ics file.

public class EventCreator {
	



//method for prompting user for information for new event
public static void makeEvent() {
	System.out.println("Creating new event, please enter information below");
	
	//writes new file to user home folder, on mac this is HD/Users/"username"
	try {
		String userHomeFolder = System.getProperty("user.home");
		File icsFile = new File(userHomeFolder, "newEvent.ics");
		FileWriter fileWriter = new FileWriter(icsFile);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		//This info is from the file created by the real iCal app. Need to add more variables for user functionality in our app.
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
		bufferedWriter.write("END:VCALENDAR\n");
		
		
		
		bufferedWriter.close();
		
	} catch (IOException e) {
		System.out.println("Error Writing to file newEvent.ics");
		e.printStackTrace();
	}

	
	
}
}


/*WORKING DRAG AND DROP FILE.
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
