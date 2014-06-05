package automatedsequence.fileInput;

import automatedsequence.constants.PathConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Brian Ho
 */
public class ReadOCanadaFile {

    private Scanner oCanadaFile;
    private static ArrayList<OCanada> oCanadaLines; // share amongst all instances
    
    /**
     * Constructor - Creates an arrayList and a scanner object with the schedule.text as the input
     */
    public ReadOCanadaFile() {
        oCanadaLines = new ArrayList();
        try {
            oCanadaFile = new Scanner(new File(PathConstants.oCanadaFilePath)).useDelimiter("\\s*@\\s*"); // path of file to store scheduled information, delimiter is set to @
            createOCanadaObject();
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] Could not find file.");
        }
    }
    
    /**
     * Creates a line object with the values scanned on each line of schedule.txt
     */
    private void createOCanadaObject() {
        while(oCanadaFile.hasNext()) {
            int id = oCanadaFile.nextInt();
            String path = oCanadaFile.next();
            oCanadaLines.add(new OCanada(id, path));
        }
        oCanadaFile.close();
    } 
    
    /**
     * Method returns the array list of type line to be used by other classes
     * @return an array list of type line
     */
    public static ArrayList<OCanada> getOCanadaVersionData() {
        return oCanadaLines;
    }
}
