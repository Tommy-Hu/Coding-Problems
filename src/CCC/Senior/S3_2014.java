package Senior;

import java.util.*;

public class S3_2014
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        short cases = sc.nextShort();

        TestLoop:
        for (int __ = 0; __ < cases; __++)
        {
            //read input
            int carCount = sc.nextInt();
            int[] cars = new int[carCount];
            for (int j = 0; j < carCount; j++)
            {
                cars[j] = sc.nextInt();
            }

            //start operation
            int lastNum = 0;
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            CarLoop:
            for (int i = carCount - 1; i >= 0; i--)
            {
                int carNum = cars[i];

                while (queue.size() != 0)
                {
                    if (queue.getFirst().equals(lastNum + 1))
                    {
                        queue.pop();
                        lastNum++;
                    }
                    else
                    {
                        break;
                    }
                }

                if (queue.size() == 0 || !queue.getFirst().equals(lastNum + 1))
                {
                    //nothing in the branch or first in branch is not 1 + lastCar
                    if (carNum == lastNum + 1)
                    {
                        //carNum is equal to the number of the last car that went into the pool plus 1
                        lastNum++;
                    }
                    else
                    {
                        queue.push(carNum);
                    }
                    continue;
                }


                System.out.println("N");
                continue TestLoop;
            }

            while (queue.size() != 0)
            {
                if (!queue.pop().equals(lastNum + 1))
                {
                    break;
                }
                lastNum++;
            }

            if (queue.size() == 0)
            {
                System.out.println("Y");
            }
            else
            {
                System.out.println("N");
            }
        }

    }
}
