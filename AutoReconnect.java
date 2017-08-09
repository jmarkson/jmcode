import java.io.IOException;

import kx.c;
import kx.c.*;

public class AutoReconnect
{
    private static int port;

    private c con;

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

        AutoReconnect ar = new AutoReconnect();
        ar.init();
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {

        }
        ar.executeFunction();
    }

    private void init() throws KException
    {
        try
        {
            con = new c("localhost", port, "javauser:javapasswd");
        }
        catch (IOException ioe)
        {
            autoReconnect();
        }
    }

    private void autoReconnect() throws KException
    {
        while (true)
        {
            System.out.println("Trying to reconnect...");
            try
            {
                con = new c("localhost", port, "javauser:javapasswd");
                break;
            }
            catch (IOException ioe)
            {
                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {

                }
            }
        }
    }

    private void executeFunction() throws KException
    {
        try
        {
            con.k("3+2");
        }
        catch (IOException e)
        {
            autoReconnect();
            try
            {
                System.out.println(con.k("3+2"));
            }
            catch (IOException e1)
            {

            }
        }
    }
}