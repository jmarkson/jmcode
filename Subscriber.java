import java.io.IOException;
import java.util.StringJoiner;

import kx.c;
import kx.c.*;

public class Subscriber
{
    private static int port;

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

        (new Subscriber()).subscribeAndGetData();
    }

    private void subscribeAndGetData() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapasswd");
        con.k(".u.sub[`trade;`]");
        while (true)
        {
            Object response = con.k();
            if (response != null)
            {
                Object[] data = (Object[]) response;

                String tableName = (data[1]).toString();
                c.Flip table = (c.Flip) data[2];
                String[] columnNames = table.x;
                Object[] columnData = table.y;

                System.out.println("tableName: " + tableName);

                System.out.printf("%s\t\t\t\t%s\t%s\t%s\n", columnNames[0], columnNames[1], columnNames[2], columnNames[3]);
                System.out.println("-------------------------------------");
                System.out.printf("%s\t%s\t%s\t%s\n", c.at(columnData[0], 0).toString(),
                                                      c.at(columnData[1], 0).toString(),
                                                      c.at(columnData[2], 0).toString(),
                                                      c.at(columnData[3], 0).toString());
            }
        }
    }
}