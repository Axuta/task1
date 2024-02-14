package deck;

import card.Card;

import java.util.List;

public interface IDeck {
    void initializeDeck();
    List<Card> getCards();
    void shuffle();
}
