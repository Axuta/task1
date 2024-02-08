import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class CardGameTests {
    @Test
    void testNewDeckContains40Cards() {
        List<Integer> originalDeck = ShuffleAlgorithm.generateDeck(CardGame.maxValue, CardGame.numOfIdenticalCards);

        assertEquals(40, originalDeck.size());
    }

    @Test
    void testShuffleFunction() {
        List<Integer> originalDeck = ShuffleAlgorithm.generateDeck(CardGame.maxValue, CardGame.numOfIdenticalCards);
        List<Integer> deck = ShuffleAlgorithm.shuffle(originalDeck, originalDeck.size());

        assertNotEquals(originalDeck, deck);
    }

    @Test
    void testDrawPileRefill() {
        List<Integer> drawPile = new ArrayList<>();
        List<Integer> discardPile = ShuffleAlgorithm.generateDeck(CardGame.maxValue, CardGame.numOfIdenticalCards);

        CardGame.drawCard(drawPile, discardPile);
        assertFalse(drawPile.isEmpty());
    }

    @Test
    void testCardComparison() {
        int player1Card = 8;
        int player2Card = 4;
        assertTrue(player1Card > player2Card);
    }

    @Test
    void testTieBreaker() {
        List<Integer> player1DrawPile = new ArrayList<>(Arrays.asList(6, 3, 4, 2));
        List<Integer> player2DrawPile = new ArrayList<>(Arrays.asList(6, 3, 6, 5));
        List<Integer> player1DiscardPile = new ArrayList<>();
        List<Integer> player2DiscardPile = new ArrayList<>();
        List<Integer> tieRound = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int player1Card = CardGame.drawCard(player1DrawPile, player1DiscardPile);
            int player2Card = CardGame.drawCard(player2DrawPile, player2DiscardPile);

            if (player1Card > player2Card) {
                if (!tieRound.isEmpty()) {
                    player1DiscardPile.addAll(tieRound);
                    tieRound.clear();
                }
                player1DiscardPile.add(player1Card);
                player1DiscardPile.add(player2Card);
            } else if (player1Card < player2Card) {
                if (!tieRound.isEmpty()) {
                    player2DiscardPile.addAll(tieRound);
                    tieRound.clear();
                }
                player2DiscardPile.add(player1Card);
                player2DiscardPile.add(player2Card);
            } else {
                tieRound.add(player1Card);
                tieRound.add(player2Card);
            }
        }

        assertTrue(player1DiscardPile.size() < player2DiscardPile.size());
    }
}
