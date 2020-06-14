import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1363
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            char[] bs = br.readLine().toCharArray();
            if (bs.length <= 2)
            {
                System.out.println(0);
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int mid = 0; mid < bs.length; mid++)
            {
                int left0 = 0;
                int left1 = 0;
                for (int i = 0; i < mid; i++)
                {
                    if (bs[i] == '0')
                    {
                        left0++;
                    }
                    else
                    {
                        left1++;
                    }
                }
                int right0 = 0;
                int right1 = 0;
                for (int i = mid; i < bs.length; i++)
                {
                    if (bs[i] == '0')
                    {
                        right0++;
                    }
                    else
                    {
                        right1++;
                    }
                }
                min = Integer.min(min, left0 + right1);
                min = Integer.min(min, left1 + right0);
            }
            System.out.println(min);
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
