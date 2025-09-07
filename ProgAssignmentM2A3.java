

import java.util.Scanner;

public class ProgAssignmentM2A3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a string binary value: ");
        String binaryString = input.nextLine();
        
        try {
        int decimal = bin2dec(binaryString);
        System.out.println("The converted decimal number is: " + decimal);
        } 
        catch (NumberFormatException e) {
        System.out.println("Invalid binary string.");
        }


        input.close();
    }

    public static int bin2dec(String binaryString) throws binaryFormatException {

        int decimal = Integer.parseInt(binaryString, 2);

        return decimal;
    }

    public class binaryFormatException extends Exception {
        public binaryFormatException(String message) {
            super(message);

        }
    }
}
