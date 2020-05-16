package Tommy.CCC.Senior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S2_2013
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int totalWeightAllowed = s.nextInt();
        int trainCount = s.nextInt();
        List<Integer> trainWeights = new ArrayList<>();
        for (int i = 0; i < trainCount; i++)
        {
            trainWeights.add(s.nextInt());
        }

        int currentWeight = 0;
        int ans = 0;
        for (int i = 0; i < trainCount; i++)
        {
            currentWeight += trainWeights.get(i);
            if (i > 3)//removes the first car weight from the total current weight
            {
                currentWeight -= trainWeights.get(i - 4);
            }
            if (currentWeight > totalWeightAllowed)
            {
                System.out.print(ans);
                return;
            }
            ans++;
        }

        System.out.print(ans);
    }
}
