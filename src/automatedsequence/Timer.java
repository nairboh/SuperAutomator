package automatedsequence;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Brian Ho, Max Romanoff
 */
public class Timer implements Runnable {

    private Scanner scheduleFile;
    private String taskNumber, name, startTime, endTime, date;

    @Override
    public void run() {
        MainClass MC = new MainClass();
        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");

        int elaspedTimeInSeconds = 0;
        boolean isPlaying = false; // is there an audio file currently playing

        try {
            scheduleFile = new Scanner(new File("/Users/brianho/Music/schedule.txt")); // path of file to store scheduled information
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }

        readFile(); // get variables for current event
        closeFile(); // exits file after reading

        while (true) { // loop indefinately
            if (sf.format(new Date()).equals(startTime)) { // if the time is as listed in the file, execute actions below
                MC.Play("/Users/brianho/Music/Black.mp3");
                isPlaying = true;
            }
            if (elaspedTimeInSeconds == 10) {
                MC.Stop();
            }
            System.out.println(startTime);

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

    public void readFile() {
        while (scheduleFile.hasNext()) {
            name = scheduleFile.next();
            startTime = scheduleFile.next();
            endTime = scheduleFile.next();
            date = scheduleFile.next(); // date of schedule
        }
    }

    public void closeFile() {
        scheduleFile.close();
    }
}
