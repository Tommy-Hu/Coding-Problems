package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class J2_2019
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        List<String> strs = new ArrayList<>();
        for (int i = 0; i < count; i++)
        {
            strs.add(reader.readLine());
        }

        for (String str: strs)
        {
            for (int k = 0; k < Integer.parseInt(str.split(" ")[0]); k++)
            {
                System.out.print(str.split(" ")[1]);
            }
            System.out.print("\n");
        }
    }
}
