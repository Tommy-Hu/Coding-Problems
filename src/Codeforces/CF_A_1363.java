import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1363
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int x = readInt();
            int oddIndex = -1;
            int oddCount = 0;
            for (int i = 0; i < n; i++)
            {
                int a = readInt();
                if (a % 2 != 0)
                {
                    oddIndex = i;
                    oddCount++;
                }
            }
// if no odds or queries more than numbers or there are even counts of odd and queries all of them or
            // all of the elements are odd and query even counts of them
            if (oddIndex == -1 || x > n || (oddCount % 2 == 0 && x == n) || (oddCount == n && x % 2 == 0))
            {
                System.out.println("No");
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
