import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_C_1373
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            String op = br.readLine();

            System.out.println(res(op));
        }
    }

    public static long res(String s)
    {
        long m = 0;
        int comparator = 0;
        List<Integer> negativeIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '-')
            {
                m--;
                if (m < comparator)
                {
                    comparator--;
                    negativeIndices.add(i);
                }
            }
            else
            {
                m++;
            }
        }

        long res = 0;

        for (int index: negativeIndices)
        {
            res += index + 1;
        }

        return res + s.length();
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
