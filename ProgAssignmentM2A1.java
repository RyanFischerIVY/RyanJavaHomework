// ProgAssignmentM2A1.java
// Ryan Fischer
// 9/6/25
// Professor Parrot

import java.util.GregorianCalendar;

public class ProgAssignmentM2A1 {
    public static void main(String[] args) {
        //Creates the objects
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);
        //Prints out the date specified
        System.out.println("Date 1: " + date1.getYear() + "-" + date1.getMonth() + "-" + date1.getDay());
        System.out.println("Date 2: " + date2.getYear() + "-" + date2.getMonth() + "-" + date2.getDay());
    }

    static class MyDate {
        private int year;
        private int month;
        private int day;
        //Gets the current date
        public MyDate() {
            GregorianCalendar calendar = new GregorianCalendar();
            this.year = calendar.get(GregorianCalendar.YEAR);
            this.month = calendar.get(GregorianCalendar.MONTH) + 1;
            this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        }
        //Finds the date since 1970 using miliseconds
        public MyDate(long elapsedTime) {
            setDate(elapsedTime);
        }
        //Lets the user enter their own date
        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        //Getters
        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }
        //Sets teh date using the elapsed time
        public void setDate(long elapsedTime) {
            java.util.GregorianCalendar calendar = new java.util.GregorianCalendar();
            calendar.setTimeInMillis(elapsedTime);
            this.year = calendar.get(GregorianCalendar.YEAR);
            this.month = calendar.get(GregorianCalendar.MONTH) + 1;
            this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);

        }

    

    }
}
