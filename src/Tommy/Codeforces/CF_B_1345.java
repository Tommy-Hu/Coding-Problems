package Tommy.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_B_1345
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        TestLoop:
        for (int i = 0; i < t; i++)
        {
            int n = readInt();
            if (isInteger(n / 3f))
            {

            }
            else if (isInteger((n - 1) / 3f))
            {
                System.out.println(1);
                continue;
            }
            else
            {

            }
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < j; k++)
                {
                    if ((float) Math.round((j - k) / 3f) == (j - k) / 3f && (float) Math.round(k / 3f) == k / 3f)
                    {
                        System.out.println(2);
                        continue TestLoop;
                    }
                }
            }
            System.out.println(0);
        }
    }

    static boolean isInteger(float num)
    {
        return num == (int) num;
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
