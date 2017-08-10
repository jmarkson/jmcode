import java.io.IOException;
import java.net.ServerSocket;

import kx.*;
import kx.c.*;

public class QProxy
{
    private static int cPort;
    private static int sPort;

    private c sCon;
    private c cCon;

    public static void main(String...args) throws IOException, KException
    {
        if (args.length == 0)
        {
            cPort = 10000;
            sPort = 10010;
        }
        else
        {
            cPort = Integer.parseInt(args[0]);
            sPort = Integer.parseInt(args[1]);
        }

        QProxy qProxy = new QProxy();
        qProxy.init();
        qProxy.qProxy();
    }

    private void init() throws IOException, KException
    {
        sCon = new c(new ServerSocket(sPort));
        cCon = new c("localhost", cPort, "javauser:javapasswd");
    }

    private void qProxy() throws IOException, KException
    {
        while (true)
        {
            Object o = sCon.k();
            try {
                sCon.kr(cCon.k(o));
            } catch (IOException | KException e) {
                sCon.ke(e.getMessage());
            }
        }
    }
}