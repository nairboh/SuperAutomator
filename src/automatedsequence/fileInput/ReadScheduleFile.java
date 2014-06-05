package automatedsequence.fileInput;

import automatedsequence.constants.PathConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose: ReadScheduleFile Class; reads the schedule.txt file
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class ReadScheduleFile {

    private Scanner scheduleFile;
    private static ArrayList<Line> scheduledEventLines; // share amongst all instances

    /**
     * Constructor - Creates an arrayList and a scanner object with the
     * schedule.text as the input
     */
    public ReadScheduleFile() {
        scheduledEventLines = new ArrayList(); // create array list
        try {
            scheduleFile = new Scanner(new File(PathConstants.scheduleFilePath)).useDelimiter("\\s*@\\s*"); // path of file to store scheduled information, delimiter is set to @
            createLineObject(); // create line objects
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] Could not find file.");
        }
    }

    /**
     * Creates a line object with the values scanned on each line of
     * schedule.txt
     */
    private void createLineObject() {
        while (scheduleFile.hasNext()) { // while the file still has something to be read
            int id = scheduleFile.nextInt(); // read and save the integer value into memory
            String name = scheduleFile.next(); // read and save the string value into memory
            String path = scheduleFile.next(); // read and save the string value into memory
            int startTimeInSeconds = scheduleFile.nextInt(); // read and save the integer value into memory
            int endTimeInSeconds = scheduleFile.nextInt(); // read and save the integer value into memory
            String date = scheduleFile.next(); // read and save the string value into memory
            scheduledEventLines.add(new Line(id, name, path, startTimeInSeconds, endTimeInSeconds, date)); // creates a new line object with the information read from file
        }
        scheduleFile.close(); // close the file
    }

    /**
     * Method returns the array list of type line to be used by other classes
     *
     * @return an array list of type line
     */
    public static ArrayList<Line> getScheduledEventData() {
        return scheduledEventLines;
    }
}
