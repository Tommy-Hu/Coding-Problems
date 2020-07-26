import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1384
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        TestLoop:
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            char[] A = br.readLine().toCharArray();
            char[] B = br.readLine().toCharArray();
            int moves = 0;

            boolean same = true;
            do
            {
                char lastSameChar = '-';
                for (int i = 0; i < n; i++)
                {
                    char a = A[i];
                    char b = B[i];
                    if (a > b)
                    {
                        System.out.println(-1);
                        continue TestLoop;
                    }

                    if (a != lastSameChar)
                    {
                        if (i > 0)
                        {
                            moves++;
                        }
                        lastSameChar = a;
                    }
                    if (a != b)
                    {
                        same = false;
                    }
                }
            }
            while (!same);
            moves++;
            System.out.println(moves);
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
