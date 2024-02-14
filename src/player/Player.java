package player;

import card.Card;
import deck.Deck;

import java.util.Stack;

public class Player implements IPlayer {
    private Stack<Card> drawPile;
    private Stack<Card> discardPile;
    private Stack<Card> equalCardsPile;

    public Player(Stack<Card> drawPile) {
        this.drawPile = drawPile;
        this.discardPile = new Stack<>();
        this.equalCardsPile = new Stack<>();
    }

    @Override
    public Card drawCard() {
        if (drawPile.isEmpty()) {
            reuseDiscardPile();
        }
        return getDrawPile().pop();
    }

    @Override
    public void reuseDiscardPile() {
        Deck.shuffleList(discardPile);
        while (!discardPile.isEmpty()) {
            drawPile.addAll(discardPile);
            discardPile.clear();
        }
    }

    @Override
    public Stack<Card> getDrawPile() {
        return drawPile;
    }

    @Override
    public void setDrawPile(Stack<Card> drawPile) {
        this.drawPile = drawPile;
    }

    @Override
    public Stack<Card> getDiscardPile() {
        return discardPile;
    }

    @Override
    public Stack<Card> getEqualCardsPile() {
        return equalCardsPile;
    }

    public void tieRematch(Player player) {
        getDiscardPile().addAll(getEqualCardsPile());
        getDiscardPile().addAll(player.getEqualCardsPile());
        getEqualCardsPile().clear();
        player.getEqualCardsPile().clear();
    }
}