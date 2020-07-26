import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_A_1373
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int a = readInt();
            int b = readInt();
            int c = readInt();

            StringBuilder sb = new StringBuilder();
            if (a < c)
            {
                sb.append(1);
            }
            else
            {
                sb.append(-1);
            }

            sb.append(' ');
            if (c <= a)
            {
                sb.append(b);
            }
            else if (c / b >= a)
            {
                sb.append(-1);
            }
            else
            {
                sb.append(b);
            }

            System.out.println(sb);
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
