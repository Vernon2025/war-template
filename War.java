import java.util.ArrayList;
import java.util.List;

public class War {
    private final Deck deck;
    private final Deck playerOneDeck;
    private final Deck playerTwoDeck;

    public War() {
        deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();

        Deck[] playerDecks = deck.dealDeck();
        playerOneDeck = playerDecks[0];
        playerTwoDeck = playerDecks[1];

        playGame();
    }

    public void playGame() {
        System.out.println("War game has begun!");
        int round = 1;

        while (round <= 300) {
            System.out.println("Round " + round);
            if (playerOneDeck.getDeckSize() == 0) {
                declareWinner("Player 2");
                break;
            } else if (playerTwoDeck.getDeckSize() == 0) {
                declareWinner("Player 1");
                break;
            }

            playRound();
            round++;
        }

        if (playerOneDeck.getDeckSize() > playerTwoDeck.getDeckSize()) {
            declareWinner("Player 1");
        } else if (playerOneDeck.getDeckSize() < playerTwoDeck.getDeckSize()) {
            declareWinner("Player 2");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public void playRound() {

        System.out.println("Player 1 original deck size: " + playerOneDeck.getDeckSize());
        System.out.println("Player 2 original deck size: " + playerTwoDeck.getDeckSize());

        Card playerOneCard = playerOneDeck.dealCardFromDeck();
        Card playerTwoCard = playerTwoDeck.dealCardFromDeck();

        System.out.println("Player 1 Dealt Card: " + playerOneCard.toString().toUpperCase());
        System.out.println("Player 2 Dealt Card: " + playerTwoCard.toString().toUpperCase());;

        if (playerOneCard.rank() > playerTwoCard.rank()) {
            playerOneDeck.addCardToDeck(playerOneCard);
            playerOneDeck.addCardToDeck(playerTwoCard);
            System.out.println("Player 1 takes all the cards!");
        } else if (playerOneCard.rank() < playerTwoCard.rank()) {
            playerTwoDeck.addCardToDeck(playerOneCard);
            playerTwoDeck.addCardToDeck(playerTwoCard);
            System.out.println("Player 2 takes all the cards!");
        } else {
            handleWar(playerOneCard,playerTwoCard);
        }

        System.out.println("Player 1 new deck size: " + playerOneDeck.getDeckSize());
        System.out.println("Player 2 new deck size: " + playerTwoDeck.getDeckSize());

        System.out.println("_____________________________________________");
    }

    public void handleWar(Card playerOneCard, Card playerTwoCard) {
        if (playerOneDeck.getDeckSize() < 4) {
            declareWinner("Player 2");
            return;
        } else if (playerTwoDeck.getDeckSize() < 4) {
            declareWinner("Player 1");
            return;
        }

        List<Card> warCardsPlayed = new ArrayList<Card>();

        for (int i = 0; i < 3; i++) {
            warCardsPlayed.add(playerOneDeck.dealCardFromDeck());
            warCardsPlayed.add(playerTwoDeck.dealCardFromDeck());
        }

        Card newPlayerOneCard = playerOneDeck.dealCardFromDeck();
        Card newPlayerTwoCard = playerTwoDeck.dealCardFromDeck();

        System.out.println("Player 1 New Card: " + newPlayerOneCard);
        System.out.println("Player 2 New Card: " + newPlayerTwoCard);

        if (newPlayerOneCard.rank() > newPlayerTwoCard.rank()) {
            playerOneDeck.addCardToDeck(newPlayerOneCard);
            playerOneDeck.addCardToDeck(newPlayerTwoCard);
            playerOneDeck.addCardToDeck(playerOneCard);
            playerOneDeck.addCardToDeck(playerTwoCard);

            for (int i = 0; i < warCardsPlayed.size(); i++) {
                playerOneDeck.addCardToDeck(warCardsPlayed.get(i));
            }

            System.out.println("Player 1 wins the war!");
        } else if (newPlayerOneCard.rank() < newPlayerTwoCard.rank()) {
            playerTwoDeck.addCardToDeck(newPlayerOneCard);
            playerTwoDeck.addCardToDeck(newPlayerTwoCard);
            playerTwoDeck.addCardToDeck(playerOneCard);
            playerTwoDeck.addCardToDeck(playerTwoCard);

            for (int i = 0; i < warCardsPlayed.size(); i++) {
                playerTwoDeck.addCardToDeck(warCardsPlayed.get(i));
            }

            System.out.println("Player 2 wins the war!");
        }
    }

    public void declareWinner(String winner) {
        System.out.println(winner + " is the winner!");
    }

    public static void main(String[] args) {
        War war = new War();
    }
}
