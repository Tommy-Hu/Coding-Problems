import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_C_1352
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (int i = 0; i < t; i++)
        {
            long n = readLong();
            long k = readLong();
            long answer = k;
            answer += Math.floorDiv(k - 1, n - 1);
            System.out.println(answer);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long readLong() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Long.parseLong(st.nextToken());
    }
}
