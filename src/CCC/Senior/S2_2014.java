package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_2014
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int count = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        Map<String, String> dictionary = new HashMap<>();

        for (int i = 0; i < count; i++)
        {
            Object o = dictionary.get(b[i]);
            if (a[i].equals(b[i]) || (o != null && !o.equals(a[i])))
            {
                System.out.print("bad");
                return;
            }
            dictionary.put(a[i], b[i]);
        }
        System.out.print("good");
    }
}
