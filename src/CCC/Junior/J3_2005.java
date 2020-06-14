package Junior;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J3_2005
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        List<String> instructions = new ArrayList<>();
        while (true)
        {
            String line = sc.nextLine();
            if (line.equals("SCHOOL"))
            {
                break;
            }
            instructions.add(line);
        }

        for (int i = instructions.size() - 1; i >= 0; i -= 2)
        {
            String cmd = instructions.get(i);
            if (i - 1 <= 0)
            {
                System.out.println("Turn " + (cmd.equals("R") ? "LEFT" : "RIGHT") + " into your HOME.");
                return;
            }
            String rd = instructions.get(i - 1);

            if (cmd.equals("R"))
            {
                System.out.println("Turn LEFT onto " + rd + " street.");
            }
            else
            {
                System.out.println("Turn RIGHT onto " + rd + " street.");
            }
        }
    }
}
