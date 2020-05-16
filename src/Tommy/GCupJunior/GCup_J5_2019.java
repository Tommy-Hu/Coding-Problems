package Tommy.GCupJunior;

import java.util.*;

public class GCup_J5_2019
{
    static String A;
    static String B;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLine();
        B = sc.nextLine();
        if (A.equals(B))
        {
            System.out.println("aliens");
            return;
        }

        trimStart();
        trimEnd();
        trimMiddle();

        testSubstrings();
    }

    private static void trimMiddle()
    {
        int start = A.length() / 2;
        if (A.charAt(start) == B.charAt(start))
        {
            int left = 0;
            int right = 0;
            for (int i = start; i >= 0; i--)
            {
                if (A.charAt(i) != B.charAt(i))
                {
                    left = i + 1;
                }
            }
            for (int i = start + 1; i < A.length(); i++)
            {
                if (A.charAt(i) != B.charAt(i))
                {
                    right = i;
                }
            }

            A = A.substring(0, left) + A.substring(right);
            B = B.substring(0, left) + B.substring(right);
        }
    }

    private static void testSubstrings()
    {
        List<Integer> allNumber1 = getBIndices(A, B.charAt(0));
        for (int n: allNumber1)
        {
            String substring = A.substring(0, n);
            if ((A.substring(n) + substring).equals(B))
            {
                System.out.println("aliens");
                return;
            }
        }

        System.out.println("no aliens");
    }

    private static void trimEnd()
    {
        int strLen = A.length();
        if (A.charAt(strLen - 1) == B.charAt(strLen - 1))
        {
            for (int i = strLen - 1; i >= 0; i--)
            {
                if (A.charAt(i) != B.charAt(i))
                {
                    A = A.substring(0, i + 1);
                    B = B.substring(0, i + 1);
                    break;
                }
            }
        }
    }

    private static void trimStart()
    {
        if (A.charAt(0) == B.charAt(0))
        {
            for (int i = 1; i < A.length(); i++)
            {
                if (A.charAt(i) != B.charAt(i))
                {
                    A = A.substring(i);
                    B = B.substring(i);
                    break;
                }
            }
        }
    }

    private static List<Integer> getBIndices(String A, char b1)
    {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < A.length(); i++)
        {
            if (A.charAt(i) == b1)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}