import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1385
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            StringBuilder result = new StringBuilder();
            HashSet<Integer> usedInts = new HashSet<>();
            for (int i = 0; i < 2 * n; i++)
            {
                int s = readInt();
                if (!usedInts.contains(s))
                {
                    usedInts.add(s);
                    result.append(s).append(' ');
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
