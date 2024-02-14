package player;

import card.Card;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PlayerTest {
    Player player = new Player(new Stack<>());

    @Test
    public void testDrawCardFromEmptyDrawPile() {
        player.getDrawPile().clear();
        for (int i = 1; i < 5; i++) {
            player.getDiscardPile().push(new Card(i));
        }
        player.drawCard();
        assertFalse(player.getDrawPile().isEmpty());
    }
}
