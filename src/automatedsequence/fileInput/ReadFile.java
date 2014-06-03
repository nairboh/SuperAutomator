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
    private static ArrayList<Line> lines; // share amongst all instances
    
    /**
     * Constructor - Creates an arrayList and a scanner object with the schedule.text as the input
     */
    public ReadFile() {
        lines = new ArrayList();
        try {
            scheduleFile = new Scanner(new File("/Users/brianho/Music/schedule.txt")).useDelimiter("\\s*@\\s*"); // path of file to store scheduled information, delimiter is set to @
            createLineObject();
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] Could not find file.");
        }
    }
    
    /**
     * Creates a line object with the values scanned on each line of schedule.txt
     */
    private void createLineObject() {
        while(scheduleFile.hasNext()) {
            int id = scheduleFile.nextInt();
            String name = scheduleFile.next();
            String path = scheduleFile.next();
            int startTimeInSeconds = scheduleFile.nextInt();
            String date = scheduleFile.next();
            lines.add(new Line(id, name, path, startTimeInSeconds, date));
        }
        scheduleFile.close();
    }
    
    /**
     * Method returns the array list of type line to be used by other classes
     * @return an array list of type line
     */
    public static ArrayList<Line> getData() {
        return lines;
    }
}
