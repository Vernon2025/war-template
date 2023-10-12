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
    private Deck deck;
    private Deck playerOneDeck;
    private Deck playerTwoDeck;

    public War() {
        // Initializations here...
        deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();


        Deck[] playerDecks = deck.dealDeck();
        playerOneDeck = playerDecks[0];
        playerTwoDeck = playerDecks[1];


        // ...then run the event loop
        this.runEventLoop();
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop() {
        while (true) {
            if (playerOneDeck.getDeckSize() == 0) {
                System.out.println("Player 2 is the winner!");
            }
            if (playerTwoDeck.getDeckSize() == 0) {
                System.out.println("Player 1 is the winner!");
            }

            
        }
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
