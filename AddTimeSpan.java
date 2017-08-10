import java.io.IOException;

import kx.c;
import kx.c.*;

public class AddTimeSpan
{
    private static int port;
    private static c con;

    public static void main(String...args) throws IOException, c.KException {
        if (args.length == 0) {
            port = 10000;
        } else {
            port = Integer.parseInt(args[0]);
        }

        con = new c("localhost", port, "javauser:javapasswd");
        (new AddTimeSpan()).addTimeSpan();
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
