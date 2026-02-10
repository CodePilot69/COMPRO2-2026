import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Activity4 {
    static String[] Subs;
    static String[][] Term;

    public static void main(String[] args) {
        Subs = new String[5];          
        Term = new String[5][3];       

        Scanner sc = new Scanner(System.in);

        for (int r = 0; r < Subs.length; r++) {
            System.out.print("Enter Subject " + (r + 1) + ": ");
            Subs[r] = sc.nextLine();

            
            String[] termNames = {"Prelim", "Midterm", "Final"};
            for (int t = 0; t < 3; t++) {
                System.out.print("Enter grade for " + termNames[t] + ": ");
                try {
                    Term[r][t] = sc.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input");
                    sc.nextLine(); 
                }
            }
            System.out.println();
            
            sc.close();
        }

        
        writeData();
    }

    public static void writeData() {
        StringBuilder sb = new StringBuilder();

       
        sb.append("Subject,Prelim,Midterm,Final\n");
        for (int r = 0; r < Subs.length; r++) {
            if (Subs[r] == null) break;

            sb.append(Subs[r]);
            for (int c = 0; c < Term[r].length; c++) {
                sb.append(",").append(Term[r][c]);
            }
            sb.append("\n");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("grades.csv"))) {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(sb.toString());
    }
}