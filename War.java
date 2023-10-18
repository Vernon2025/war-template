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

        System.out.println(playerOneDeck.getDeckSize());

        // ...then run the event loop
        this.runEventLoop(playerOneDeck, playerTwoDeck);
    }

    /**
     * This is the game's event loop. The code in here should come
     * from the War flowchart you created for this game
     */
    public void runEventLoop(Deck playerOneDeck, Deck playerTwoDeck) {
        boolean isRunning = true;

        System.out.println("War game has begun!");

        while (isRunning) {
            if (playerOneDeck.getDeckSize() == 0) {
                System.out.println("Player 2 is the winner!");
                isRunning = false;
            } else if (playerTwoDeck.getDeckSize() == 0) {
                System.out.println("Player 1 is the winner!");
                isRunning = false;
            } else {
                System.out.println("Player 1 Deck Size: " + playerTwoDeck.getDeckSize());
                System.out.println("Player 2 Deck Size: " + playerTwoDeck.getDeckSize());
                Card playerOneCard = playerOneDeck.dealCardFromDeck();
                Card playerTwoCard = playerTwoDeck.dealCardFromDeck();

                System.out.println("Player 1 Dealt Card: " + playerOneCard);
                System.out.println("Player 2 Dealt Card: " + playerTwoCard);
                System.out.println("Cards have been dealt");

                if (playerOneCard.rank() > playerTwoCard.rank()) {

                    System.out.println("Player 1 takes all the cards!");
                    playerOneDeck.addCardToDeck(playerOneCard);
                    playerOneDeck.addCardToDeck(playerTwoCard);
                    System.out.println(playerOneDeck.getDeckSize());
                    System.out.println(playerTwoDeck.getDeckSize());

                } else if (playerOneCard.rank() < playerTwoCard.rank()) {

                    System.out.println("Player 2 takes all the cards!");
                    playerTwoDeck.addCardToDeck(playerOneCard);
                    playerTwoDeck.addCardToDeck(playerTwoCard);
                    System.out.println(playerOneDeck.getDeckSize());
                    System.out.println(playerTwoDeck.getDeckSize());

                } else if(playerOneCard.rank() == playerTwoCard.rank()) {
                    System.out.println("WARRRR!!!");
                    Card newPlayerOneCard = playerOneDeck.dealCardFromDeck();
                    Card newPlayerTwoCard = playerTwoDeck.dealCardFromDeck();

                    if(newPlayerOneCard.rank() > newPlayerTwoCard.rank()) {
                        
                        int temp = playerOneDeck.getDeckSize() + 4;
                        System.out.println("Player 1 takes all the cards!");
                        playerOneDeck.addCardToDeck(newPlayerOneCard);
                        playerOneDeck.addCardToDeck(newPlayerTwoCard);
                        System.out.println(temp);
                        System.out.println(playerTwoDeck.getDeckSize());

                    } else if (newPlayerOneCard.rank() > newPlayerTwoCard.rank()) {
                        int temp = playerTwoDeck.getDeckSize() + 4;
                        System.out.println("Player 1 takes all the cards!");
                        playerTwoDeck.addCardToDeck(newPlayerOneCard);
                        playerTwoDeck.addCardToDeck(newPlayerTwoCard);
                        System.out.println(playerTwoDeck.getDeckSize());
                        System.out.println(temp);

                    }
                    
                }
                System.out.println("_____________________________________________");
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
