/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package automatedsequence;

import java.util.Calendar;

/**
 *
 * @author brianho
 */
public class CalenderLOL {
    public static void getTime() {
        
        Calendar calendar = Calendar.getInstance();
        
        byte daysOfWeek = (byte) calendar.get(Calendar.DAY_OF_WEEK);
        
        String nameOfDayOfWeek =""; // Initialize 
        
        switch(daysOfWeek) {
            case 1:
                nameOfDayOfWeek = "Sunday";
                break;
            case 2:
                nameOfDayOfWeek = "Monday";
                break;
            case 3:
                nameOfDayOfWeek = "Tuesday";
                break;
            case 4:
                nameOfDayOfWeek = "Wednesday";
                break;
            case 5:
                nameOfDayOfWeek = "Thursday";
                break;
            case 6:
                nameOfDayOfWeek = "Friday";
                break;
            case 7:
                nameOfDayOfWeek = "Saturday";
                break;     
        }
        
        System.out.println("Today is " + nameOfDayOfWeek );
    }
    
    public static void main(String[] args) {
        getTime();
        
    }
}
