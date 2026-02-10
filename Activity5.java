import java.io.BufferedWriter;
import java.io.FileWriter;  
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Activity5 {
    static String[] Subnames = new String[5];
    static double[][] Grades = new double[5][3];
    static int count = 0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Add Gradess for subject");
                System.out.println("2. Display Grades");
                System.out.println("3. Search Subject");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                choice = getValidInt(sc);

                switch (choice) {
                    case 1:
                        if (count < Subnames.length) {
                            addGrade(sc);
                        } else {
                            System.out.println("Maximum subjects reached.");
                        }
                        break;
                    case 2:
                        displayGrades();
                        break;
                    case 3:
                        searchGrades(sc);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        writeData();
                        System.out.println("BYE CODING");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        }
    }

    public static void addGrade(Scanner sc) {
        System.out.print("Subject: ");
        Subnames[count] = sc.nextLine().trim();

        System.out.print("Prelims: ");
        Grades[count][0] = getValidDouble(sc);

        System.out.print("Midterms: ");
        Grades[count][1] = getValidDouble(sc);

        System.out.print("Finals: ");
        Grades[count][2] = getValidDouble(sc);

        count++;
        System.out.println("Subject added!\n");
    }

    public static double getValidDouble(Scanner sc) {
        double val = 0;
        boolean valid = false;
        while (!valid) {
            try {
                val = sc.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
            } finally {
                sc.nextLine();
            }
        }
        return val;
    }

    public static int getValidInt(Scanner sc) {
        int val = 0;
        boolean valid = false;
        while (!valid) {
            try {
                val = sc.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            } finally {
                sc.nextLine();
            }
        }
        return val;
    }

    public static void writeData() {
        StringBuilder sb = new StringBuilder();
        sb.append("Subject,Prelims,Midterms,Finals,Average\n");
        for (int r = 0; r < count; r++) {
            double avg = (Grades[r][0] + Grades[r][1] + Grades[r][2]) / 3.0;
            sb.append(Subnames[r]);
            for (int c = 0; c < Grades[r].length; c++) {
                sb.append(",").append(Grades[r][c]);
            }
            sb.append(",").append(avg);
            sb.append("\n");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ira.csv"))) {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(sb.toString());
    }

    public static void displayGrades() {
        System.out.println("\n--- Displyed Grades ---");
        if (count == 0) {
            System.out.println("No grades available.");
        } else {
            System.out.printf("%-15s %-10s %-10s %-10s %-10s%n",
                    "Subject", "Prelims", "Midterms", "Finals", "Average");
            for (int r = 0; r < count; r++) {
                double avg = (Grades[r][0] + Grades[r][1] + Grades[r][2]) / 3.0;
                System.out.printf("%-15s %-10.2f %-10.2f %-10.2f %-10.2f%n",
                        Subnames[r], Grades[r][0], Grades[r][1], Grades[r][2], avg);
            }
        }
     
    }

    public static void searchGrades(Scanner sc) {
        System.out.print("Enter subject to search: ");
        String search = sc.nextLine().trim();
        boolean found = false;
        for (int r = 0; r < count; r++) {
            if (Subnames[r].equalsIgnoreCase(search)) {
                double avg = (Grades[r][0] + Grades[r][1] + Grades[r][2]) / 3.0;
                System.out.printf("Found: %s | Prelims: %.2f | Midterms: %.2f | Finals: %.2f | Average: %.2f%n",
                        Subnames[r], Grades[r][0], Grades[r][1], Grades[r][2], avg);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Subject not found.");
        }
    }
}