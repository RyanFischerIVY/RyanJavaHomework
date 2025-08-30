
import java.util.Scanner;

public class cardNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Creates an object to store the input in
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong(); //Grabs user input
        //Checks if the number is valid
        if (isValid(number)) {
            System.out.println(number + " is valid.");
        } else {
            System.out.println(number + " is invalid.");
        }
        input.close(); //Added because the compiler was giving a warning
    }
    //Goes through each catagory to find if the number is valid
    public static boolean isValid(long number) {
        return (sumofDoubleEvenPlace(number) + sumofOddPlace(number)) % 10 == 0 //Adds the sums and checks if divisible by 10
                && (prefixMatched(number, 4) || prefixMatched(number, 5)
                || prefixMatched(number, 37) || prefixMatched(number, 6)) //Makes sure the prefix is right
                && (getSize(number) >= 13 && getSize(number) <= 16); //Makes sure the size is right
    }

    public static int sumofDoubleEvenPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = num.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(num.charAt(i)); //Turns the string version of the number back into an integer so it can be added
            sum += getDigit(digit * 2);
        }
        return sum;
    }

    public static int getDigit(int number) {
        if (number < 10)
            return number;
        return number / 10 + number % 10;
    }

    public static int sumofOddPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = num.length() - 1; i >= 0; i -= 2) {
            sum += Character.getNumericValue(num.charAt(i)); //Needs to be turned back into a number so it can be added
        }
        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d) {
        return (d + "").length();
    }

    public static long getPrefix(long number, int k) {
        String num = number + "";
        if (num.length() < k)
            return number;
        return Long.parseLong(num.substring(0, k));
    }
}
