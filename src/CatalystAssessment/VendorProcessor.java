package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;

public class VendorProcessor extends AbstractProcessor {
    @Override
    public Object[] process(ArrayList<int[]> data) {
        Transaction[] result = new Transaction[data.size()];

        for (int n = 0; n < data.size(); n++)
        {
            int[] d = data.get(n);
            int price = d[0];
            int coinCount = d[1];
            d = Arrays.copyOfRange(d, 2, d.length);
            Coin[] coins = new Coin[d.length];
            for(int i = 0; i < coinCount; i++)
            {
                Coin coin = new Coin(d[i]);
                coins[i] = coin;
            }
            result[n] = new Transaction(coins, price);
        }
        return result;
    }
}
