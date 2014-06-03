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
    private String taskNumber, name = "", startTime = "", endTime, date;
    
    @Override
    public void run() {
        MP3Player MC = new MP3Player();
        SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");

        int elaspedTimeInSeconds = 0;
        boolean isPlaying = false; // is there an audio file currently playing

       readFile();

        while (true) { // loop indefinately
            if (sf.format(new Date()).equals(startTime)) { // if the time is as listed in the file, execute actions below
                MC.Play("/Users/brianho/Music/hello.mp3");
                isPlaying = true;
                
            }
            if (elaspedTimeInSeconds == 10) {
                MC.Stop();
                isPlaying = false;
            }
            //System.out.println(startTime);
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
        try {
            scheduleFile = new Scanner(new File("/Users/brianho/Music/schedule.txt")); // path of file to store scheduled information
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        }
         // exits file after reading
        //while (scheduleFile.hasNext()) {
        int lol = scheduleFile.nextInt();
            name = scheduleFile.next();
            startTime = scheduleFile.next();
            endTime = scheduleFile.next();
            date = scheduleFile.next(); // date of schedule
        //}
        closeFile();
    }

    public void closeFile() {
        scheduleFile.close();
    }
    
    public String getTaskName() {
        return name;
    }
    
    public String getTaskStartTime() {
        return startTime;
    }
    
    public String getTaskDate() {
        return date;
    }
}
