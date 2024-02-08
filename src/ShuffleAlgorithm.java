import java.util.*;


public class ShuffleAlgorithm {
    static List<Integer> shuffle (List<Integer> arr, int n){
        Random random = new Random();
        for (int i = n - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }

        return arr;
    }
    static List<Integer> generateDeck(int maxValue, int numOfIdenticalCards) {
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= maxValue; i++) {
            for (int j = 0; j < numOfIdenticalCards; j++) {
                deck.add(i);
            }
        }

        return deck;
    }
}
