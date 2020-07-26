import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1373
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            String s = br.readLine();
            String only1S = s.replaceAll("0", "");
            int zeroCount = s.length() - only1S.length();
            int oneCount = only1S.length();

            System.out.println(Integer.min(zeroCount, oneCount) % 2 == 0 ? "NET" : "DA");
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
