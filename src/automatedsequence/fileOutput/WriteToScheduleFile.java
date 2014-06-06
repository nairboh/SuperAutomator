package automatedsequence.fileOutput;

import automatedsequence.constants.PathConstants;
import automatedsequence.fileInput.Line;
import automatedsequence.fileInput.ReadScheduleFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Purpose: Write to scheduleFile.txt
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class WriteToScheduleFile {
    
    /**
     * Method reorders the indexes of the lines in the file then writes it to
     * file
     */
    public static void reorderAndWrite() {
        int counter = 0; // counter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PathConstants.scheduleFilePath))) { // write to file
            for (Line genericEventData : ReadScheduleFile.getScheduledEventData()) { // loop through all indexes
                genericEventData.setEventID(counter); // make the events in ascending order
                bw.write(genericEventData.getEventID() + " @ " + genericEventData.getName() + " @ " + genericEventData.getPath() + " @ " + genericEventData.getStartTime() + " @ " + genericEventData.getEndTime() + " @ " + genericEventData.getDate() + " @ "); // format and write
                counter++; // increment
                bw.newLine(); // new line
            }
            bw.flush(); // flush the stream
            bw.close(); // close file
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
    
    /**
     * Method writes to file without reordering
     */
    public static void write() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PathConstants.scheduleFilePath))) { // writes to file
            for (Line genericEventData : ReadScheduleFile.getScheduledEventData()) { // loop through all indexes
                bw.write(genericEventData.getEventID() + " @ " + genericEventData.getName() + " @ " + genericEventData.getPath() + " @ " + genericEventData.getStartTime() + " @ " + genericEventData.getEndTime() + " @ " + genericEventData.getDate() + " @ "); // format and write
                bw.newLine(); // new line
            }
            bw.flush(); // flush the stream
            bw.close(); // close file
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
}
