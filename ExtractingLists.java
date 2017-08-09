import java.io.IOException;

import kx.c;
import kx.c.*;

public class ExtractingLists
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

        (new ExtractingLists()).extractingLists();
    }

    private void extractingLists() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapasswd");
        long[] lArray = (long[]) con.k("1 2 3 4");
        System.out.println("type of list: " + c.t(lArray));
        System.out.println("typed list of longs");
        System.out.println("-------------------");
        for (long data : lArray)
        {
            System.out.println(data);
        }
        System.out.println("");
        Object[] oArray = (Object[]) con.k("((1 2 3 4); (1 2))");
        System.out.println("type of list: " + c.t(oArray));
        System.out.println("type of list: " + c.t(oArray[0]));
        for (Object oElement : oArray)  // extract list from lists
        {
            System.out.println("list of data");
            System.out.println("------------");
            long[] lDataArray = (long[]) oElement;
            for (long lDataElement : lDataArray)
            {
                System.out.println(lDataElement);
            }
            System.out.println("\n\n");
        }
    }
}