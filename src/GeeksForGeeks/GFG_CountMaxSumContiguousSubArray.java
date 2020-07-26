import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GFG_CountMaxSumContiguousSubArray
{
    public static void main(String[] args) throws IOException
    {
        int N = readInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
        {
            int num = readInt();
            nums[i] = num;
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
