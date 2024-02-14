package card;
public class Card implements ICard {
    private int value;

    public Card(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

}
