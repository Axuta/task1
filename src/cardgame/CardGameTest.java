package cardgame;

import card.Card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import player.Player;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class CardGameTest {
    CardGame game;
    Player player1;
    Player player2;
    @BeforeEach
    public void setUp() {
        game = new CardGame();
        player1 = game.getPlayer1();
        player2 = game.getPlayer2();

        player1.setDrawPile(new Stack<>());
        player2.setDrawPile(new Stack<>());
    }

    @Test
    public void testHigherCardWins() {
        setUp();

        Card card1 = new Card(8);
        Card card2 = new Card(2);

        game.playTurn(card1, card2);

        assertTrue(!player1.getDiscardPile().isEmpty() && player2.getDiscardPile().isEmpty());
    }

    @Test
    public void testEqualCardsWinner() {
        setUp();

        player1.getDrawPile().push(new Card(8));
        player2.getDrawPile().push(new Card(3));

        player1.getDrawPile().push(new Card(5));
        player2.getDrawPile().push(new Card(5));
        game.playGame();

        assertTrue(!player1.getDiscardPile().isEmpty() && player2.getDiscardPile().isEmpty());
    }
}