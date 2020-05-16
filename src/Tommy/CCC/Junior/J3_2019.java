package Tommy.CCC.Junior;

import java.io.*;
import java.util.*;

public class J3_2019
{
    static int count = 0;
    static List<String> lines = new ArrayList<>();
    static List<String> ansLines = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        ReadInput();

        FindAnsLines();

        for (String s : ansLines)
        {
            System.out.println(s);
        }
    }

    private static void FindAnsLines()
    {
        char lastChar;
        for (String line : lines)
        {
            int num = 1;
            String ansLine = "";
            lastChar = line.charAt(0);
            for (int i = 1; i < line.length(); i++)
            {
                if (lastChar == line.charAt(i))
                {
                    num++;
                } else
                {
                    ansLine += (num + " " + lastChar + " ");
                    lastChar = line.charAt(i);
                    num = 1;
                }
            }

            ansLine += (num + " " + lastChar + " ");

            ansLines.add(ansLine.substring(0, ansLine.length() - 1));//Removes blank at the end
        }
    }

    static void ReadInput() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++)
        {
            lines.add(reader.readLine());
        }
    }
}
