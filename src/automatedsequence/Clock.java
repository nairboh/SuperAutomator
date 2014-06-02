/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatedsequence;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author brianho
 */
public class Clock implements Runnable {
    private static String time;
    private SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
    
    @Override
    public void run() {
        while (true) {
            time = sf.format(new Date());
            try {
                Thread.sleep(1000); // loop once every second, reduces toll on cpu
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public static String getTime() {
        return time;
    }
}
