package automatedsequence;

import automatedsequence.constants.PathConstants;
import automatedsequence.dateAndTime.SuperCalendar;
import automatedsequence.fileInput.Line;
import automatedsequence.fileInput.ReadOCanadaFile;
import automatedsequence.fileInput.ReadScheduleFile;
import automatedsequence.gui.AuthenticationDialogue;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Purpose: Timer Class; runs in background and starts events automatically
 *
 * @author Brian Ho, Max Romanoff, Conor Norman June 5 2014
 */
public class Timer implements Runnable {

    private SuperCalendar calendar = new SuperCalendar();
    private RandomizeOCanada randomOCanada = new RandomizeOCanada();
    private int startTime = 0, endTime = 0;
    private static int currentTimeInSeconds = 0;
    private static int oCanadaVersion; // to hold random number
    private static int id = 0, originalStartTime = 0, originalEndTime = 0; // information for forced start events
    private static boolean isManuallyStarted = false, isManuallyStopped = false; // is the event manually initiated
    private static boolean isPlaying = false; // is there an audio file currently playing
    private static boolean isOCanadaPlaying = false;

    /**
     * Thread for handling playing music at specific times
     */
    @Override
    public void run() {
        int elaspedTimeInSeconds = 0; // counter for elasped time

        while (true) { // loop indefinately
            Calendar c = new GregorianCalendar();
            int month = (c.get(Calendar.MONTH) + 1); // because starts at 0
            int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
            int year = c.get(Calendar.YEAR);
            String nameOfDayOfWeek = (calendar.getDayOfWeek(c.get(Calendar.DAY_OF_WEEK)));

            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            int sec = c.get(Calendar.SECOND);
            currentTimeInSeconds = ((hour * 3600) + (minute * 60) + sec);

            for (Line genericEventData : ReadScheduleFile.getScheduledEventData()) { // loop through all arraylist indexes
                if ((currentTimeInSeconds == genericEventData.getStartTime()) && ((genericEventData.getDate().equalsIgnoreCase("EVERYDAY") || genericEventData.getDate().equals(month + "/" + dayOfMonth + "/" + year) || genericEventData.getDate().equals(month + "/" + dayOfMonth + "/YEARLY")))) { // if the time and date is the same as listed in the file or if file is set to yearly or everyday (yearly is used for holidays), execute actions below
                    if (!genericEventData.getPath().equalsIgnoreCase("NOPATH") && (!nameOfDayOfWeek.equalsIgnoreCase("Saturday") || !nameOfDayOfWeek.equalsIgnoreCase("Saturday"))) { // holidays are assigned no path, therefore on holidays this does nothing
                        if (genericEventData.getEventID() == PathConstants.oCanadaID) { // get the default id of OCanada
                            oCanadaVersion = randomOCanada.getVersion(); // get randomly generated version
                            genericEventData.setPath(ReadOCanadaFile.getOCanadaVersionData().get(oCanadaVersion).getPath()); // get path of randomly generated version
                            isOCanadaPlaying = true; // set ocanada as playing for logger update
                        }
                        if (!isManuallyStarted) { // if event is not manually started
                            AuthenticationDialogue.getMainProgramInstance().getMP3PlayerInstance().Play(genericEventData.getPath()); // play song
                        } else {
                            AuthenticationDialogue.getMainProgramInstance().getMP3PlayerInstance().Play(ReadScheduleFile.getScheduledEventData().get(id).getPath()); // ensure that manually initiated event takes priority
                        }
                        elaspedTimeInSeconds = 0; // reset the elasped time to 0
                        isPlaying = true; // set song as playing
                        startTime = genericEventData.getStartTime();
                        endTime = genericEventData.getEndTime();
                    } else {  // if anything is played during a holiday, and it is not a forced start, kill it (stop)
                        AuthenticationDialogue.getMainProgramInstance().getMP3PlayerInstance().Stop(); // stops song
                        isPlaying = false; // reset
                        isOCanadaPlaying = false; // reset
                    }
                }
            }

            if (elaspedTimeInSeconds == (endTime - startTime) || isManuallyStopped) { // calculate elasped time, used for stopping the song
                if (!isManuallyStopped) { // since main program already stops it
                    AuthenticationDialogue.getMainProgramInstance().getMP3PlayerInstance().Stop(); // stops song
                }
                elaspedTimeInSeconds = 0; // reset the elasped time to 0
                isPlaying = false; // reset
                isOCanadaPlaying = false; // reset
                if (isManuallyStarted || isManuallyStopped) { // if this event is a forced start or is is a manual event that is forced to stop manually
                    if (isManuallyStarted) { // if this is a manual event and not an automatic
                        ReadScheduleFile.getScheduledEventData().get(id).setStartTime(originalStartTime); // set the time back to original
                        ReadScheduleFile.getScheduledEventData().get(id).setEndTime(originalEndTime); // set the end time back to original
                        AuthenticationDialogue.getMainProgramInstance().populateScheduledBox(true); // reset box to show updated changes
                        AuthenticationDialogue.getMainProgramInstance().setForcedStartActive(false); // allows for another event to be manually started without error
                    }
                    isManuallyStarted = false; // set forced start to false
                    isManuallyStopped = false; // reset variable           
                }
            }

            try {
                Thread.sleep(1000); // loop once every second, reduces toll on cpu
                if (isPlaying) {
                    elaspedTimeInSeconds++; // increment
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * Method returns the generated oCanada version
     *
     * @return randomly generated OCanada version
     */
    public static int getOCanadaVersion() {
        return oCanadaVersion + 1; // dont want it to say version 0
    }

    /**
     * Method returns if OCanada is playing or not
     *
     * @return if OCanada is playing or not
     */
    public static boolean isOCanadaPlaying() {
        return isOCanadaPlaying;
    }
    
    /**
     * Method sets if OCanada is playing or not
     *
     * @param playing if the song is playing or not
     */
    public static void setIsOCanadaPlaying(boolean playing) {
        isOCanadaPlaying = playing;
    }

    /**
     * Method returns the current time in seconds
     *
     * @return current time in seconds
     */
    public static int getCurrentTimeInSeconds() {
        return currentTimeInSeconds;
    }
    
    /**
     * Method gets information on manually started events
     * 
     * @param isManual is the event manually started
     * @param idOfForcedStart what is the event started
     * @param initialStartTime what is the original event start time
     * @param initialEndTime  what is the original event end time
     */
    public static void isManuallyStarted(boolean isManual, int idOfForcedStart, int initialStartTime, int initialEndTime) {
        isManuallyStarted = true;
        id = idOfForcedStart;
        originalStartTime = initialStartTime;
        originalEndTime = initialEndTime;
    }
    
    /**
     * Method gets information if event is manually event is manually stopped
     * 
     * @param isManual is manual event manually stopped?
     */
    public static void isManuallyStopped(boolean isManual) {
        isManuallyStopped = isManual;
    }
    
    /**
     * Methods returns if there is an event currently playing 
     * 
     * @return true if something is playing
     */
    public static boolean getIsPlaying() {
        return isPlaying;
    }
}
