import java.util.Scanner;

public class MagicMatrix {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[5][5];

        System.out.println("Enter 25 numbers for 5x5 matrix:");

        int count = 1;

        // Taking input one by one
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("Enter number " + count + ": ");
                matrix[i][j] = input.nextInt();
                count++;
            }
        }

        // Reference sum (first row)
        int magicSum = 0;
        for (int j = 0; j < 5; j++) {
            magicSum += matrix[0][j];
        }

        boolean isMagic = true;

        // Check rows
        for (int i = 0; i < 5; i++) {
            int rowSum = 0;
            for (int j = 0; j < 5; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                isMagic = false;
                break;
            }
        }

        // Check columns
        for (int j = 0; j < 5 && isMagic; j++) {
            int colSum = 0;
            for (int i = 0; i < 5; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                isMagic = false;
                break;
            }
        }

        // Check main diagonal
        int diag1 = 0;
        for (int i = 0; i < 5; i++) {
            diag1 += matrix[i][i];
        }
        if (diag1 != magicSum) {
            isMagic = false;
        }

        // Check second diagonal
        int diag2 = 0;
        for (int i = 0; i < 5; i++) {
            diag2 += matrix[i][4 - i];
        }
        if (diag2 != magicSum) {
            isMagic = false;
        }

        // Final Result
        if (isMagic) {
            System.out.println("It is a Magic Matrix ");
        } else {
            System.out.println("It is NOT a Magic Matrix ");
        }

        input.close();
    }
}