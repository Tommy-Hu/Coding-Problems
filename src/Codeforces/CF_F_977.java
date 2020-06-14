import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_F_977
{
    public static void main(String[] args) throws IOException
    {
        int n = readInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] elements = new int[n + 1];
        int largest = 0;
        int count = 0;
        int lastIndex = 1;
        for (int i = 1; i <= n; i++)
        {
            int num = readInt();
            elements[i] = num;
            Integer f = map.get(num - 1);
            int c = (f == null ? 0 : f) + 1;
            map.put(num, c);
            if (count < c)
            {
                count = c;
                largest = num;
                lastIndex = i;
            }
        }
        int cur = largest;
        int[] indices = new int[n];
        int pos = n - 1;
        for (int i = lastIndex; i > 0; i--)
        {
            if (elements[i] == cur)
            {
                indices[pos] = i;
                cur--;
                pos--;
                if (cur <= 0)
                {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for (int i = pos + 1; i < n; i++)
        {
            sb.append(indices[i]).append(' ');
        }
        System.out.println(sb);
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
