package automatedsequence.fileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Brian Ho
 */
public class ReadFile {

    private Scanner scheduleFile;
    private Scanner oCanadaFile;
    private static ArrayList<Line> genericEventLines; // share amongst all instances
    //private static ArrayList<Line> oCanadaEventLines; // share amongst all instances
    
    /**
     * Constructor - Creates an arrayList and a scanner object with the schedule.text as the input
     */
    public ReadFile() {
        genericEventLines = new ArrayList();
        //oCanadaEventLines = new ArrayList();
        try {
            scheduleFile = new Scanner(new File("/Users/brianho/Music/schedule.txt")).useDelimiter("\\s*@\\s*"); // path of file to store scheduled information, delimiter is set to @
            createGenericLineObject();
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] Could not find file.");
        }
    }
    
    /**
     * Creates a line object with the values scanned on each line of schedule.txt
     */
    private void createGenericLineObject() {
        while(scheduleFile.hasNext()) {
            int id = scheduleFile.nextInt();
            String name = scheduleFile.next();
            String path = scheduleFile.next();
            int startTimeInSeconds = scheduleFile.nextInt();
            int endTimeInSeconds = scheduleFile.nextInt();
            String date = scheduleFile.next();
            genericEventLines.add(new Line(id, name, path, startTimeInSeconds, endTimeInSeconds, date));
        }
        scheduleFile.close();
    }
    
    private void createOCanadaLineObject() {
        while(oCanadaFile.hasNext()) {
            int id = scheduleFile.nextInt();
            String path = scheduleFile.next();
            int startTimeInSeconds = scheduleFile.nextInt();
           // oCanadaEventLines.add(new Line(id, path, startTimeInSeconds));
        }
        oCanadaFile.close();
    }
    
    /**
     * Method returns the array list of type line to be used by other classes
     * @return an array list of type line
     */
    public static ArrayList<Line> getGenericEventData() {
        return genericEventLines;
    }
    
    /**
     * Method returns the array list of type line to be used by other classes
     * @return an array list of type line
     */
    public static ArrayList<Line> getOCanadaEventData() {
        //return oCanadaEventLines;
        return null;
    }
}
