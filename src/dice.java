import java.util.Scanner;
import java.util.Random;
public class dice{
   static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        int total = 0;
        Random r = new Random();
        System.out.print("Enter Number of dice to be rolled :");

        int no = sc.nextInt();

        for(int i = 0; i < no ; i++){
            int die = r.nextInt(1,7);
            System.out.println("Die rolled :" + die);
            total += die;
            showDie(die);
        }
        System.out.println("Total is "+ total);

    }

    static void showDie(int die){
        String die1 = """
       ___________
       |         |
       |    ●    |
       |         |
       -----------
       """;
        String die2 = """
       ___________
       | ●       |
       |         |
       |       ● |
       -----------
       """;
        String die3 = """
       ___________
       | ●       |
       |    ●    |
       |       ● |
       -----------
       """;
        String die4 = """
       ___________
       | ●     ● |
       |         |
       | ●     ● |
       -----------
       """;
        String die5 = """
       ___________
       | ●     ● |
       |    ●    |
       | ●     ● |
       -----------
       """;
        String die6 = """
       ___________
       |●      ● |
       |●      ● |
       |●      ● |
       -----------
       """;
     switch(die) {
         case 1 -> System.out.println(die1);
         case 2 -> System.out.println(die2);
         case 3 -> System.out.println(die3);
         case 4 -> System.out.println(die4);
         case 5 -> System.out.println(die5);
         case 6 -> System.out.println(die6);
     }
    }
}