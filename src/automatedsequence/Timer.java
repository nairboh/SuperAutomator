package automatedsequence;

import automatedsequence.constants.PathConstants;
import automatedsequence.dateAndTime.SuperCalendar;
import automatedsequence.fileInput.Line;
import automatedsequence.fileInput.ReadOCanadaFile;
import automatedsequence.fileInput.ReadScheduleFile;
import automatedsequence.gui.MainProgram;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Purpose: Timer Class; runs in background and starts events automatically
 *
 * @author Brian Ho, Max Romanoff, Conor Norman 
 * June 5 2014
 */
public class Timer implements Runnable {

    private SuperCalendar calendar = new SuperCalendar();
    private RandomizeOCanada randomOCanada = new RandomizeOCanada();
    private int startTime = 0, endTime = 0;
    private static int oCanadaVersion; // to hold random number
    private boolean isPlaying = false; // is there an audio file currently playing
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

            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            int sec = c.get(Calendar.SECOND);

            for (Line genericEventData : ReadScheduleFile.getScheduledEventData()) { // loop through all arraylist indexes
                if ((((hour * 3600) + (minute * 60) + sec) == genericEventData.getStartTime()) && ((genericEventData.getDate().equalsIgnoreCase("EVERYDAY") || genericEventData.getDate().equals(month + "/" + dayOfMonth + "/" + year) || genericEventData.getDate().equals(month + "/" + dayOfMonth + "/YEARLY")))) { // if the time and date is the same as listed in the file or if file is set to yearly or everyday (yearly is used for holidays), execute actions below
                    if (!genericEventData.getPath().equalsIgnoreCase("NOPATH")) { // holidays are assigned no path, therefore on holidays this does nothing
                        if (genericEventData.getEventID() == PathConstants.oCanadaID) { // get the default id of OCanada
                            oCanadaVersion = randomOCanada.getVersion(); // get randomly generated version
                            genericEventData.setPath(ReadOCanadaFile.getOCanadaVersionData().get(oCanadaVersion).getPath()); // get path of randomly generated version
                            isOCanadaPlaying = true; // set ocanada as playing for logger update
                        }
                        MainProgram.getMP3PlayerInstance().Play(genericEventData.getPath()); // play song
                        elaspedTimeInSeconds = 0; // reset the elasped time to 0
                        isPlaying = true; // set song as playing
                        startTime = genericEventData.getStartTime();
                        endTime = genericEventData.getEndTime();
                    }
                }
            }

            if (elaspedTimeInSeconds == (endTime - startTime)) { // calculate elasped time, used for stopping the song
                MainProgram.getMP3PlayerInstance().Stop(); // stops song
                isPlaying = false; // reset
                isOCanadaPlaying = false; // reset
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
}
