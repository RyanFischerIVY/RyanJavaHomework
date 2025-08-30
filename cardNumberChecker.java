
import java.util.Scanner;

public class cardNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();

        if (isValid(number)) {
            System.out.println(number + " is valid.");
        } else {
            System.out.println(number + " is invalid.");
        }
    }

    public static boolean isValid(long number) {
        // Luhn algorithm: sum of double even place + sum of odd place % 10 == 0
        return (sumofDoubleEvenPlace(number) + sumofOddPlace(number)) % 10 == 0
                && (prefixMatched(number, 4) || prefixMatched(number, 5)
                || prefixMatched(number, 37) || prefixMatched(number, 6))
                && (getSize(number) >= 13 && getSize(number) <= 16);
    }

    public static int sumofDoubleEvenPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = num.length() - 2; i >= 0; i -= 2) {
            int digit = Character.getNumericValue(num.charAt(i));
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
            sum += Character.getNumericValue(num.charAt(i));
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