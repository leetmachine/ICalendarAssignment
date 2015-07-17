import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;



//file selector method for when the "select" button is pressed
public class SelectedFolder {

	String[] files;
	int n = 0;
	
	

	public static void Chooser() {
		
		String fileName;
		String userHomeFolder = System.getProperty("user.home");
		System.out.println(userHomeFolder);
		ICalendar.folderLabel.setText(userHomeFolder+"/Desktop/OurCalendarEvents/");
			 File folder = new File(userHomeFolder+"/Desktop/OurCalendarEvents/");
			 File[] listOfFiles = folder.listFiles();
			 
			 
			for (int i = 0; i < listOfFiles.length; i++) {
				fileName = "" + listOfFiles[i];
				System.out.println(fileName);
				try {
					FileReader fileReader = new FileReader(fileName);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
	}
	
	public String[] Sorter (String[] files) {
		String[] sortedFiles = null;
		
		return sortedFiles;
	}
	
	
	
}
