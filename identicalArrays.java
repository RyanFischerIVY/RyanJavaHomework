import java.util.Scanner;

//identicalArrays
//Ryan Fischer
//8/31/25
//Professor Parrot
//SDEV 200

public class identicalArrays {
    public static void main(String[] args) {

        int rows = 3; //Creates some important variables
        int cols = 3;
        Scanner input = new Scanner(System.in);
        int[][] m1 = new int[rows][cols];
        int[][] m2 = new int[rows][cols];

        System.out.println("Enter items for the first list: "); //Fills up m1 with user input
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number for row " + (i + 1) + " column " + (j + 1) + ": ");
                m1[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter items for the second list: "); //Fills up m2 with user input
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number for row " + (i + 1) + " column " + (j + 1) + ": ");
                m2[i][j] = input.nextInt();
            }
        }
        //Checks if they have the same values
        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical.");
        }
        else {
            System.out.println("The two arrays are not identical.");
        }
        


        input.close();  
    }

    public static boolean equals(int[][] m1, int[][] m2) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            int count1 = 0;
            int count2 = 0;
            int value = m1[i][j];
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    if (m1[a][b] == value) count1++;
                }
            }
            for (int a = 0; a < 3; a++) {
                for (int b = 0; b < 3; b++) {
                    if (m2[a][b] == value) count2++;
                }
            }
            if (count1 != count2) return false;
        }
    }
    return true;
    }

}
