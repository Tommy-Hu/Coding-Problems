import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1369
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            int n = readInt();
            char[] bin = br.readLine().toCharArray();
            //Strategy:
            // 1. Eat as many zeros as possible, with one zero left which should be the closest to the end.
            // 2. Eat as many ones as possible.
            // 3. Done!

            int lastZeroIndex = -1;
            for (int i = 1; i < n; i++)
            {
                // Eat zeros and turn them into n if last one is 1 or n. It can be n because that means the last last
                // one has a zero removed, left with a 1.
                if ((bin[i - 1] == '1' || bin[i - 1] == 'n') && bin[i] == '0')
                {
                    bin[i] = 'n';
                    lastZeroIndex = i;
                }
            }

            if (lastZeroIndex == -1)
            {
                System.out.println(new String(bin));
                continue;
            }

            StringBuilder sb = new StringBuilder();
            int secondLastIndex = -1;
            for (int i = lastZeroIndex - 1; i >= 0; i--)
            {
                if (bin[i] == '0')
                {
                    secondLastIndex = i;
                    break;
                }
            }

            if (secondLastIndex != -1)
            {
                for (int i = 0; i <= secondLastIndex; i++)
                {
                    if (bin[i] != 'n')
                    {
                        sb.append(bin[i]);
                    }
                }
            }

            sb.append('0');

            for (int i = lastZeroIndex + 1; i < n; i++)
            {
                sb.append(bin[i]);
            }

            System.out.println(sb);
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
