import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class test {
    
    public static void main(String[] args) {
        
        System.out.println("Days Of week: ");

        for (int i = 1; i < 8; i++)
            System.err.println("Number: " + i + "\tDay Of Week: " + DayOfWeekStr(i));
    }

    public static String DayOfWeekStr(int NumberOfDay) {
		String dayStr = "";
		switch (NumberOfDay) {
			case 1:
				dayStr = "Sunday";
				break;
			case 2:
				dayStr = "Monday";
				break;
			case 3:
				dayStr = "Tuesday";
				break;
			case 4:
				dayStr = "Wednesday";
                break;
			case 5:
				dayStr = "Thursday";
				break;
			case 6:
				dayStr = "Friday";
				break;
			case 7:
				dayStr = "Saturday";
				break;
		}
        return dayStr;
		
	}
}
