import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_B_1334
{
    public static void main(String[] args) throws IOException
    {
        int T = readInt();
        CasesLoop:
        for (int i = 0; i < T; i++)
        {
            int n = readInt();
            int x = readInt();
            List<Long> poorDif = new ArrayList<>();
            long balance = 0;
            for (int j = 0; j < n; j++)
            {
                long dif = readInt() - x;
                balance += dif;
                if (dif < 0)
                {
                    poorDif.add(dif);
                }
            }
            if (balance >= 0)
            {
                System.out.println(n);
                continue;
            }
            Collections.sort(poorDif);
            long removedCount = 0;
            for (long p: poorDif)
            {
                balance -= p;
                removedCount++;
                if (balance >= 0)
                {
                    System.out.println(n - removedCount);
                    continue CasesLoop;
                }
            }
            System.out.println(n - removedCount);
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
