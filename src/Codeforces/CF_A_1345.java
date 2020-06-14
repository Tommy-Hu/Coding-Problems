import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_A_1345
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int i = 0; i < t; i++)
        {
            int n = readInt();
            int m = readInt();
            if (n == 1 || m == 1)
            {
                System.out.println("YES");
            }
            else if (n > 2 || m > 2)
            {
                System.out.println("No");
            }
            else
            {
                System.out.println("YES");
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
