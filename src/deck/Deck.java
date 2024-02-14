package deck;

import constant.Constants;
import card.Card;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements IDeck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    @Override
    public void initializeDeck() {
        for (int i = 1; i <= Constants.CARD_RANGE; i++) {
            for (int j = 0; j < Constants.NUM_REPETITIONS; j++) {
                cards.add(new Card(i));
            }
        }
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public void shuffle() {
        shuffleList(cards);
    }

    public static void shuffleList(List<Card> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Collections.swap(list, i, j);
        }
    }
}
