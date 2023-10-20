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

    private final Deck deck;
    private final Deck playerOneDeck;
    private final Deck playerTwoDeck;

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

        while (round <= 300) {

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
                    Card playerOneWarCard1 = playerOneDeck.dealCardFromDeck();
                    Card playerTwoWarCard1 = playerTwoDeck.dealCardFromDeck();
                    Card playerOneWarCard2 = playerOneDeck.dealCardFromDeck();
                    Card playerTwoWarCard2 = playerTwoDeck.dealCardFromDeck();
                    Card playerOneWarCard3 = playerOneDeck.dealCardFromDeck();
                    Card playerTwoWarCard3 = playerTwoDeck.dealCardFromDeck();
                    Card newPlayerOneWarCard = playerOneDeck.dealCardFromDeck();
                    Card newPlayerTwoWarCard = playerTwoDeck.dealCardFromDeck();

                    System.out.println("Player 1 New Card: " + newPlayerOneWarCard);
                    System.out.println("Player 2 New Card: " + newPlayerTwoWarCard);

                    if (newPlayerOneWarCard.rank() > newPlayerTwoWarCard.rank()) {
                        System.out.println("Player 1 wins the war!");

                        playerOneDeck.addCardToDeck(playerOneCard);
                        playerOneDeck.addCardToDeck(playerTwoCard);
                        playerOneDeck.addCardToDeck(newPlayerOneWarCard);
                        playerOneDeck.addCardToDeck(newPlayerTwoWarCard);
                        playerOneDeck.addCardToDeck(playerOneWarCard1);
                        playerOneDeck.addCardToDeck(playerTwoWarCard1);
                        playerOneDeck.addCardToDeck(playerOneWarCard2);
                        playerOneDeck.addCardToDeck(playerTwoWarCard2);
                        playerOneDeck.addCardToDeck(playerOneWarCard3);
                        playerOneDeck.addCardToDeck(playerTwoWarCard3);
                    } else if (newPlayerOneWarCard.rank() < newPlayerTwoWarCard.rank()) {
                        System.out.println("Player 2 wins the war!");
                        playerTwoDeck.addCardToDeck(playerOneCard);
                        playerTwoDeck.addCardToDeck(playerTwoCard);
                        playerTwoDeck.addCardToDeck(newPlayerOneWarCard);
                        playerTwoDeck.addCardToDeck(newPlayerTwoWarCard);
                        playerTwoDeck.addCardToDeck(playerOneWarCard1);
                        playerTwoDeck.addCardToDeck(playerTwoWarCard1);
                        playerTwoDeck.addCardToDeck(playerOneWarCard2);
                        playerTwoDeck.addCardToDeck(playerTwoWarCard2);
                        playerTwoDeck.addCardToDeck(playerOneWarCard3);
                        playerTwoDeck.addCardToDeck(playerTwoWarCard3);
                    } else {
                        if (playerOneDeck.getDeckSize() < 4) {
                            System.out.println("Player 1 doesn't have enough cards for a WAR. Player 2 wins!");
                            isRunning = false;
                        } else if (playerTwoDeck.getDeckSize() < 4) {
                            System.out.println("Player 2 doesn't have enough cards for a WAR. Player 1 wins!");
                            isRunning = false;
                        }
                    }
                }

                if (isRunning) {
                    round++; // Increment round only if the game is still running
                }

                if (round == 300) {
                    if (playerOneDeck.getDeckSize() > playerTwoDeck.getDeckSize()) {
                        System.out.println("PLAYER 1 WINS!");
                    } else {
                        System.out.println("PLAYER 2 WINS!");
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
