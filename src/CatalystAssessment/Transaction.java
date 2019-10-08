package CatalystAssessment;

import java.util.Arrays;

public class Transaction {
    private int cost;
    Coin[] coins;
    private int valueRecieved;

    private int change;
    public Transaction(Coin[] coins, int cost)
    {
        this.coins = coins;
        this.cost = cost;
        Arrays.stream(coins).forEach(c -> valueRecieved += c.value);
    }


    public int getOutstanding()
    {
        return valueRecieved - cost;
    }

    public int[] giveChange()
    {
        change = getOutstanding();
        int[] changeMap = new int[8];
        for (int i = Coin.possibleCoins.length-1; i >= 0; i--)
        {
            changeMap = populateFrequency(Coin.possibleCoins[i].value, changeMap, i);
        }
        return changeMap;
    }

    private int[] populateFrequency(int coinValue, int[] map, int index)
    {
        while (change >= coinValue)
        {
            map[index] += 1;
            change -= coinValue;
        }
        return map;
    }
}
