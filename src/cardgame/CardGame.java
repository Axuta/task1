package cardgame;

import constant.Constants;
import card.Card;
import deck.Deck;
import player.Player;

import java.util.Stack;

public class CardGame implements ICardGame {
    private Player player1;
    private Player player2;
    int player1DeckSize = Constants.INITIAL_STACK_SIZE;
    int player2DeckSize = Constants.INITIAL_STACK_SIZE;


    public CardGame() {
        Deck deck = new Deck();
        Stack<Card> drawPile1 = new Stack<>();
        Stack<Card> drawPile2 = new Stack<>();

        for (int i = 0; i < Constants.INITIAL_STACK_SIZE; i++) {
            drawPile1.push(deck.getCards().get(i));
            drawPile2.push(deck.getCards().get(i + Constants.INITIAL_STACK_SIZE));
        }

        player1 = new Player(drawPile1);
        player2 = new Player(drawPile2);
    }

    @Override
    public void playGame() {
        do {
            Card card1 = player1.drawCard();
            Card card2 = player2.drawCard();

            player1DeckSize = player1.getDrawPile().size() + player1.getDiscardPile().size();
            player2DeckSize = player2.getDrawPile().size() + player2.getDiscardPile().size();

            System.out.println("Player 1 (" + player1DeckSize + " cards): " + card1.getValue());
            System.out.println("Player 2 (" + player2DeckSize + " cards): " + card2.getValue());

            playTurn(card1, card2);
        } while (player1DeckSize != 0 && player2DeckSize != 0);

        if (player1.getDrawPile().isEmpty()) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("Player 1 wins the game!");
        }
    }

    @Override
    public void playTurn(Card card1, Card card2) {
        if (card1.getValue() > card2.getValue()) {
            player1.getDiscardPile().push(card1);
            player1.getDiscardPile().push(card2);
            System.out.println("Player 1 wins this round\n");
            player1.tieRematch(player2);
        } else if (card1.getValue() < card2.getValue()) {
            player2.getDiscardPile().push(card1);
            player2.getDiscardPile().push(card2);
            System.out.println("Player 2 wins this round\n");
            player2.tieRematch(player1);
        } else {
            player1.getEqualCardsPile().push(card1);
            player2.getEqualCardsPile().push(card2);
            System.out.println("No winner in this round\n");
        }
    }

    @Override
    public Player getPlayer1() {
        return player1;
    }

    @Override
    public Player getPlayer2() {
        return player2;
    }
}
