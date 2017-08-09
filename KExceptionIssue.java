import java.io.IOException;

import kx.c;
import kx.c.*;

public class KExceptionIssue
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

        c con = new c("localhost", port, "user:passwd");
    }
}
