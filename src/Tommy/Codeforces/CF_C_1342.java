package Tommy.Codeforces;

import java.util.*;

public class CF_C_1342
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = (int) sc.nextLong();
        for (int i = 0; i < t; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int q = sc.nextInt();

            //length of period
            int periodLen = a * b;
            long periodTotal = 0;
            //starts from index 0
            long[] partialSums = new long[periodLen];
            for (int j = 0; j < periodLen; j++)
            {
                if ((j % a) % b != (j % b) % a)
                {
                    //this means in one cycle, this is a counted number
                    periodTotal++;
                }
                partialSums[j] = periodTotal;
            }

            for (int j = 0; j < q; j++)
            {
                long l = sc.nextLong();
                long r = sc.nextLong();


                long periodCount = (r - l) / periodLen;
                long answer = periodCount * periodTotal;
                long offsetIndex = periodLen * (r / periodLen);
                long index = l + periodLen * periodCount - offsetIndex;
                answer += partialSums[(int) (r - offsetIndex)] - partialSums[(int) (index - 1)];

                System.out.println(answer);
            }
        }
    }
}
