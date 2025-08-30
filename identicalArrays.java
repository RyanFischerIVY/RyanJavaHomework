import java.util.Scanner;

public class identicalArrays {
    public static void main(String[] args) {

        int rows = 3;
        int cols = 3;
        Scanner input = new Scanner(System.in);
        int[][] m1 = new int[rows][cols];
        int[][] m2 = new int[rows][cols];

        System.out.println("Enter items for the first list: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number for row " + (i + 1) + " column " + (j + 1) + ": ");
                m1[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter items for the second list: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number for row " + (i + 1) + " column " + (j + 1) + ": ");
                m2[i][j] = input.nextInt();
            }
        }

        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical.");
        }
        else {
            System.out.println("The two arrays are not identical.");
        }
        


        input.close();  
    }

    public static boolean equals (int[][] m1, int[][] m2) {
        boolean found = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!found) {
                    return false;
                }
                found = false;
                for (int a = 0; a < 3; a++) {
                    if (found) {
                        break;
                    }
                    for (int b = 0; b < 3; b++) {
                        if (m1[i][j] == m2[a][b]) {
                            found = true;
                            break;
                        }
                        else {
                            found = false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
