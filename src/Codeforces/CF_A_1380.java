import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1380
{
    public static void main(String[] args) throws IOException
    {
        int T = readInt();
        TestLoop:
        for (int __ = 0; __ < T; __++)
        {
            int n = readInt();
            int[] P = new int[n];
            int[] smallIndices = new int[n];

            for (int i = 0; i < n; i++)
            {
                int p = readInt();
                P[i] = p;
                smallIndices[i] = -1;
            }

            for (int i = 0; i < n; i++)
            {
                int current = P[i];
                for (int j = 0; j < i; j++)
                {
                    if (P[j] < current)
                    {
                        smallIndices[i] = j;
                    }
                    else
                    {
                        if (smallIndices[j] != -1)
                        {
                            System.out.println("YES\n" + (smallIndices[j] + 1) + " " + (j + 1) + " " + (i + 1));
                            continue TestLoop;
                        }
                    }
                }
            }
            System.out.println("NO");
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
