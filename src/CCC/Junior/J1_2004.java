package Junior;

import java.util.Scanner;

public class J1_2004
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int ct = s.nextInt();

        Double ans = Math.sqrt(ct);
        System.out.print("The largest square has side length " + ans.intValue() + ".");
    }
}