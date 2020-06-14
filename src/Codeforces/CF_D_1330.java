import java.util.*;

public class CF_D_1330
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++)
        {
            int d = sc.nextInt();
            int m = sc.nextInt();
            for (int n = 1; n <= d; n++)
            {
                //d is maximum length
                //n is the length of the array
                //get all arrays with size n that satisfy the third constraints
                int count = 0;
                NLoop:
                for (int j = 0; j < n; j++)
                {
                    //use j as the start of the array
                    int[] a = getArray(j, n);
                    int[] b = new int[n];
                    b[0] = a[0];
                    int cur = a[0];
                    for (int k = 1; k < n; k++)
                    {
                        b[k] = b[k - 1] ^ a[k];
                        if (cur >= b[k])
                        {
                            //nope
                            continue NLoop;
                        }
                    }
                    //b satisfies!
                    //so a satisfies!
                    count++;
                }
            }
        }
    }

    private static int[] getArray(int j, int n)
    {
        return null;
    }
}
