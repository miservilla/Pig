import java.util.Scanner;

/**
 * @version 2016-09-11
 * @author Michael Servilla
 */
public class Pig {

    /**
     * The Pig game for two players, or against the computer.
     * @param args Command-Line arguments are ignored.
     */

    public static void main(String[] args){

        int pigPlayer1 = 0;
        int pigPlayer2 = 0;
        int playerCounter = 0;
        int turnTotal;

        while (pigPlayer1 < 100 && pigPlayer2 < 100) {
            System.out.println("\nScore: " + pigPlayer1 + "-" + pigPlayer2 + ".");
            playerCounter++;

            if (playerCounter % 2 == 0) {
                System.out.println("\nPig player 2's turn.");
                turnTotal = PlayerRoll();
                pigPlayer2 += turnTotal;
            } else {
                System.out.println("\nPig player 1's turn.");
                turnTotal = PlayerRoll();
                pigPlayer1 += turnTotal;
            }
        }
        if (pigPlayer1 > pigPlayer2){
            System.out.println("Congratulations Pig player 1, you won!");
        }
        else {
            System.out.println("Congratulations Pig player 2, you won!");
        }

    }
    //Method to roll the dice.
    private static int PlayerRoll() {
        String playAgain = "Y";
        int turnTotal = 0;
        while (playAgain.equalsIgnoreCase("Y")) {
            int rollAmount = RandomNumber();
            System.out.println("You rolled a " + rollAmount + ".");
            if (rollAmount == 1) {
                turnTotal = 0;
                System.out.println("Your total this turn is " + turnTotal + ".");
                return turnTotal;
            } else turnTotal += rollAmount;
            System.out.println("Your total this turn is " + turnTotal + ".");
            System.out.println("Roll again (y/n): ");
            playAgain = PlayAgain();
        }
        return turnTotal;
    }
    //Method to generate random number.
    private static int RandomNumber () {
        int rand = (int) (Math.random() * 6) + 1;
        return rand;
    }
    //Method for input error control (needs to be either y/n).
    private static String PlayAgain() {
        Scanner scanIn = new Scanner(System.in);
        String playAgain = scanIn.next();
        while ((!playAgain.equalsIgnoreCase("Y")) && (!playAgain.equalsIgnoreCase("N"))) {
            System.out.println("I don't understand your response, please try again.");
            playAgain = scanIn.next();
        }
        return playAgain;
    }
}
