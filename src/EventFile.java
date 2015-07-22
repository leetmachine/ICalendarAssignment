//eventFile Object

public class EventFile {	

String eventSummary = "";
int eventStartTime;
double latitude;
double longitude;



public EventFile() {
}

public EventFile(String eventSummary, String eventStartTime, String latitude,
		String longitude) {
	super();
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
