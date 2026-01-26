package activity2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[][] matrix3by4 = new double[3][4];
        double[][] matrix4by4 = new double[4][4];

        System.out.println("Enter a 3 by 4 matrix row by row");

        for (int i = 0; i < matrix3by4.length; i++) {
            for (int h = 0; h < matrix3by4[i].length; h++) {
                matrix3by4[i][h] = input.nextDouble();
            }
        }

        for (int i = 0; i < matrix3by4.length; i++) {
            System.out.println("The sum of column " + i + " is " + sumColumn(matrix3by4, i));
        }
    }

    public static double sumColumn(double[][] m, int columnIndex) {
        Scanner input = new Scanner(System.in);
        double sum = 0;
        for (int row = 0; row < m.length; row++) {
            
        }
        return sum;
    }
}


