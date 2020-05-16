package Tommy.CCC.Senior;

import java.util.*;

public class S2_2010
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int ct = sc.nextInt();

        sc.nextLine();

        Map<String, Character> dictionary = new HashMap<>();
        for (int i = 0; i < ct; i++)
        {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            dictionary.put(parts[1], parts[0].toCharArray()[0]);
        }

        String ans = "";
        String current = "";
        String line = sc.nextLine();
        while (line.length() > 0)
        {
            current += line.charAt(0);
            line = line.substring(1);
            if (dictionary.containsKey(current))
            {
                ans += dictionary.get(current);
                current = "";
            }
        }

        System.out.println(ans);
    }
}
