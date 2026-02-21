public class Activity1 {
    public static void main(String[] args) {
        
        int[] theaterRow = new int[8]; 

        
        theaterRow[3] = 1; 

        for (int i = 0; i < theaterRow.length; i++) {
            System.out.print("Seat " + i + ": " + theaterRow[i]);
        }

       
        int availableSeats = 0;
        for (int seat : theaterRow) {
            if (seat == 0) {
                availableSeats++;
            }
        }
        System.out.println("Available seats: " + availableSeats);
    }
}