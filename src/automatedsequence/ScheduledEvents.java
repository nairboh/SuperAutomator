package automatedsequence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Brian Ho
 */
public class ScheduledEvents {
    private Scanner scheduleFile;
    private int currentEventNumber;
    
    
    /**
     * Constructor
     */
    public ScheduledEvents() {
        try {
            scheduleFile = new Scanner(new File("/Users/brianho/Music/schedule.txt")); // path of file to store scheduled information
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] Could not find file.");
        }
    }
    
    public int getCurrentEvent() {
        currentEventNumber = scheduleFile.nextInt(); // First integer in file
        scheduleFile.close();
        return currentEventNumber;
    }
}
