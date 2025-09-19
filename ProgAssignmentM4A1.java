import java.util.Stack;
import java.util.Scanner;
import java.io.File;


public class ProgAssignmentM4A1 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("File name needed");
            return;
        }
 

        //create a stack for the symbols to be put into
        String filename = args[0];
        Stack<Character> stack = new Stack<>();


        try {
            Scanner input = new Scanner(new File(filename));

                //Read the character from the file

                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    for (char ch : line.toCharArray()) {
                        if ( ch == '(' || ch == '{' || ch == '[') {
                            stack.push(ch); //Adds ch to the stack if the correct symbol is found
                        }
                        else if ( ch == ')' || ch == '}' || ch == ']') { //Checks the closing symbols
                            if (stack.isEmpty()) {
                                System.out.println("Extra closing, exiting program.");
                                input.close();
                                return;
                            }
                            char top = stack.pop(); //Removes the symbol if the mathching pair is found
                            if (!matches(top, ch)) {
                            System.out.println("Symbols are mismatched");
                            return;

                        }
                    }
                };
                input.close();
                //Ending statments for whether or not the symbols are placed correctly
                if(stack.isEmpty()) {
                    System.out.println("All Symbols Match correct! Hurray!!!!");
                }
                else {
                    System.out.println("Input is invalid, missing closing symbol");
                }
        }
    }
        catch (Exception e) {
            System.out.println("File not found, exiting program.");
            return;
        }


    }

    public static boolean matches(char open, char close) {
            return (open == '(' && close == ')') ||
                     (open == '{' && close == '}') ||
                     (open == '[' && close == ']');
        }
    
}
