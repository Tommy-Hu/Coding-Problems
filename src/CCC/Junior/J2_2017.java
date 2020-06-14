package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2_2017
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int original = Integer.parseInt(reader.readLine());
        int timesShifted = Integer.parseInt(reader.readLine());

        int ans = original;

        for (int i = 1; i < timesShifted + 1; i++)
        {
            int a = (int) (Math.pow(10, i));
            ans += original * a;
        }


        System.out.print(ans);
    }
}
