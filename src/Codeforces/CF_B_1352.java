import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_B_1352
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        TestLoop:
        for (int i = 0; i < t; i++)
        {
            int n = readInt(), k = readInt();
            if (k % 2 == 0 && n % 2 != 0)
            {
                //can't be produced
                System.out.println("NO");
                continue;
            }
            int div = Math.floorDiv(n, k);
            if (n % k == 0)
            {
                System.out.println("YES");
                for (int j = 0; j < k; j++)
                {
                    System.out.print(div + " ");
                }
                System.out.println();
                continue;
            }
            int[] answers = new int[k];
            Arrays.fill(answers, div);
            while (true)
            {
                int current = 0;
                for (int f: answers)
                {
                    current += f;
                }
                int remaining = n - current;
                if (remaining == 0)
                {
                    if (answers[0] <= 0)
                    {
                        System.out.println("NO");
                        continue TestLoop;
                    }
                    System.out.println("YES");
                    for (int answer: answers)
                    {
                        System.out.print(answer + " ");
                    }
                    System.out.println();
                    continue TestLoop;
                }
                else if (remaining % 2 == 0)
                {
                    Arrays.sort(answers);
                    if (current > n)
                    {
                        answers[k - 1] -= 2;
                        if (answers[k - 1] <= 0)
                        {
                            for (int j = 0; j < answers.length; j++)
                            {
                                answers[j]++;
                            }
                            int newSum = 0;
                            for (int f: answers)
                            {
                                newSum += f;
                            }
                            int newRemainder = n - newSum;
                            if (newRemainder % 2 != 0)
                            {
                                System.out.println("NO");
                                continue TestLoop;
                            }
                        }
                    }
                    else
                    {
                        answers[k - 1] += 2;
                    }
                }
                else
                {
                    for (int j = 0; j < answers.length; j++)
                    {
                        answers[j]++;
                    }
                    int newSum = 0;
                    for (int f: answers)
                    {
                        newSum += f;
                    }
                    int newRemainder = n - newSum;
                    if (newRemainder % 2 != 0)
                    {
                        System.out.println("NO");
                        continue TestLoop;
                    }
                }
            }
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
