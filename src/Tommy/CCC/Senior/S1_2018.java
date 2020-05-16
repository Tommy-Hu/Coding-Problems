package Tommy.CCC.Senior;

import java.text.DecimalFormat;
import java.util.*;

public class S1_2018
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int ct = s.nextInt();

        List<Double> orig = new ArrayList<>();
        for (int i = 0; i < ct; i++)
        {
            orig.add(s.nextDouble());
        }
        Collections.sort(orig);

        double smallestAns = Double.MAX_VALUE;

        for (int i = 0; i < ct - 2; i++)
        {
            final double j = (orig.get(i + 1) - orig.get(i)) / 2;
            final double f = (orig.get(i + 2) - orig.get(i + 1)) / 2;
            if (j + f < smallestAns)
            {
                smallestAns = j + f;
            }
        }

        System.out.print(new DecimalFormat(".#").format(smallestAns));
    }
}
