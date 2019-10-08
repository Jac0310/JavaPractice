package CatalystAssessment;

import java.util.ArrayList;

public class VenderOutput extends AbstractOutput {
    @Override
    public void output(Object[] data, int level) {
        Transaction[] transactions = (Transaction[]) data;
        l = level + "";

        if (level == 1)
        {
            outPutChange(transactions);
        }
        if (level == 2)
        {
            outPutCoins(transactions);

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
        if (i >= 0) {result += "CHANGE " + t.giveChange();}
        return result;
    }
}
