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
        int round = 1;

        System.out.println("War game has begun!");

        while (isRunning) {

            System.out.println("Round " + round);

            if (playerOneDeck.getDeckSize() == 0) {
                System.out.println("Player 2 is the winner!");
                isRunning = false;
            } else if (playerTwoDeck.getDeckSize() == 0) {
                System.out.println("Player 1 is the winner!");
                isRunning = false;
            } else {
                System.out.println("Player 1 Deck Size: " + playerOneDeck.getDeckSize());
                System.out.println("Player 2 Deck Size: " + playerTwoDeck.getDeckSize());

                Card playerOneCard = playerOneDeck.dealCardFromDeck();
                Card playerTwoCard = playerTwoDeck.dealCardFromDeck();

                System.out.println("Player 1 Dealt Card: " + playerOneCard);
                System.out.println("Player 2 Dealt Card: " + playerTwoCard);
                System.out.println("Cards have been dealt");

                // Inside the game loop
                if (playerOneCard.rank() > playerTwoCard.rank()) {
                    System.out.println("Player 1 takes all the cards!");
                    playerOneDeck.addCardToDeck(playerOneCard);
                    playerOneDeck.addCardToDeck(playerTwoCard);
                } else if (playerOneCard.rank() < playerTwoCard.rank()) {
                    System.out.println("Player 2 takes all the cards!");
                    playerTwoDeck.addCardToDeck(playerOneCard);
                    playerTwoDeck.addCardToDeck(playerTwoCard);
                } else {
                    System.out.println("Warrr!");

                    for (int i = 0; i < 3; i++) {
                        playerOneDeck.dealCardFromDeck();
                        playerTwoDeck.dealCardFromDeck();
                    }

                    Card newPlayerOneCard = playerOneDeck.dealCardFromDeck();
                    Card newPlayerTwoCard = playerTwoDeck.dealCardFromDeck();

                    System.out.println("Player 1 New Card: " + newPlayerOneCard);
                    System.out.println("Player 2 New Card: " + newPlayerTwoCard);

                    if (newPlayerOneCard.rank() > newPlayerTwoCard.rank()) {
                        System.out.println("Player 1 wins the war!");
                        playerOneDeck.addCardToDeck(playerOneCard);
                        playerOneDeck.addCardToDeck(playerTwoCard);
                        playerOneDeck.addCardToDeck(newPlayerOneCard);
                        playerOneDeck.addCardToDeck(newPlayerTwoCard);
                    } else if (newPlayerOneCard.rank() < newPlayerTwoCard.rank()) {
                        System.out.println("Player 2 wins the war!");
                        playerTwoDeck.addCardToDeck(playerOneCard);
                        playerTwoDeck.addCardToDeck(playerTwoCard);
                        playerTwoDeck.addCardToDeck(newPlayerOneCard);
                        playerTwoDeck.addCardToDeck(newPlayerTwoCard);
                    }
                }

                round++;

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
