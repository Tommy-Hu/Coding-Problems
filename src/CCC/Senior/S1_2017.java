package Senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class S1_2017
{
    static int days = 0;
    static List<Integer> lineOne = new ArrayList<>();
    static List<Integer> lineTwo = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        ReadInput();

        out.print(GetLargestK());
    }

    private static int GetLargestK()
    {
        int largestK = 0;

        int lastLineOneSum = 0;
        int lastLineTwoSum = 0;
        for (int i = 0; i < days; i++)
        {
            lastLineOneSum += lineOne.get(i);
            lastLineTwoSum += lineTwo.get(i);
            if (lastLineOneSum == lastLineTwoSum)
            {
                largestK = i + 1;
            }
        }
        return largestK;
    }

    static void ReadInput() throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        days = Integer.parseInt(reader.readLine());
        String line1 = reader.readLine();
        String line2 = reader.readLine();

        for (String part: line1.split(" "))
        {
            lineOne.add(Integer.parseInt(part));
        }

        for (String part: line2.split(" "))
        {
            lineTwo.add(Integer.parseInt(part));
        }
    }
}
