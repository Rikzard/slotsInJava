import java.util.Random;
import java.util.Scanner;

public class Slot_Machine {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Variables
        int bal = 100;
        String playAgain;
        int bet;

        System.out.println("***********************");
        System.out.println("Welcome To Slot Machine");
        System.out.println("***********************");


        while ((bal>0)){
                System.out.println("\nYou current Balance :"+ bal);
                System.out.print("Enter bet in $ :");
                bet = sc.nextInt();
                sc.nextLine();

                if(bet>bal){

                    System.out.println("** Bet cannot be greater than balance! **");
                    System.out.println("***********************");
                } else if(bet<=0){
                    System.out.println("Bet cannot be negative or 0");
            }

                 else if (bet<=bal){

                    bal -= bet;
                    System.out.println("Spinning...");
                    System.out.println(" **************");
                    String[] ro = emoji();
                    System.out.println("|"+ro[0] + " | "+ro[1]+" | "+ro[2]+" |");
                    System.out.println(" **************");

                   int winnings = getPayout(ro, bet);
                   if(winnings>bet){
                       System.out.println("You won");
                   }

                    System.out.print("Do you want to continue:");
                    playAgain = sc.nextLine().toLowerCase();

                    if(!playAgain.equals("yes")){
                        System.out.println("See ya soon!");
                        System.out.println("***********************");
                        break;
                    }
                }
            }
    }

          static String[] emoji(){
         String[] symbols = {"😎", "😜", "😍", "😂", "😊"};
         String[] rows = new String[3];
        Random r = new Random();

        for(int i=0; i<3 ; i++){
            rows[i] = symbols[r.nextInt(1, 5)];
        }
         return rows;
          }
          static int getPayout(String[] rows, int bet){

          if( (rows[0].equals(rows[1])) && (rows[1].equals(rows[2])) ) {
              bet = bet * 2;
          }
          return bet;
    }
}
