package Tommy.Codeforces;

import javax.imageio.metadata.IIOInvalidTreeException;
import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_D_1352
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int i = 0; i < t; i++)
        {
            int n = readInt();
            LinkedList<Integer> candies = new LinkedList<>();
            for (int j = 0; j < n; j++)
            {
                candies.add(readInt());
            }

            int last = candies.pop();

            int moves = 1;
            int eatenL = last;
            int eatenR = 0;

            boolean lastL = true;
            while (candies.size() > 0)
            {
                moves++;
                int sum = 0;
                if (lastL)
                {
                    while (true)
                    {
                        if (candies.size() <= 0)
                        {
                            break;
                        }
                        sum += candies.pollLast();
                        if (sum > last)
                        {
                            last = sum;
                            break;
                        }
                    }
                    eatenR += sum;
                }
                else
                {
                    while (true)
                    {
                        if (candies.size() <= 0)
                        {
                            break;
                        }
                        sum += candies.pop();
                        if (sum > last)
                        {
                            last = sum;
                            break;
                        }
                    }
                    eatenL += sum;
                }
                lastL = !lastL;
            }

            System.out.println(moves + " " + eatenL + " " + eatenR);
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
