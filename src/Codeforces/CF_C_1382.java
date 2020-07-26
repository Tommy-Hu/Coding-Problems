import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_C_1382
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();

            StringBuilder result = new StringBuilder();

            for (int i = n - 1; i >= 0; i--)
            {
                char curA = a[i];
                char curB = b[i];
                if (curA != curB)
                {
                    if (curA != a[0])
                    {
                        //make them the same, and then flip and invert
                        result.append(1).append(' ');
                        a[i] = (char) ((curA - '0') ^ 1);
                    }
                    //flip and invert
                    result.append(i + 1).append(' ');
                    for (int j = 0; j <= i; j++)
                    {
                        a[j] = (char) ((a[j] - '0') ^ 1);
                    }
                }
            }

            String rs = result.toString();

            System.out.println(rs.trim().equals("") ? "0" : rs.split(" ").length + " " + result);
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
