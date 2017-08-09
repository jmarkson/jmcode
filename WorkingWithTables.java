import java.io.IOException;

import kx.c;
import kx.c.*;

public class WorkingWithTables
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

        (new WorkingWithTables()).workingWithTables();
    }

    private void workingWithTables() throws IOException, KException
    {
        c con = new c("localhost", port, "javauser:javapasswd");
        c.Flip flip = (c.Flip) con.k("select from trade where sym=`IBM");
        System.out.println("object type: " + c.t(flip));
        String[] columnNames = flip.x;
        for (String columnName : columnNames)
        {
            System.out.print(columnName + "\t\t\t");
        }
        System.out.println("\n----------------------------------------------------------------------------");

        Object[] columnData = flip.y;
        Timespan[] time = (Timespan[]) columnData[0];
        String[] sym = (String[]) columnData[1];
        double[] price = (double[]) columnData[2];
        int[] size = (int[]) columnData[3];
        int rows = time.length;
        for (int i = 0; i < rows; i++)
        {
            System.out.print(time[i] + "\t" + sym[i] + "\t\t\t" + price[i] + "\t\t\t" + size[i] + "\n");
        }
    }
}