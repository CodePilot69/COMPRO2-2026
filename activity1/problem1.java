package activity1;

public class problem1 {
    public static void main(String[] args) {
        int availableSeats = 0;
    
        int[] theaterRow = new int[8];
        theaterRow[3] = 1;
        for(int i = 0;i < theaterRow.length;i++){
            
            System.out.printf("%-5d ",theaterRow[i]);
            
            if(theaterRow[i] == 1){
                availableSeats++;
                
            }
        }
        System.out.println("\n");
        System.out.println(availableSeats + " Availeble seats " );



    }
}
