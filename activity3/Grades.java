package activity3;
import java.util.Scanner;
public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        int[][] grades = new int[3][3];
        String[] subjects = {"COMPRO2", "DSA", "OOP"};
        String[] terms = {"PRELIMS", "MIDTERMS", "FINALS"};

        String anotherGrade = "y";

        while (anotherGrade.equalsIgnoreCase("y")) {
            System.out.println("\n[1] Enter Grades");
            System.out.println("[2] Display Grades");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("\n[1] COMPRO2");
                System.out.println("[2] DSA");
                System.out.println("[3] OOP");
                System.out.print("Select Subject: ");
                int subChoice = sc.nextInt();

          
                if (subChoice >= 1 && subChoice <= 3) {
                    int row = subChoice - 1;
                    
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Enter " + terms[i] + ": ");
                        grades[row][i] = sc.nextInt();
                    }
                } else {
                    System.out.println("Invalid Subject!");
                }

            } else if (choice == 2) {
                // Table Header
                System.out.printf("%n%-15s %-10s %-10s %-10s%n", "SUBJECT", "PRELIM", "MIDTERM", "FINAL");
              

              
                for (int i = 0; i < 3; i++) {
                    System.out.printf("%-15s ", subjects[i]); 
                    for (int j = 0; j < 3; j++) {
                        System.out.printf("%-10d ", grades[i][j]); 
                    }
                    System.out.println(); 
                }

            } else if (choice == 3) {
                System.out.println("Thank you!");
                break; 
            }

            
            sc.nextLine(); 
            System.out.print("\nGo back to main menu? (y/n): ");
            anotherGrade = sc.nextLine();
        }
        
        sc.close();
    }
}