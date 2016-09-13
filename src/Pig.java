import java.util.Scanner;

/**
 * @version 2016-09-11
 * @author Michael Servilla
 */
public class Pig {

    /**
     * The Pig game for two players, or against the computer playing as Pig player 2.
     * @param args Command-Line arguments are ignored.
     */

    public static void main(String[] args){

        int pigPlayer1 = 0;
        int pigPlayer2 = 0;
        int playerCounter = 0;
        int turnTotal;

        System.out.println("Would you like the computer to be 'Pig player 2'?");
        String computerPigPlayer2 = YesNo();

        while (pigPlayer1 < 100 && pigPlayer2 < 100) {
            System.out.println("\nScore: " + pigPlayer1 + "-" + pigPlayer2 + ".");
            playerCounter++;

            if (computerPigPlayer2.equalsIgnoreCase("N")) {
                if ((playerCounter % 2 == 0)){
                    System.out.println("\nPig player 2's turn.");
                    turnTotal = PlayerRoll();
                    pigPlayer2 += turnTotal;
                } else {
                    System.out.println("\nPig player 1's turn.");
                    turnTotal = PlayerRoll();
                    pigPlayer1 += turnTotal;
                }
            } else {
                    if (playerCounter % 2 != 0) {
                        System.out.println("\nPig player 1's turn.");
                        turnTotal = PlayerRoll();
                        pigPlayer1 += turnTotal;
                    } else {
                        System.out.println("\nComputer's turn.");
                        turnTotal = ComputerRoll();
                        pigPlayer2 += turnTotal;
                    }
            }
        }
        if (pigPlayer1 > pigPlayer2){
            System.out.println("Congratulations Pig player 1, you won!");
        }
        else {
            if (computerPigPlayer2.equalsIgnoreCase("Y")) {
                System.out.printf("The computer won!");
            }else {
                System.out.println("Congratulations Pig player 2, you won!");
            }
        }
    }

    /**Method to roll the dice. It sums each roll into a running total.
     * @return turnTotal, the running total of each player's turn.
     */
    private static int PlayerRoll() {
        String playAgain;
        int turnTotal = 0;
        do {
            int rollAmount = RandomNumber();
            System.out.println("You rolled a " + rollAmount + ".");
            if (rollAmount == 1) {
                turnTotal = 0;
                System.out.println("Your total this turn is " + turnTotal + ".");
                return turnTotal;
            } else turnTotal += rollAmount;
            System.out.println("Your total this turn is " + turnTotal + ".");
            System.out.println("Roll again (y/n): ");
            playAgain = YesNo();
        }
        while (playAgain.equalsIgnoreCase("Y"));
        return turnTotal;
    }

    /**Method to generate random number.
     * @return rand, a "pseudorandom" number from 1 to 6, inclusive.
     */
    private static int RandomNumber() {
        int rand = (int) (Math.random() * 6) + 1;
        return rand;
    }

    /**Method for input error control (needs to be either y/n).
     * @return playAgain, a string value to denote whether player wishes to
     * to roll again.
     */
    private static String YesNo() {
        Scanner scanIn = new Scanner(System.in);
        String playAgain = scanIn.next();
        while ((!playAgain.equalsIgnoreCase("Y")) && (!playAgain.equalsIgnoreCase("N"))) {
            System.out.println("I don't understand your response, please try again.");
            playAgain = scanIn.next();
        }
        return playAgain;
    }

    /**Method for random number of times computer will roll the dice
     * , and then calls RandomNumber to generate turnTotal, a running score
     * for the computer.
     * @return turnTotal, the running total of computer's turn.
     */
    private static int ComputerRoll() {
        int turnTotal = 0;
        double computerPlayAgain;
        do {
            computerPlayAgain = Math.random();
            int rollAmount = RandomNumber();
            System.out.println("Computer rolled a " + rollAmount + ".");
            if (rollAmount == 1) {
                turnTotal = 0;
                System.out.println("Computer's total this turn is " + turnTotal + ".");
                return turnTotal;
            } else turnTotal += rollAmount;
            System.out.println("Computer's total this turn is " + turnTotal + ".");
        }
        while (computerPlayAgain < 0.8);
        return turnTotal;
    }
}
