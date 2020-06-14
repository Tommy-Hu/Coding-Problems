import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1358
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int[] grannies = new int[n];
            for (int i = 0; i < n; i++)
            {
                grannies[i] = readInt();
            }
            Arrays.sort(grannies);
            int currentCount = 1;
            PriorityQueue<Integer> passedGrannies = new PriorityQueue<>(Collections.reverseOrder());
            for (int granny: grannies)
            {
                //more than or equal to what the granny desires.
                if (currentCount >= granny)
                {
                    currentCount++;
                }
                else
                {
                    passedGrannies.add(granny);
                    if (passedGrannies.size() > 0 && passedGrannies.peek() - passedGrannies.size() - currentCount < 0)
                    {
                        currentCount += passedGrannies.size();
                        passedGrannies.clear();
                    }
                }
            }
            System.out.println(currentCount);
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
