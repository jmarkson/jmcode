import java.io.IOException;

import kx.c;
import kx.c.*;

public class KQueries
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

        (new KQueries()).runQueriesUsingKMethods();
    }

    private void runQueriesUsingKMethods() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapassw");
        Object o = con.k("::", new Integer(321));
        System.out.println(o);
        o = con.k("+", new Integer(3), new Integer(4));
        System.out.println(o);
        o = con.k("{x+y+z}", new Integer(3), new Integer(4), new Integer(5));
        System.out.println(o);
        o = con.k("10+20+30");
        System.out.println(o);
        con.k("add4:{[a;b;c;d] a+b+c+d}");
        o = con.k("add4[1;2;3;4]");
        System.out.println(o);
        o = con.k("{x in `ABC`DEF`GHI}", "ABC");
        System.out.println(o);
        con.k("add4ButNullReturn:{[a;b;c;d] a+b+c+d;}");
        o = con.k("add4ButNullReturn[1;2;3;4]");
        System.out.println(o);
    }
}