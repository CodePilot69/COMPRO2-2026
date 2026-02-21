import java.util.Scanner;

public class Activity2diagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double [][] matrix = new double[4][4];

        System.out.println("Enter a 4 by 4 matrix row by row:");

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }

        System.out.println("Sum of the numbers in the diagonal:  " + sumMajorDiagonal(matrix));
    }

    
    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for(int i = 0; i < m.length; i++) {
            sum += m[i][i];  
        }
        return sum;
    }
}