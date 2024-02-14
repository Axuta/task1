package cardgame;

import card.Card;
import player.Player;

public interface ICardGame {
    void playGame();

    void playTurn(Card card1, Card card2);

    Player getPlayer1();
    Player getPlayer2();
}
