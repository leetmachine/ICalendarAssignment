//eventFile Object

public class EventFile {	

String filePath = "";



public String getFilePath() {
	return filePath;
}

public void setFilePath(String filePath) {
	this.filePath = filePath;
}

String eventSummary = "";
int eventStartTime;
String fullStartTime = "";
String fullEndTime = "";
double latitude;
double longitude;
String geoPosition;
String comment;



public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public EventFile() {
}

public EventFile(String filePath, String eventSummary,String eventStartTime, String latitude, String longitude) {
	super();
	this.filePath = filePath;
	this.eventSummary = eventSummary;
	this.eventStartTime = Integer.parseInt(eventStartTime, 10);
	this.latitude = Double.parseDouble(latitude);
	this.longitude = Double.parseDouble(longitude);
}


public int getEventStartTime() {
	return eventStartTime;
}

public void setEventStartTime(int eventStartTime) {
	this.eventStartTime = eventStartTime;
}

public double getLatitude() {
	return latitude;
}

public void setLatitude(double latitude) {
	this.latitude = latitude;
}

public double getLongitude() {
	return longitude;
}

public void setLongitude(double longitude) {
	this.longitude = longitude;
}

public EventFile(String eventSummary) {
	this.eventSummary = eventSummary;
}



public String getEventSummary() {
	return eventSummary;
}

public void setEventSummary(String eventSummary) {
	this.eventSummary = eventSummary;
}







}
