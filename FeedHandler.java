import java.io.IOException;

import kx.c;
import kx.c.*;

public class FeedHandler
{
    private static int port;

    private c con;

    public static void main(String...args) throws IOException, KException
    {
        if (args.length == 0)
        {
            port = 10000;
        }
        else
        {
            port = Integer.parseInt(args[0]);
        }

        FeedHandler feedHandler = new FeedHandler();
        feedHandler.init();
        feedHandler.publishOneRow();
        feedHandler.publishBatchRows();
        feedHandler.addTimeSpan();
    }

    private void init() throws IOException, KException
    {
        con = new c("localhost", port, "javauser:javapasswd");
    }

    private void publishOneRow() throws IOException, KException
    {
        Object[] data;

        String[] sym = new String[] {"IBM"};
        double[] bid = new double[] {100.25};
        double[] ask = new double[] {100.26};
        int[] bSize = new int[]{1000};
        int[] aSize = new int[]{1000};
        data = new Object[] {sym, bid, ask, bSize, aSize};
        con.ks(".u.upd", "quote", data);
        double[] price = new double[] {100.25};
        int[] size = new int[] {1000};
        data = new Object[] {sym, price, size};
        con.ks(".u.upd", "trade", data);
    }

    private void publishBatchRows() throws IOException, KException
    {
        Object[] data;

        String[] sym = new String[] {"IBM", "GE"};
        double[] bid = new double[] {100.25, 120.25};
        double[] ask = new double[] {100.26, 120.26};
        int[] bSize = new int[]{1000, 2000};
        int[] aSize = new int[]{1000, 2000};
        data = new Object[] {sym, bid, ask, bSize, aSize};
        con.ks(".u.upd", "quote", data);
        double[] price = new double[] {100.25, 120.26};
        int[] size = new int[] {1000, 2000};
        data = new Object[] {sym, price, size};
        con.ks(".u.upd", "trade", data);
    }

    private void addTimeSpan() throws IOException, KException
    {
        Object[] data;

        Timespan[] time = new Timespan[] {new Timespan()};
        String[] sym = new String[] {"GS"};
        double[] bid = new double[] {100.25};
        double[] ask = new double[] {100.26};
        int[] bSize = new int[]{1000};
        int[] aSize = new int[]{1000};
        data = new Object[] {time, sym, bid, ask, bSize, aSize};
        con.ks(".u.upd", "quote", data);
        double[] price = new double[] {100.25};
        int[] size = new int[] {1000};
        data = new Object[] {time, sym, price, size};
        con.ks(".u.upd", "trade", data);
    }
}
