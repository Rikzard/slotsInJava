public class Dice{
    Scanner sc = new Scanner(System.in);
    public state void main(String[] args){

        int total = 0;
        Random r = new Random();
        System.out.print("Enter Number of dice to be rolled :");

        int no = sc.nextInt();

        for(int i = 0; i < no ; i++){
            int die = r.nextInt(1,7);
            println("Die rolled :" + die);
            total += die;
        }

        sc.close();
    }
}