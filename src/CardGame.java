import java.util.*;

public class CardGame {

    static int maxValue = 10;
    static int numOfIdenticalCards = 4;

    static int drawCard(List<Integer> drawPile, List<Integer> discardPile) {
        if (drawPile.isEmpty()) {
            ShuffleAlgorithm.shuffle(discardPile, discardPile.size());
            drawPile.addAll(discardPile);
            discardPile.clear();

            if (drawPile.isEmpty()) return -1;
        }
        return drawPile.removeFirst();
    }

    public static void main(String[] args) {
        int numberOfCards = maxValue * numOfIdenticalCards;
        int numberOfCardsEach = numberOfCards / 2;
        int player1PileSize;
        int player2PileSize;

        List<Integer> defaultDeck = ShuffleAlgorithm.generateDeck(maxValue, numOfIdenticalCards);
        List<Integer> deck = ShuffleAlgorithm.shuffle(defaultDeck, defaultDeck.size());

        List<Integer> player1DrawPile = new ArrayList<>(deck.subList(0, numberOfCardsEach));
        List<Integer> player2DrawPile = new ArrayList<>(deck.subList(numberOfCardsEach, numberOfCards));

        List<Integer> tieRound = new ArrayList<>();

        List<Integer> player1DiscardPile = new ArrayList<>();
        List<Integer> player2DiscardPile = new ArrayList<>();

        do {
            int player1Card = drawCard(player1DrawPile, player1DiscardPile);
            int player2Card = drawCard(player2DrawPile, player2DiscardPile);

            player1PileSize = player1DrawPile.size() + player1DiscardPile.size();
            player2PileSize = player2DrawPile.size() + player2DiscardPile.size();

            if (player1Card == -1 || player2Card == -1) {
                break;
            }

            System.out.println("Player 1 (" + player1PileSize + " cards): " + player1Card);
            System.out.println("Player 2 (" + player2PileSize + " cards): " + player2Card);

            if (player1Card > player2Card) {
                if (!tieRound.isEmpty()) {
                    player1DiscardPile.addAll(tieRound);
                    tieRound.clear();
                }

                player1DiscardPile.add(player1Card);
                player1DiscardPile.add(player2Card);
                System.out.println("Player 1 wins the round");
            } else if (player2Card > player1Card) {
                if (!tieRound.isEmpty()) {
                    player2DiscardPile.addAll(tieRound);
                    tieRound.clear();
                }

                player2DiscardPile.add(player1Card);
                player2DiscardPile.add(player2Card);
                System.out.println("Player 2 wins the round");
            } else {
                tieRound.add(player1Card);
                tieRound.add(player2Card);
                System.out.println("No winner in this round");
            }
            System.out.println();
        } while (player1PileSize != 0 || player2PileSize != 0);

        if (player1DrawPile.isEmpty() && player1DiscardPile.isEmpty()) {
            System.out.println("Player 2 wins the game!");
        } else if (player2DrawPile.isEmpty() && player2DiscardPile.isEmpty()) {
            System.out.println("Player 1 wins the game!");
        } else {
            System.out.println("Game ended unexpectedly.");
        }
    }
}
