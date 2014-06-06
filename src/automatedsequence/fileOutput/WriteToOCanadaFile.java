package automatedsequence.fileOutput;

import automatedsequence.constants.PathConstants;
import automatedsequence.fileInput.OCanada;
import automatedsequence.fileInput.ReadOCanadaFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Purpose: Write to oCanada.txt
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class WriteToOCanadaFile {

    /**
     * Method reorders the indexes of the lines in the file then writes it to
     * file
     */
    public static void reorderAndWrite() {
        int counter = 0; // counter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PathConstants.oCanadaFilePath))) { // write to file
            for (OCanada oCanadaVersionData : ReadOCanadaFile.getOCanadaVersionData()) { // loop through all the files
                oCanadaVersionData.setID(counter); // set ids to reorder then ascendingly
                bw.write(oCanadaVersionData.getID() + " @ " + oCanadaVersionData.getPath() + " @ "); // format and write
                counter++; // increment
                bw.newLine(); // new line
            }
            bw.flush(); // flush stream
            bw.close(); // close file
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    /**
     * Method writes to file without reordering
     */
    public static void write() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(PathConstants.oCanadaFilePath))) { // write to file
            for (OCanada oCanadaVersionData : ReadOCanadaFile.getOCanadaVersionData()) { // loop through all indexes
                bw.write(oCanadaVersionData.getID() + " @ " + oCanadaVersionData.getPath() + " @ "); // formats and write
                bw.newLine(); // new line
            }
            bw.flush(); // flush stream
            bw.close(); // close file
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
}
