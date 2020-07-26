import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_C_915
{
    public static void main(String[] args) throws IOException
    {
        char[] aChars = br.readLine().toCharArray();
        int[] digitCounts = new int[10];//the ith is the count of that digit.
        Integer[] digits = new Integer[aChars.length];
        for (int i = 0; i < aChars.length; i++)
        {
            int digit = aChars[i] - '0';
            digitCounts[digit]++;
            digits[i] = digit;
        }
        String bStr = br.readLine();
        long b = Long.parseLong(bStr);

        if (bStr.length() > aChars.length)
        {
            //if a dont have as many digits as b, the largest is the digits' reverse order.
            Arrays.sort(digits, Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            for (Integer digit: digits)
            {
                sb.append(digit);
            }
            System.out.println(sb);
        }
        else
        {
            //since it is guaranteed that an answer always exists, the only other case is a and b have the same digit counts.
            //always form a appropriate string.
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digits.length; i++)
            {
                for (int j = 9; j >= 0; j--)
                {
                    if (digitCounts[j] > 0)
                    {
                        String test = sb.toString();
                        if (isAppropriate(b, test, j, digitCounts))//is appropriate
                        {
                            digitCounts[j]--;
                            sb.append(j);
                            break;
                        }
                    }
                }
            }
            System.out.println(sb);
        }
    }

    public static boolean isAppropriate(long b, String current, int testDigit, int[] digitCounts)
    {
        digitCounts[testDigit]--;
        StringBuilder sb = new StringBuilder(current);
        sb.append(testDigit);
        for (int i = 0; i <= 9; i++)
        {
            sb.append(String.valueOf(i).repeat(Math.max(0, digitCounts[i])));
        }
        digitCounts[testDigit]++;

        long test = Long.parseLong(sb.toString());
        if (test <= b)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
}
