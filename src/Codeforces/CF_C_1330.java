import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF_C_1330
{
    public static void main(String[] args) throws IOException
    {
        int n = readInt();
        int m = readInt();
        long[] lengths = new long[m];
        long[] indices = new long[m];
        long total = 0;
        for (int i = 0; i < m; i++)
        {
            lengths[i] = readInt();
            indices[i] = i;
            total += lengths[i];
        }
        if (total < n)
        {
            System.out.println("-1");
            return;
        }
        long rightMostIndex = 0;
        for (int i = 0; i < m; i++)
        {
            rightMostIndex = Math.max(rightMostIndex, i + lengths[i] - 1);
        }
        if (rightMostIndex >= n)
        {
            System.out.println("-1");
            return;
        }
        if (m == 2L)
        {
            System.out.println("1 " + (n - lengths[1] + 1));
            return;
        }
        long tilesLeft = n - rightMostIndex - 1;
        long rightCount = 0;
        for (int i = 1; i < m; i++)
        {
            long totalMovableCount = lengths[i - 1] - 1;
            if (totalMovableCount >= tilesLeft)
            {
                rightCount += tilesLeft;
                indices[i] += rightCount;
                tilesLeft = 0;
            }
            else
            {
                tilesLeft -= totalMovableCount;
                rightCount += totalMovableCount;
                indices[i] += rightCount;
            }
        }
        for (int i = 0; i < indices.length; i++)
        {
            System.out.print((indices[i] + 1L) + (i == indices.length - 1 ? "" : " "));
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
