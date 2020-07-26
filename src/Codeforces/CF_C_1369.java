import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_C_1369
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int k = readInt();

            int[] integers = new int[n];
            for (int i = 0; i < n; i++)
            {
                integers[i] = readInt();
            }

            Arrays.sort(integers);
            int[] giftCount = new int[k];
            for (int i = 0; i < k; i++)
            {
                giftCount[i] = readInt();
            }

            Arrays.sort(giftCount);

            long result = 0;
            int endIndex = n - k - 1;
            for (int i = 0; i < k; i++)
            {
                int gifts = giftCount[i];

                result += integers[n - i - 1];
                if (gifts == 1)
                {
                    result += integers[n - i - 1];
                }
                else
                {
                    result += integers[endIndex - (gifts - 2)];
                    endIndex -= (gifts - 1);
                }
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
