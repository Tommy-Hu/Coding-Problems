package Tommy.CCC.Senior;

import java.util.*;

public class S2_2004
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] scores = new int[n];
        int[] rankWorst = new int[n];
        List<Integer> topIndices = new ArrayList<>();
        int top = -10000000;
        for (int i = 0; i < k; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int num = sc.nextInt();
                scores[j] += num;

                if (i == k - 1)
                {
                    if (scores[j] > top)
                    {
                        top = scores[j];
                        topIndices.clear();
                        topIndices.add(j);
                    }
                    else if (scores[j] == top)
                    {
                        topIndices.add(j);
                    }
                }
            }

            //below is correct
            int[] clone = scores.clone();
            Arrays.sort(clone);
            for (int j = 0; j < n; j++)
            {
                int currentRank = 0;
                for (int l = clone.length - 1; l >= 0; l--)
                {
                    if (clone[l] == scores[j])
                    {
                        currentRank = n - l;
                        break;
                    }
                }

                rankWorst[j] = Math.max(rankWorst[j], currentRank);
            }
        }

        Collections.sort(topIndices);
        for (int i = 0; i < topIndices.size(); i++)
        {
            System.out.println("Yodeller " + (topIndices.get(i) + 1) + " is the TopYodeller: score " + scores
                    [topIndices.get(i)] + ", worst rank " + rankWorst[topIndices.get(i)]);
        }

    }
}
