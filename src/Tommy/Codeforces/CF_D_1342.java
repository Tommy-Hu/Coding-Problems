package Tommy.Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_D_1342
{
    public static void main(String[] args) throws IOException
    {
        int n = readInt(), k = readInt();
        int[] m = new int[n];//the sizes of the original arrays
        for (int i = 0; i < n; i++)
        {
            m[i] = readInt();
        }
        int[] c = new int[k];//no more than c i'th arrays of size >= i in each test-case
        for (int i = 0; i < k; i++)
        {
            c[i] = readInt();
        }
        Arrays.sort(m);

        int count = 0;

        List<List<Integer>> answer = new ArrayList<>();

        while (true)
        {
            List<Integer> currentTest = new ArrayList<>();
            int[] currentConstraints = Arrays.copyOf(c, k);
            boolean finished = true;
            for (int i = n - 1; i >= 0; i--)
            {
                int arrayLen = m[i];
                if (arrayLen != -1)
                {
                    //operate
                    finished = false;

                    if (checkConstraints(currentConstraints, arrayLen))
                    {
                        m[i] = -1;
                        changeConstraints(currentConstraints, arrayLen);
                        currentTest.add(arrayLen);
                    }
                    else
                    {
                        break;
                    }
                }
            }
            if (finished)
            {
                break;
            }
            answer.add(currentTest);
            count++;
        }

        System.out.println(count);
        for (int i = 0; i < count; i++)
        {
            var a = answer.get(i);
            System.out.print(a.size());
            for (Integer integer: a)
            {
                System.out.print(" " + integer);
            }
            System.out.print("\n");
        }
    }

    private static boolean checkConstraints(int[] constraints, int len)
    {
        return constraints[len - 1] > 0;
    }

    private static void changeConstraints(int[] constraints, int len)
    {
        for (int i = 0; i < len; i++)
        {
            constraints[i]--;
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
