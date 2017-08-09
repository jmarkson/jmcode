import java.io.IOException;

import kx.c;
import kx.c.*;

public class ExtractingAtoms
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

        (new ExtractingAtoms()).extractAtoms();
    }

    private void extractAtoms() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapasswd");
        Object o = con.k("(1 2 3 4)");
        System.out.println(((long[]) o)[0]);  //extract atom from list
        o = con.k("1");
        System.out.println("type of atom: " + c.t(o));
        System.out.println(o);  //extract atom
    }
}