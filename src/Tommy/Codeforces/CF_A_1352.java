package Tommy.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_A_1352
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int i = 0; i < t; i++)
        {
            int n = readInt();
            List<Integer> answers = new ArrayList<>();

            int zeroCount = 0;
            while (n > 0)
            {
                int remainder = n % 10;
                if (remainder > 0)
                {
                    answers.add(remainder * (zeroCount == 0 ? 1 : (int) Math.pow(10, zeroCount)));
                }
                n /= 10;
                zeroCount++;
            }

            System.out.println(answers.size());
            for (Integer answer: answers)
            {
                System.out.print(answer + " ");
            }
            System.out.println();
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
