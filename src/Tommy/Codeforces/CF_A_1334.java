package Tommy.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_A_1334
{
    public static void main(String[] args) throws IOException
    {
        int T = readInt();

        for (int i = 0; i < T; i++)
        {
            int n = readInt();
            int lastP = 0;
            int lastC = 0;
            boolean correct = true;
            for (int j = 0; j < n; j++)
            {
                int p = readInt();
                int c = readInt();
                if (!correct)
                {
                    continue;
                }

                if (p >= c && lastP <= p && lastC <= c && !(p == lastP && c != lastC) && (p - lastP >= c - lastC))
                {
                    lastP = p;
                    lastC = c;
                }
                else
                {
                    correct = false;
                }
            }

            if (!correct)
            {
                System.out.println("NO");
            }
            else
            {
                System.out.println("Yes");
            }
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
