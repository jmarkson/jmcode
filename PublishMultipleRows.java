import java.io.IOException;

import kx.c;
import kx.c.*;

public class PublishMultipleRows
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
        (new PublishMultipleRows()).publishMultipleRows();
    }

    private void publishMultipleRows() throws IOException, KException
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
}
