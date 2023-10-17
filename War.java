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
        this.runEventLoop(playerOneDeck, playerTwoDeck);
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck playerOneDeck, Deck playerTwoDeck) {
        boolean isRunning = true;

        Card playerOneCard = playerOneDeck.dealCardFromDeck();
        Card playerTwoCard = playerTwoDeck.dealCardFromDeck();

        while (isRunning) {
            if (playerOneDeck.getDeckSize() == 0) {
                System.out.println("Player 2 is the winner!");
            } else if(playerTwoDeck.getDeckSize() == 0) {
                System.out.println("Player 1 is the winner!");
            } else {



                System.out.println("War game has begun!");
                System.out.println("Player 1 Dealt Card: " + playerOneDeck.dealCardFromDeck()); 
                System.out.println("Player 2 Dealt Card: " + playerTwoDeck.dealCardFromDeck()); 
                System.out.println("Cards have been dealt");

                if(playerOneCard.rank() > playerTwoCard.rank()) {
                    System.out.println("Player 1 takes all the cards!");
                } else if(playerOneCard.rank() < playerTwoCard.rank()) {
                    System.out.println("Player 2 takes all the cards!");
                }

            }
            isRunning = false;
            
        }
    }

    /**
     * The main method is called when Java starts your program
     */
    public static void main(String[] args) {
        War war = new War();
    }

}
