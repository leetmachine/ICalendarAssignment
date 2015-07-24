import java.text.DecimalFormat;

//first method I found
//Cal's greatCircle Method
public class GreatCircle {
	
static DecimalFormat format = new DecimalFormat("0.00");
// this is the method that calculates the distance of two points on Earth, based on their latitude and longitude
// it takes 4 doubles as arguments, and uses methods in the Math class to compute the distance in miles
public static double distance(double x0, double y0, double x1, double y1) {
double R = 3950.02;
double d = R* Math.acos(Math.sin(Math.toRadians(x0))*Math.sin(Math.toRadians(x1)) + 
Math.cos(Math.toRadians(x0))*Math.cos(Math.toRadians(x1))*Math.cos(Math.toRadians(y0 - y1)));
d = Double.parseDouble(format.format(d));
return d;

}
}