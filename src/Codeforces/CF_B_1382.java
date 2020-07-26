import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1382
{
    public static void main(String[] args) throws IOException
    {
        long t = readLong();
        for (int __ = 0; __ < t; __++)
        {
            int n = (int) readLong();

            long[] nums = new long[n];
            for (int i = 0; i < n; i++)
            {
                nums[i] = readLong();
            }
            boolean fWin = true;
            //first wins if he is the first to take the last pile
            //only one: if fWin, then f is forced to take the only 1, which means the next pile is s's control. s can
            //          take all except one from the next pile. (Except if only 1 in the next pile also)
            //          this makes the last person who took 1 loose.
            //          so the new goal is to make the other person take 1

            long continuousOnes = 0;
            for (int i = 0; i < nums.length; i++)
            {
                if (nums[i] == 1)
                {
                    continuousOnes++;
                }
                else
                {
                    break;
                }
            }
            if (continuousOnes == n)
            {
                System.out.println(continuousOnes % 2 == 0 ? "Second" : "First");
            }
            else
            {
                System.out.println(continuousOnes % 2 != 0 ? "Second" : "First");
            }
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
