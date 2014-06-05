package automatedsequence.fileInput;

/**
 * Purpose: Line Class
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
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
     * Method returns the id of the event
     *
     * @return the id of the event
     */
    public int getEventID() {
        return id;
    }

    /**
     * Method sets the event id for the event
     *
     * @param idToSet the id to assign to event
     */
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

    /**
     * Method sets name of event
     *
     * @param name name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method returns the path of the file
     *
     * @return path of the file
     */
    public String getPath() {
        return path;
    }

    /**
     * Method sets the path of the file of the event
     *
     * @param path path of file
     */
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

    /**
     * Method sets the date that the event will be executed
     *
     * @param date date that the event will be executed
     */
    public void setDate(String date) {
        this.date = date;
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
     * Method sets the start time for the event
     *
     * @param startTimeInSeconds the start time in seconds
     */
    public void setStartTime(int startTimeInSeconds) {
        this.startTimeInSeconds = startTimeInSeconds;
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
     * Method sets the end time for the event in seconds
     *
     * @param endTimeInSeconds time in seconds for the event to start
     */
    public void setEndTime(int endTimeInSeconds) {
        this.endTimeInSeconds = endTimeInSeconds;
    }

    /**
     * Method sets the time in seconds that the event needs to start by
     *
     * @param postponeLengthInMinutes time in minutes to postpone whole schedule
     * by
     */
    public void postponeStartTime(int postponeLengthInMinutes) {
        startTimeInSeconds += (postponeLengthInMinutes * 60);
    }

    /**
     * Method sets the time in seconds that the event needs to end by
     *
     * @param postponeLength time in minutes to postpone whole schedule by
     */
    public void postponeEndTime(int postponeLength) {
        endTimeInSeconds += (postponeLength * 60);
    }

    /**
     * Method returns the duration of the event
     *
     * @return the scheduled duration of the event
     */
    public int getDuration() {
        return endTimeInSeconds - startTimeInSeconds;
    }

    /**
     * Method accepts the time in seconds and formats it into 24hour time
     *
     * @param timeInSeconds the time in seconds
     * @return a string of the time formatted into 24hour time
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
}
