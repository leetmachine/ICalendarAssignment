import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class writeComment {
	static double lat1;
	static double long1;
	static double lat2;
	static double long2;
	static double computedDistance;
	static String distance;
	static String filepath;
	static String currentLine;

	
public static void writeToComment(List<EventFile> events) {
	//for every item in the list except the last, compare n to n+1
	for(int i = 0; i < events.size()-1;i++){
	//lat and longitude are stored in the object, so easily grab them and throw them into the greatCircle, which returns the Distance. 
	lat1 = events.get(i).latitude;
	long1 = events.get(i).longitude;
	lat2 = events.get(i+1).latitude;
	long2 = events.get(i+1).longitude;
	System.out.println(events.get(i).eventSummary + " geo coordinates are " + lat1 + " " + long1);
	System.out.println(events.get(i+1).eventSummary + " geo coordinates are " + lat2 + " " + long2);
	
	//compute distance and parse to String distance
	computedDistance = GreatCircle.distance(lat1, long1, lat2, long2);
	distance = Double.toString(computedDistance);
	System.out.println("Distance computed line 35:" + distance);
	
	//get the filepath and open document n
	filepath = events.get(i).filePath;

	
	try {
		String newComment;
		String thisFile = "";

	//reads in file
	FileReader filereader = new FileReader(filepath);
	BufferedReader reader = new BufferedReader(filereader);
	
		//read line by line
		while((currentLine = reader.readLine()) != null) {
			System.out.println("Enter While block");
			
			//if the line is the COMMENT: line, it replaces it with the distance.
			if(currentLine.contains("COMMENT:")) {
				System.out.println("Enter if COMMENT statement");
				//add the computed distance to that line. 
				newComment = currentLine.replace("COMMENT:", "COMMENT:" + distance + " miles away from next event\n" );
				thisFile += newComment + "\n";
				System.out.println(newComment);
			}
			//writes each line to the String variable.
			else {
				thisFile += currentLine + "\n";
			}
		}
		
		FileWriter filewriter = new FileWriter(filepath);
		BufferedWriter writer = new BufferedWriter(filewriter);
		System.out.println(thisFile);
		
		writer.write(thisFile);
		
		reader.close();
		writer.close();

		events.get(i).setComment(distance);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	//while loop ends and continues to n+1 compare n+2
	}

	
}

	
}
