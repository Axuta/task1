package deck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckTest {
    Deck deck = new Deck();

    @Test
    public void testNewDeckContains40Cards() {
        Assertions.assertEquals(40, deck.getCards().size());
    }

    @Test
    public void testShuffleFunctionShufflesDeck() {
        Deck shuffledDeck = new Deck();
        shuffledDeck.shuffle();
        Assertions.assertNotEquals(deck.getCards(), shuffledDeck.getCards());
    }
}