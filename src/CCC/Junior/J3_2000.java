package Junior;

import java.util.Scanner;

public class J3_2000
{
    static int quarters = 0;
    static int count = 0;

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        quarters = s.nextInt();
        int firstMachineState = s.nextInt();
        int secondMachineState = s.nextInt();
        int thirdMachineState = s.nextInt();


        while (true)
        {
            firstMachineState = play(35, firstMachineState, 30);
            if (quarters <= 0)
            {
                break;
            }

            secondMachineState = play(100, secondMachineState, 60);
            if (quarters <= 0)
            {
                break;
            }

            thirdMachineState = play(10, thirdMachineState, 9);
            if (quarters <= 0)
            {
                break;
            }
        }

        System.out.print("Martha plays " + count + " times before going broke.");
    }

    static int play(int machineMax, int machineState, int giveAmount)
    {
        quarters--;
        machineState++;
        if (machineState >= machineMax)
        {
            machineState = 0;
            quarters += giveAmount;
        }
        count++;
        return machineState;
    }
}
