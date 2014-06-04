package automatedsequence;

import automatedsequence.dateAndTime.SuperCalendar;
import automatedsequence.fileInput.Line;
import automatedsequence.fileInput.ReadFile;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Brian Ho, Max Romanoff
 */
public class Timer implements Runnable {

    private SuperCalendar calendar = new SuperCalendar();
    private MP3Player player = new MP3Player();
    int startTime = 0, endTime = 0;
    String path;
    boolean isPlaying = false; // is there an audio file currently playing
    @Override
    public void run() {
        int elaspedTimeInSeconds = 0;
        
  

        while (true) { // loop indefinately
            Calendar c = new GregorianCalendar();
            String month = (calendar.getMonth(c.get(Calendar.MONTH) + 1)); // because starts at 0
            int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
            int year = c.get(Calendar.YEAR);
            
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            int sec = c.get(Calendar.SECOND);
            
            for (Line genericEventData : ReadFile.getGenericEventData()) {
                if ((((hour * 3600) + (minute * 60) + sec) == genericEventData.getStartTime()) && ((genericEventData.getDate().equalsIgnoreCase("EVERYDAY") || genericEventData.getDate().equals(month + "/" + dayOfMonth + "/" + year) || genericEventData.getDate().equals(month + "/" + dayOfMonth + "/YEARLY")))) { // if the time is as listed in the file, execute actions below
                    if(!genericEventData.getPath().equalsIgnoreCase("NOPATH")) {
                        player.Play(genericEventData.getPath());
                        isPlaying = true;
                        path = genericEventData.getPath();
                        startTime = genericEventData.getStartTime();
                        endTime = genericEventData.getEndTime();
                    }
                }
            }
            
            if (elaspedTimeInSeconds == (endTime - startTime)) {
                player.Stop();
                isPlaying = false;
            }
            
            try {
                Thread.sleep(1000); // loop once every second, reduces toll on cpu
                if (isPlaying) {
                    elaspedTimeInSeconds++;
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
    public boolean getState() {
        return isPlaying;
    }
    
    public String getCurrentPlayingPath() {
        return path;
    }
}
