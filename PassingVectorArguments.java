import java.io.IOException;

import kx.c;
import kx.c.*;

public class PassingVectorArguments
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

        (new PassingVectorArguments()).passingVectorArguments();
    }

    private void passingVectorArguments() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapasswd");
        Object[] data;
        String[] columnNames;
        int[] simpleList = {10, 20, 30};
        con.k("set", "simpleList", simpleList);
        Object[] mixedList = {new String[] {"first", "second"}, new double[] {1.0, 2.0}};
        con.k("set", "mixedList", mixedList);
        Object[] keys = {"a", "b", "c"};
        int[] values = {100, 200, 300};
        Dict dict = new Dict(keys, values);
        con.k("set", "dict", dict);
        int[] c1 = {1, 2, 3};
        data = new Object[] {c1};
        columnNames = new String[] {"c1"};
        dict = new Dict(columnNames, data);
        Flip table = new Flip(dict);
        con.k("t1:([]c1:`int$())");
        con.ks("insert", "t1", table);
        String[] c2 = {"AA", "BB", "CC"};
        data = new Object[] {c1, c2};
        columnNames = new String[] {"c1", "c2"};
        table = new Flip(new Dict(columnNames, data));
        con.k("t2:([]c1:`int$();c2:`symbol$())");
        con.ks("insert", "t2", table);
    }
}