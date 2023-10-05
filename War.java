import java.util.Scanner;

/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War {
    /**
     * Constructor for the game
     * Include your initialization here -- card decks, shuffling, etc
     * Run the event loop after you've done the initializations
     */

    Deck deck = new Deck();
    Scanner input = new Scanner(System.in);

    public War() {
        // Initializations here...
        deck.initializeNewDeck();
        deck.shuffle();
        deck.dealDeck();

        System.out.println(deck.getDeckSize());

        // ...then run the event loop
        this.runEventLoop();
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {



        boolean running = true;
        System.out.print("Player 1 Name: ");
        String playerOneName = input.nextLine();
        System.out.print("Player 2 Name: ");
        String playerTwoName = input.nextLine();

        Player playerOne = new Player(playerOneName);
        Player playerTwo = new Player(playerTwoName);

        playerTwoName = input.nextLine();
        System.out.println("\nWelcome to War " + playerOne.name() + " and " + playerTwo.name() + "!");

        while (running) {
            System.out.println("\nBoth players deal cards");
            running = false;
        }

    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
