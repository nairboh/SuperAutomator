package automatedsequence.dateAndTime;

/**
 * Purpose: SuperCalendar Class
 *
 * @author Brian Ho
 */
public class SuperCalendar {

    /**
     * Method returns a string of the day of week
     *
     * @param dayOfWeek an integer value of the day of week
     * @return a string representation of the day of week
     */
    public String getDayOfWeek(int dayOfWeek) {
        String nameOfDayOfWeek = "";
        switch (dayOfWeek) {
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
        return nameOfDayOfWeek;
    }
    
    /**
     * Method returns a string of the current month
     * 
     * @param month an integer value of the current month
     * @return a string representation of the current month
     */
    public String getMonth(int month) {
        String nameOfMonth = "";
        switch (month) {
            case 1:
                nameOfMonth = "January";
                break;
            case 2:
                nameOfMonth = "Febuary";
                break;
            case 3:
                nameOfMonth = "March";
                break;
            case 4:
                nameOfMonth = "April";
                break;
            case 5:
                nameOfMonth = "May";
                break;
            case 6:
                nameOfMonth = "June";
                break;
            case 7:
                nameOfMonth = "July";
                break;
            case 8:
                nameOfMonth = "August";
                break;
            case 9:
                nameOfMonth = "September";
                break;
            case 10:
                nameOfMonth = "October";
                break;
            case 11:
                nameOfMonth = "November";
                break;
            case 12:
                nameOfMonth = "December";
                break;
        }
        return nameOfMonth;
    }
}
