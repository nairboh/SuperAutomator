package automatedsequence.fileInput;

/**
 * Purpose: OCanada Class
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class OCanada {

    private int id; // id number
    private String path; // path of OCanada mp3

    /**
     * Overloaded Constructor
     *
     * @param id the id number of the song/file
     * @param path the path of the song
     */
    public OCanada(int id, String path) {
        this.id = id;
        this.path = path;
    }

    /**
     * Method returns the id of the song
     *
     * @return id of the file (int)
     */
    public int getID() {
        return id;
    }

    /**
     * Method for setting the ID for the song
     *
     * @param id the id for the song
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Method for getting the path of the song
     *
     * @return path of the song
     */
    public String getPath() {
        return path;
    }
}
