package automatedsequence.fileInput;

/**
 *
 * @author Brian Ho
 */
public class Line {

    private int id, startTimeInSeconds, endTimeInSeconds;
    private String name, path, date;

    /**
     * Overloaded Constructor
     *
     * @param id the id of the event
     * @param name the name of the event
     * @param path the path of the mp3 file to be played during the event execution
     * @param startTime the time that the event needs to be started by in milliseconds
     * @param endTime
     * @param date the date(s) that the event is set to execute on
     */
    public Line(int id, String name, String path, int startTime, int endTime, String date) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.startTimeInSeconds = startTime;
        this.endTimeInSeconds = endTime;
        this.date = date;
    }
    
     /**
     * Overloaded Constructor 2
     *
     * @param id the id of the event
     * @param path the path of the mp3 file to be played during the event execution
     * @param startTime the time that the event needs to be started by in milliseconds
     * @param endTime the time that the event needs to stop by
     */
    public Line(int id, String path, int startTime, int endTime) {
        this.id = id;
        this.name = "";
        this.path = path;
        this.startTimeInSeconds = startTime;
        this.endTimeInSeconds = endTime;
        this.date = "";
    }

    /**
     * Method returns the id of the event
     *
     * @return the id of the event
     */
    public int getEventID() {
        return id;
    }

    /**
     * Method returns the name of the event
     * 
     * @return name of the event
     */
    public String getName() {
        return name;
    }
    
    /**
     * Method returns the path of the file to be played
     * 
     * @return path of the file to be played
     */
    public String getPath() {
        return path;
    }

    /**
     * Method returns date that the event will be executed
     * 
     * @return date that the event will be executed
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Method returns the time in seconds that the event needs to start by
     * 
     * @return the time in seconds that the event needs to start by
     */
    public int getStartTime() {
        return startTimeInSeconds;
    }
    
    /**
     * Method returns the time in seconds that the event needs to end by
     * 
     * @return the time in seconds that the event needs to start by
     */
    public int getEndTime() {
        return endTimeInSeconds;
    }
    
    /**
     * Method sets the time in seconds that the event needs to start by
     * @param postponeLength
     */
    public void postponeStartTime(int postponeLength) {
        startTimeInSeconds += (postponeLength * 60);
    }
    
    /**
     * Method sets the time in seconds that the event needs to end by
     * @param postponeLength
     */
    public void postponeEndTime(int postponeLength) {
        endTimeInSeconds += (postponeLength * 60);
    }
}
