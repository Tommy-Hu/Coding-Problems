package Tommy.Codeforces;

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_G_1352
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            if (n <= 3)
            {
                System.out.println("-1");
                continue;
            }
            StringBuilder result = new StringBuilder();
            boolean odd = n % 2 != 0;
            for (int i = n; i >= (odd ? 5 : 6); i -= 2)
            {
                result.append(i).append(" ");
            }
            result.append("2 4 1 3 ");
            for (int i = odd ? 6 : 5; i < n; i += 2)
            {
                result.append(i).append(" ");
            }
            System.out.println(result);
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
