package automatedsequence;

import automatedsequence.fileInput.ReadOCanadaFile;

/**
 * Purpose: Randomize OCanada Class
 * 
 * @author Brian Ho, Max Romanoff, Conor Norman
 * June 5 2014
 */
public class RandomizeOCanada {
    private static int oCanadaVersion, numberOfOCanadaVersions;
    
    /**
     * Method randomly generates an O'Canada version from the imported files
     * @return An integer representation of the O Canada version generated
     */
    public int getVersion() {
        oCanadaVersion = (int) ((Math.random() * getNumberOfOCanadaVersions()) + 0.1); // generates a random number
        return oCanadaVersion;
    }
    
    /**
     * Method gets total number of OCanada Versions
     * @return total number of OCanada versions based on imported files
     */
    public int getNumberOfOCanadaVersions() {
        numberOfOCanadaVersions = ReadOCanadaFile.getOCanadaVersionData().size() - 1;
        return numberOfOCanadaVersions;
    }
}
