import java.io.IOException;

import kx.c;
import kx.c.*;

public class Schema
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

        Schema schema = new Schema();
        schema.schemaForOneTable();
        schema.schemaForMultipleTables();
    }

    private void schemaForOneTable() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapasswd");
        Object[] response = (Object[]) con.k(".u.sub[`trade;`]");
        System.out.println("table name: " + response[0]);
        Flip table = (Flip) response[1];
        String[] columnNames = table.x;
        for (int i = 0; i < columnNames.length; i++)
        {
            System.out.printf("Column %d is named %s\n", i, columnNames[i]);
        }

        con.close();
    }

    private void schemaForMultipleTables() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapasswd");
        Object response = con.k(".u.sub[`;`]");
        Object[] data = (Object[]) response;
        for (Object o : data)
        {
            Object[] oData = (Object[]) o;
            System.out.println("table name: " + oData[0]);
            Flip table = (Flip) oData[1];
            String[] columnNames = table.x;
            for (int i = 0; i < columnNames.length; i++)
            {
                System.out.printf("Column %d is named %s\n", i, columnNames[i]);
            }
        }

        con.close();
    }
}
