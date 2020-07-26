import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class GFG_MaxSumContiguousSubArray
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int N = readInt();
            int[] numbers = new int[N + 1];
            for (int i = 1; i <= N; i++)
            {
                numbers[i] = readInt();
            }

            int maxSoFar = 0;
            // The overall max sum. This will be updated with maxToHere if maxToHere is greater. It will never be less
            // because maxToHere is never negative.
            int maxToHere = 0;
            // MaxToHere is the positive amount left over. When it is less than '0',
            // that means the sum will not be greater anymore, so instead, change it back to zero.
            int largestNegative = Integer.MIN_VALUE;
            boolean foundPositive = false;
            for (int i = 1; i <= N; i++)
            {
                maxToHere += numbers[i];
                if (!foundPositive && numbers[i] < 0 && numbers[i] > largestNegative)
                {
                    largestNegative = numbers[i];
                }
                else if (numbers[i] > 0)
                {
                    foundPositive = true;
                }

                if (maxToHere < 0)
                {
                    maxToHere = 0;
                }
                else if (maxSoFar < maxToHere)
                {
                    maxSoFar = maxToHere;
                }
            }

            System.out.println(foundPositive ? maxSoFar : largestNegative);
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
