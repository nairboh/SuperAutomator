package automatedsequence.fileInput;

import automatedsequence.constants.PathConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Purpose: ReadOCanadaFile Class; reads the oCanada.txt file
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class ReadOCanadaFile {

    private Scanner oCanadaFile;
    private static ArrayList<OCanada> oCanadaLines; // share amongst all instances

    /**
     * Constructor - Creates an arrayList and a scanner object with the
     * oCanada.text as the input
     */
    public ReadOCanadaFile() {
        oCanadaLines = new ArrayList(); // make array list
        try {
            oCanadaFile = new Scanner(new File(PathConstants.oCanadaFilePath)).useDelimiter("\\s*@\\s*"); // path of file to store scheduled information, delimiter is set to @
            createOCanadaObject(); // create OCanada objects
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] Could not find file.");
        }
    }

    /**
     * Creates a OCanada object with the values scanned on each line of
     * oCanada.txt
     */
    private void createOCanadaObject() {
        while (oCanadaFile.hasNext()) { // while the file still has something to be read
            int id = oCanadaFile.nextInt(); // read and save the integer value into memory
            String path = oCanadaFile.next(); // read and save the string value into memory
            oCanadaLines.add(new OCanada(id, path)); // create a new OCanada object with the information scanned
        }
        oCanadaFile.close(); // close file
    }

    /**
     * Method returns the array list of type OCanada to be used by other classes
     *
     * @return an array list of type line
     */
    public static ArrayList<OCanada> getOCanadaVersionData() {
        return oCanadaLines;
    }
}
