package automatedsequence;

import automatedsequence.dateAndTime.SuperCalendar;
import automatedsequence.fileInput.Line;
import automatedsequence.fileInput.ReadFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Brian Ho, Max Romanoff
 */
public class Timer implements Runnable {

    @Override
    public void run() {

        Calendar c = new GregorianCalendar();
        SuperCalendar calendar = new SuperCalendar();
        MP3Player player = new MP3Player();

        int elaspedTimeInSeconds = 0;
        boolean isPlaying = false; // is there an audio file currently playing

        while (true) { // loop indefinately

            String month = (calendar.getMonth(c.get(Calendar.MONTH) + 1)); // because starts at 0
            int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
            int year = c.get(Calendar.YEAR);
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);
            int sec = c.get(Calendar.SECOND);

            for (Line genericEventData : ReadFile.getGenericEventData()) {
                if (((hour * 3600) + (minute * 60) + sec) == genericEventData.getStartTime()) { // if the time is as listed in the file, execute actions below
                    player.Play(genericEventData.getPath());
                    isPlaying = true;
                }
            }
            
            //if (elaspedTimeInSeconds == 10) {
              //  player.Stop();
                //isPlaying = false;
            //}
            if (player.isComplete()) {
                System.out.println("COMPLETED MUDA ASSHORE");
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
}
