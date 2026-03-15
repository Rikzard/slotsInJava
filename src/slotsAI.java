import java.util.Random;
import java.util.Scanner;

public class slotsAI {

    // 1. Define symbols as a constant at the class level
    static final String[] SYMBOLS = {"😎", "😜", "😍", "😂", "😊"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int balance = 100;
        int bet;
        String playAgain;

        System.out.println("*************************");
        System.out.println(" Welcome To Slot Machine ");
        System.out.println("*************************");

        // Main Game Loop
        while (balance > 0) {
            System.out.println("\nCurrent Balance: $" + balance);

            // 2. Input Validation Loop: Force a valid bet
            while (true) {
                System.out.print("Enter bet amount: $");
                if (sc.hasNextInt()) {
                    bet = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    if (bet > balance) {
                        System.out.println("❌ You don't have enough money!");
                    } else if (bet <= 0) {
                        System.out.println("❌ Bet must be greater than 0.");
                    } else {
                        break; // Valid bet, exit validation loop
                    }
                } else {
                    System.out.println("❌ Please enter a number.");
                    sc.next(); // Clear invalid input
                }
            }

            // Deduct bet immediately
            balance -= bet;

            System.out.println("Spinning...");
            System.out.println(" ***************");

            // 3. Generate Spin
            String[] row = getSpinResult(random);
            System.out.println(" | " + row[0] + " | " + row[1] + " | " + row[2] + " |");
            System.out.println(" ***************");

            // 4. Calculate Winnings (Return the amount won instead of updating balance inside)
            int winnings = calculateWinnings(row, bet);

            if (winnings > 0) {
                System.out.println("🎉 JACKPOT! You won $" + winnings);
                balance += winnings;
            } else {
                System.out.println("😞 Better luck next time.");
            }

            // Check if user is broke before asking to play again
            if (balance <= 0) {
                System.out.println("\n🚫 You are out of money! Game Over.");
                break;
            }

            System.out.print("\nDo you want to continue? (yes/no): ");
            playAgain = sc.nextLine().toLowerCase();

            if (!playAgain.equals("yes") && !playAgain.equals("y")) {
                System.out.println("\nSee ya soon! You left with $" + balance);
                break;
            }
        }

        sc.close(); // Good practice to close scanner
    }

    // Generate the random row
    static String[] getSpinResult(Random r) {
        String[] row = new String[3];
        for (int i = 0; i < 3; i++) {
            // 5. Fix: Use standard nextInt(bound) to include index 0
            row[i] = SYMBOLS[r.nextInt(SYMBOLS.length)];
        }
        return row;
    }

    // Calculate payouts
    static int calculateWinnings(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            // Winning logic: Return the total payout (Bet * Multiplier)
            return bet * 2;
        }
        return 0; // No win
    }
}
