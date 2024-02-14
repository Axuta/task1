package player;

import card.Card;

import java.util.Stack;

public interface IPlayer {
    Card drawCard();

    void reuseDiscardPile();

    Stack<Card> getDrawPile();

    void setDrawPile(Stack<Card> drawPile);

    Stack<Card> getDiscardPile();

    Stack<Card> getEqualCardsPile();
}
