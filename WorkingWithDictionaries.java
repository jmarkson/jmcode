import java.io.IOException;

import kx.c;
import kx.c.*;

public class WorkingWithDictionaries
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

        (new WorkingWithDictionaries()).workingWithDictionaries();
    }

    private void workingWithDictionaries() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapasswd");
        c.Dict dict = (c.Dict) con.k("`a`b`c!((1 2 3);\"Second\"; (`x`y`z))");
        System.out.println("object type: " + c.t(dict));
        String[] keys = (String[]) dict.x;
        System.out.println("keys");
        System.out.println("----");
        for (String key : keys)
        {
            System.out.println(key);
        }

        Object[] values = (Object[]) dict.y;
        System.out.println("\nvalues");
        System.out.println("------");

        long[] valuesLong = (long[]) values[0];
        for (long value : valuesLong)
        {
            System.out.print(value + " ");
        }
        System.out.println("");

        char[] valuesChar = (char[]) values[1];
        for (char value : valuesChar)
        {
            System.out.print(value);
        }
        System.out.println("");

        String[] valuesString = (String[]) values[2];
        for (String value : valuesString)
        {
            System.out.print(value + " ");
        }
        System.out.println("");
    }
}