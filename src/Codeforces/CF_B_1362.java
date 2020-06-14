import java.io.*;
import java.util.*;

public class CF_B_1362
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        TestLoop:
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            if (n % 2 != 0)
            {
                br.readLine();
                pw.println(-1);
                continue;
            }
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < n; i++)
            {
                s.add(readInt());
            }
            for (int i = 1; i <= 1024; i++)
            {
                Set<Integer> newSet = new HashSet<>();
                for (int num: s)
                {
                    newSet.add(num ^ i);
                }
                if (newSet.containsAll(s))
                {
                    pw.println(i);
                    continue TestLoop;
                }
            }
            pw.println(-1);
        }
        pw.close();
    }

    static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
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
