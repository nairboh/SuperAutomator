package automatedsequence;

/**
 *
 * @author Brian Ho
 */
public class RandomizeOCanada {
    private int oCanadaVersion, numberOfOCanadaVersions;
    
    /**
     * Method randomly generates an O'Canada version from the imported files
     * @return An integer representation of the O Canada version generated
     */
    public int getVersion() {
        oCanadaVersion = (int) (Math.random() * getNumberOfOCanadaVersions() + 1); // generates a random number
        return oCanadaVersion;
    }
    
    /**
     * Method gets total number of OCanada Versions
     * @return total number of OCanada versions based on imported files
     */
    public int getNumberOfOCanadaVersions() {
        numberOfOCanadaVersions = 4;
        return numberOfOCanadaVersions;
    }
}
