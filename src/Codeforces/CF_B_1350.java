import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1350
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            int[] models = new int[n + 1];
            int[] modelsCount = new int[n + 1];
            for (int i = 1; i <= n; i++)
            {
                models[i] = readInt();
                modelsCount[i] = 1;
            }
            int maxCount = 1;
            for (int i = 1; i <= n; i++)
            {
                for (int step = i; step <= n; step += i)
                {
                    if (models[step] > models[i] && modelsCount[i] + 1 > modelsCount[step])
                    {
                        modelsCount[step] = 1 + modelsCount[i];
                        maxCount = Integer.max(maxCount, modelsCount[step]);
                    }
                }
            }
            System.out.println(maxCount);
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
