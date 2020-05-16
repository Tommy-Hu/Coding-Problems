package Tommy.CCC.Senior;

import java.util.*;

public class S1_2010
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();

        int topSpeed = -1000;
        int secondSpeed = -1000;
        String topName = "";
        String secondName = "";
        for (int i = 0; i < count; i++)
        {
            String name = s.next();
            int R = s.nextInt();
            int S = s.nextInt();
            int D = s.nextInt();
//            System.out.print(name + " " + R + " " + S + " " + D + "\n");
            int speed = 2 * R + 3 * S + D;
            if (speed > topSpeed)
            {
                secondSpeed = topSpeed;
                secondName = topName;
                topSpeed = speed;
                topName = name;
            }
            else if (speed == topSpeed)
            {
                if (name.compareTo(topName) < 0)
                {
                    secondSpeed = topSpeed;
                    secondName = topName;
                    topSpeed = speed;
                    topName = name;
                }
                else if (name.compareTo(secondName) < 0)
                {
                    secondSpeed = speed;
                    secondName = name;
                }
            }
            else if (speed > secondSpeed)
            {
                secondSpeed = speed;
                secondName = name;
            }
            else if (speed == secondSpeed)
            {
                if (name.compareTo(secondName) < 0)
                {
                    secondSpeed = speed;
                    secondName = name;
                }
            }

        }

        System.out.print(topName + "\n" + secondName);
    }
}

//2R+3S+D