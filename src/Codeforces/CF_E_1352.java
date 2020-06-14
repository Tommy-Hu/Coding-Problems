import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_E_1352
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int i = 0; i < t; i++)
        {
            int n = readInt();
            int[] elements = new int[n];
            int[] countOfElements = new int[n];
            for (int j = 0; j < n; j++)
            {
                var el = readInt();
                elements[j] = el;
                countOfElements[el - 1]++;
            }
            long sum = 0;
            for (int j = 0; j < n - 1; j++)
            {
                int curSum = elements[j];
                for (int k = j + 1; k < n; k++)
                {
                    curSum += elements[k];
                    if (curSum > n)
                    {
                        break;
                    }
                    int count = countOfElements[curSum - 1];
                    if (count > 0)
                    {
                        sum += count;
                        countOfElements[curSum - 1] = 0;
                    }
                }
            }
            System.out.println(sum);
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
