import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class LeetCode_DominosAndLShapedTrominos
{
    public static void main(String[] args) throws IOException
    {
        int N = readInt();
        System.out.println(NumTilings(N));
    }

    public static int NumTilings(int N)
    {
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];

        A[0] = 1;
        A[1] = 1;
        B[0] = 0;
        B[1] = 1;

        for (int i = 2; i <= N; i++)
        {
            A[i] = ((A[i - 1] + A[i - 2]) % 1000000007 + (B[i - 2] * 2) % 1000000007) % 1000000007;
            B[i] = (A[i - 1] + B[i - 1]) % 1000000007;
        }

        return A[N];
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
