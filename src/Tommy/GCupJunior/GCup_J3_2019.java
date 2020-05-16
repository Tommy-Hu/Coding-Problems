package Tommy.GCupJunior;

import java.util.*;

public class GCup_J3_2019
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double K = sc.nextDouble();

        String[] names = new String[N];
        double[] S = new double[N];

        for (int i = 0; i < N; i++)
        {
            names[i] = sc.next();
            S[i] = sc.nextDouble();
        }

        boolean[] shouldDelete = new boolean[N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (i != j)
                {
                    double ans = Math.abs(S[i] - S[j]);
                    if (ans <= K)
                    {
                        shouldDelete[i] = true;
                        break;
                    }
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < shouldDelete.length; i++)
        {
            if (!shouldDelete[i])
            {
                ans.add(names[i]);
            }
        }

        Collections.sort(ans);

        for (String n : ans)
        {
            System.out.print(n + " ");
        }
//        System.out.print("\b");
    }
}
