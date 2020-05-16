package Tommy.CCC.Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1_2017
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(reader.readLine());
        int num2 = Integer.parseInt(reader.readLine());

        int ans = 0;
        if (num1 < 0)
        {
            if (num2 < 0)
            {
                ans = 3;
            } else
            {
                ans = 2;
            }
        } else
        {
            if (num2 < 0)
            {
                ans = 4;
            } else
            {
                ans = 1;
            }
        }
        System.out.print(ans);
    }

}
