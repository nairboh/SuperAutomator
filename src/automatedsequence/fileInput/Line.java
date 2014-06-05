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
     * @param path the path of the mp3 file to be played during the event
     * execution
     * @param startTime the time that the event needs to be started by in
     * milliseconds
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
     * Overloaded Constructor For OCanada
     *
     * @param id the id of the event
     * @param path the path of the mp3 file to be played during the event
     * execution
     * @param startTime the time that the event needs to be started by in
     * milliseconds
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
    
    public void setEventID(int idToSet) {
        id = idToSet;
    }
    /**
     * Method returns the name of the event
     *
     * @return name of the event
     */
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method returns the path of the file to be played
     *
     * @return path of the file to be played
     */
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    /**
     * Method returns date that the event will be executed
     *
     * @return date that the event will be executed
     */
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
       this.date = date;
    }
    
    public int getTimeInSeconds(String time) {
        return 0;
    }
    /**
     * Method returns the time in seconds that the event needs to start by
     *
     * @return the time in seconds that the event needs to start by
     */
    public int getStartTime() {
        return startTimeInSeconds;
    }
    
    public void setStartTime(int startTimeInSeconds) {
        this.startTimeInSeconds = startTimeInSeconds;
    }
    /**
     * Method accepts the time in seconds and formats it into 24hr time
     * 
     * @param timeInSeconds the time in seconds
     * @return a string of the time formatted into 24hr time 
     */
    public static String getFormattedTime(int timeInSeconds) {
        int hour = timeInSeconds / 3600;
        int remainder = timeInSeconds % 3600;
        int min = remainder / 60;
        int sec = remainder % 60;
        String hourStr = (hour < 10 ? "0" : "") + hour;
        String minStr = (min < 10 ? "0" : "") + min;
        String secStr = (sec < 10 ? "0" : "") + sec;
        
        return hourStr + ":" + minStr + ":" + secStr;
    }

    /**
     * Method returns the time in seconds that the event needs to end by
     *
     * @return the time in seconds that the event needs to start by
     */
    public int getEndTime() {
        return endTimeInSeconds;
    }
    
    public void setEndTime(int endTimeInSeconds) {
        this.endTimeInSeconds = endTimeInSeconds;
    }
    /**
     * Method sets the time in seconds that the event needs to start by
     *
     * @param postponeLength
     */
    public void postponeStartTime(int postponeLength) {
        startTimeInSeconds += (postponeLength * 60);
    }

    /**
     * Method sets the time in seconds that the event needs to end by
     *
     * @param postponeLength
     */
    public void postponeEndTime(int postponeLength) {
        endTimeInSeconds += (postponeLength * 60);
    }

    public void setStandUpForOCanadaPath(String path) {

    }
}
