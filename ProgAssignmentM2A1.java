// ProgAssignmentM2A1.java
// Ryan Fischer
// 9/6/25
// Professor Parrot

import java.util.GregorianCalendar;

public class ProgAssignmentM2A1 {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(561555550000L);

        System.out.println("Date 1: " + date1.getYear() + "-" + date1.getMonth() + "-" + date1.getDay());
        System.out.println("Date 2: " + date2.getYear() + "-" + date2.getMonth() + "-" + date2.getDay());

    }

    static class MyDate {
        private int year = 1970;
        private int month = 1;
        private int day = 1;

        public MyDate() {
            GregorianCalendar calendar = new GregorianCalendar();
            this.year = calendar.get(GregorianCalendar.YEAR);
            this.month = calendar.get(GregorianCalendar.MONTH) + 1;
            this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        }

        public MyDate(long elapsedTime) {
            setDate(elapsedTime);
        }

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public void setDate(long elapsedTime) {
            java.util.GregorianCalendar calendar = new java.util.GregorianCalendar();
            calendar.setTimeInMillis(elapsedTime);
            this.year = calendar.get(GregorianCalendar.YEAR);
            this.month = calendar.get(GregorianCalendar.MONTH);
            this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);

        }

    

    }
}
