package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;

public class VendorProcessor extends AbstractProcessor {
    @Override
    public Object[] process(ArrayList<String[]> data, int level) {
        Object[] result = new Object[data.size()];
        if (level == 1 || level == 2)
        {
            for (int n = 0; n < data.size(); n++)
            {
                Transaction t = readTransaction(data.get(n));
                result[n] = t;

            }
        }
        Grid g = null;
        if (level == 3 || level == 4)
        {
            for (int n = 0; n < data.size(); n++)
            {
                //build grid
                String[] d = data.get(n);
                g = new Grid(d[0]);
                d = Arrays.copyOfRange(d, 1, d.length);

                int noOfCells = g.numberOfCells();

                for (int i = 0; i < noOfCells; i++)
                {
                    g.setPrice(Integer.parseInt(d[i]));
                }

                d = Arrays.copyOfRange(d, noOfCells, d.length);

                if (level == 3)
                {
                    int price = g.getPrice(d[0]);

                    d[0] = price + "";

                    Transaction t = readTransaction(d);
                    result[n] = t;
                }
                if (level == 4)
                {
                    for (int i = 0; i < noOfCells; i++)
                    {
                        g.setStock(Integer.parseInt(d[i]));
                    }
                    d = Arrays.copyOfRange(d, noOfCells+1, d.length);

                    Grid afterOrder = g.processOrder(d);
                    Integer revenue = g.getRevenue(g, afterOrder);
                    result[n] = revenue;
                }
            }
        }
        return result;
    }

    private Transaction readTransaction(String[] d)
    {
        int price = Integer.parseInt(d[0]);
        int coinCount = Integer.parseInt(d[1]);
        d = Arrays.copyOfRange(d, 2, d.length);
        Coin[] coins = new Coin[d.length];
        for(int i = 0; i < coinCount; i++)
        {
            Coin coin = new Coin(Integer.parseInt(d[i]));
            coins[i] = coin;
        }
        return new Transaction(coins, price);
    }

}
