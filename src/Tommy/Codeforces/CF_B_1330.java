package Tommy.Codeforces;

import java.io.*;
import java.util.*;

public class CF_B_1330
{
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++)
        {
            int count = Integer.parseInt(br.readLine());
            int[] a = new int[count];
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < count; j++)
            {
                a[j] = Integer.parseInt(line[j]);
            }

            boolean[] part1 = new boolean[count];
            boolean[] part2 = new boolean[count];
            HashSet<Integer> beenTo = new HashSet<>();
            long current = 0L;

            for (int j = 1; j < count; j++)
            {
                if (beenTo.contains(a[j - 1]))
                {
                    break;
                }
                current += a[j - 1];
                long arithmeticSequenceSum = (long) j * (1L + (long) j) / 2L;
                if (current == arithmeticSequenceSum)
                {
                    part1[j] = true;
                }
                beenTo.add(a[j - 1]);
            }

            beenTo.clear();
            current = 0;
            int answerCount = 0;
            for (int j = count - 1; j >= 0; j--)
            {
                if (beenTo.contains(a[j]))
                {
                    break;
                }
                current += a[j];
                if (part1[j])
                {
                    long arithmeticSequenceSum = (long) (count - j) * (1L + ((long) count - j)) / 2L;
                    if (current == arithmeticSequenceSum)
                    {
                        part2[j] = true;
                        answerCount++;
                    }
                }
                beenTo.add(a[j]);
            }

            pw.println(answerCount);
            for (int j = 0; j < part2.length; j++)
            {
                if (part2[j])
                {
                    pw.println(j + " " + (count - j));
                }
            }
        }
        pw.flush();
    }
}
