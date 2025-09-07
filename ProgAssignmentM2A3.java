

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
        catch (BinaryFormatException e) {
        System.out.println("Invalid binary string.");
        }


        input.close();
    }

        public static int bin2dec(String binaryString) throws BinaryFormatException {
            // Manual validation
            for (char c : binaryString.toCharArray()) {
                if (c != '0' && c != '1') {
                    throw new BinaryFormatException("Not a binary string: " + binaryString);
                }
            }

            // Safe conversion
            return Integer.parseInt(binaryString, 2);
        }

    public class BinaryFormatException extends Exception {
        public BinaryFormatException(String message) {
            super(message);

        }
    }
}
