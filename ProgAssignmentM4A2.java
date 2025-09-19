
import java.util.*;
import java.io.*;

public class ProgAssignmentM4A2 {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Java source file: ");
    String filename = input.nextLine();

    File file = new File(filename);

    if (file.exists()) {
      int keyWords = countKeywords(file);
      System.out.println("The number of keywords in " + filename
        + " is " + keyWords);
    } else {
      System.out.println("File " + filename + " does not exist");
    }
    input.close();
  }

  public static int countKeywords(File file) throws Exception {
    //Contains all of our key words
    String[] keywordString = {"abstract", "assert", "boolean",
        "break", "byte", "case", "catch", "char", "class", "const",
        "continue", "default", "do", "double", "else", "enum",
        "extends", "for", "final", "finally", "float", "goto",
        "if", "implements", "import", "instanceof", "int",
        "interface", "long", "native", "new", "package", "private",
        "protected", "public", "return", "short", "static",
        "strictfp", "super", "switch", "synchronized", "this",
        "throw", "throws", "transient", "try", "void", "volatile",
        "while", "true", "false", "null"};
    //puts them in a hashset for easier finding
    Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
    int count = 0;

    Scanner input = new Scanner(file);
    boolean inBlockComment = false; //Checks if we are in a block

    while (input.hasNextLine()) {
      String line = input.nextLine();

      
      int lineCommentIndex = line.indexOf("//");
      if (lineCommentIndex != -1) {
        line = line.substring(0, lineCommentIndex);
      }

      if (inBlockComment) {
        int endIndex = line.indexOf("*/");
        if (endIndex != -1) {
          line = line.substring(endIndex + 2);
          inBlockComment = false;
        } else {
          continue; 
        }
      }
      while (line.contains("/*")) {
        int start = line.indexOf("/*");
        int end = line.indexOf("*/", start + 2);
        if (end != -1) {
          line = line.substring(0, start) + line.substring(end + 2);
        } else {
          line = line.substring(0, start);
          inBlockComment = true;
          break;
        }
      }

      line = line.replaceAll("\"(\\\\.|[^\"\\\\])*\"", " ");
      //adds quotes around the words so it can be recognized by the hashset
      String[] tokens = line.split("\\W+");
      for (String token : tokens) {
        if (keywordSet.contains(token)) {
          count++;
        }
      }
    }

    input.close();
    return count;
  }
}
