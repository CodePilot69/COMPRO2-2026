
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;

public class Prac {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter First name: ");
            sb.append("First Name: " + sc.nextLine() + "\n");
            
            System.out.print("Enter Last name: ");
            sb.append("Enter Last name: " + sc.nextLine() + "\n");

            System.out.print("Enter Age: ");
            sb.append("Enter Age: " + sc.nextLine() + "\n");

            System.out.print("Enter Email: ");
            sb.append("Enter Email: " + sc.nextLine() + "\n");

            System.out.print("Enter Phone: ");
            sb.append("Enter Phone: " + sc.nextLine() + "\n");

        } catch (InputMismatchException e) {
            System.out.print("Invalid input");
        }

        try (FileWriter fw = new FileWriter("data.txt")) {
            fw.write(sb.toString());
            System.out.println("Data is saved...");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}