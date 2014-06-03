package automatedsequence.fileInput;

/**
 *
 * @author brianho
 */
public class Line {

    private final int id;
    private final String name, path, date;
    private final int startTimeInMilliseconds;

    public Line(int id, String name, String path, int startTime, String date) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.startTimeInMilliseconds = startTime;
        this.date = date;
    }

    public int getEventID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getDate() {
        return date;
    }

    public int getStartTime() {
        return startTimeInMilliseconds;
    }
}
