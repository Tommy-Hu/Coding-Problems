import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_F_1352
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int i = 0; i < t; i++)
        {
            int n1 = readInt();
            int n2 = readInt();
            int n3 = readInt();
            if (n2 == 0)
            {
                System.out.println(n1 > 0 ? "0".repeat(n1 + 1) : "1".repeat(n3 + 1));
                continue;
            }
            StringBuilder result = new StringBuilder();
            result.append("0".repeat(n1 + 1));
            result.append("1".repeat(n2 + n3));
            int replaceIndex = n1 + 2;
            float max = (n2 - 1) / 2f;
            if (n2 % 2 == 0)
            {
                result.setCharAt(n1 + n2 + n3, '0');
                max--;
            }
            for (int j = 0; j < max; j++)
            {
                result.setCharAt(replaceIndex, '0');
                replaceIndex += 2;
            }
            System.out.println(result.toString());
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
