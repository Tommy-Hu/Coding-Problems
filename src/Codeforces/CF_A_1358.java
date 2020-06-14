import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1358
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int m = readInt();
            int horizontalCount = Math.floorDiv(m, 2);
            boolean remaining = m % 2 != 0;
            System.out.println(horizontalCount * (long) n + (long) (remaining ? Math.ceil(n / 2.0) : 0));
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int readInt() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}
