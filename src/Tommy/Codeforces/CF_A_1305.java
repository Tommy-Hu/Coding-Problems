package Tommy.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_A_1305
{
    public static void main(String[] args) throws IOException
    {
        int cases = readInt();

        for (int i = 0; i < cases; i++)
        {
            int n = readInt();
            int[] necklaces = new int[n];
            int[] bracelets = new int[n];
            for (int j = 0; j < n; j++)
            {
                necklaces[j] = readInt();
            }
            for (int j = 0; j < n; j++)
            {
                bracelets[j] = readInt();
            }

            PrintPerfectCombination(necklaces, bracelets);
        }
    }


    static void PrintPerfectCombination(int[] necklaces, int[] bracelets)
    {
        int len = necklaces.length;
        Arrays.sort(necklaces);
        Arrays.sort(bracelets);
        int[] daughterBraceletSelections = new int[len];
        daughterBraceletSelections[0] = bracelets[0];
        int lastSum = bracelets[0];
        for (int i = 1; i < len; i++)
        {
            int currentSum = bracelets[i] + necklaces[i];
            if (currentSum == lastSum)
            {
                //swap until correct
                boolean found = false;
                for (int j = i - 1; j >= 1; j--)
                {
                    if (bracelets[j] + necklaces[j] != currentSum)
                    {
                        found = true;
                        break;
                    }
                }
                if (!found)
                {
                    int current = bracelets[i];
                    bracelets[i] = bracelets[len - 1];
                    bracelets[len - 1] = current;
                }
            }
            else
            {
                lastSum = currentSum;
                daughterBraceletSelections[i] = bracelets[i];
            }
        }

        for (int nck: necklaces)
        {
            System.out.print(nck + " ");
        }
        System.out.println();
        for (int brc: daughterBraceletSelections)
        {
            System.out.print(brc + " ");
        }
        System.out.println();
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
