package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;

public class VenderOutput extends AbstractOutput {
    @Override
    public void output(Object[] data, int level) {

        l = level + "";

        if (level == 1)
        {
            Transaction[] transactions = (Transaction[]) data;
            outPutChange(transactions);
        }
        if (level == 2 || level == 3)
        {
            Transaction[] transactions = (Transaction[]) data;
            outPutCoins(transactions);
        }

        if (level == 4)
        {
            outPutRevenue(data);
        }
    }

    private void outPutChange(Transaction[] ts)
    {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < ts.length; i++)
        {
            Transaction t = ts[i];
            int outstanding = t.getOutstanding();
            String r = outstandingFormat(outstanding);
            result.add(r);
        }
        toFile(result);
    }

    private void outPutCoins(Transaction[] ts)
    {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < ts.length; i++)
        {
            Transaction t = ts[i];
            int outstanding = t.getOutstanding();
            String r = coinFormat(outstanding, t);
            result.add(r);
        }
        toFile(result);
    }

    private String outstandingFormat(int i)
    {
        String result = "";
        if (i < 0) {result += "MISSING ";}
        if (i >= 0) {result += "CHANGE ";}
        result += Math.abs(i);
        return result;
    }

    private String coinFormat(int i, Transaction t)
    {
        String result = "";
        if (i < 0) {result += "MISSING " + Math.abs(i);}
        if (i >= 0)
        {
            result += "CHANGE";
            int[] change = t.giveChange();
            for (int n = 0; n < change.length; n++)
            {
                result += " " + change[n];
            }
        }
        return result;
    }

    private void outPutRevenue(Object[] revs)
    {
        ArrayList<String> result = new ArrayList<>();
        for (Object i: revs
             ) {
            Integer n = (Integer) i;
            result.add(n + "");
        }
        toFile(result);
    }
}
