import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_B_1342
{
    public static void main(String[] args) throws IOException
    {
        int T = readInt();
        for (int i = 0; i < T; i++)
        {
            String t = br.readLine();
            String s = "";
            boolean alwaysSame = true;
            char cur = t.charAt(0);
            for (int j = 1; j < t.length(); j++)
            {
                if (t.charAt(j) != cur)
                {
                    alwaysSame = false;
                    break;
                }
            }
            if (!alwaysSame)
            {
                for (int j = 0; j < t.length(); j++)
                {
                    s += "10";
                }
            }
            else
            {
                s = t;
            }
            System.out.println(s);
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
