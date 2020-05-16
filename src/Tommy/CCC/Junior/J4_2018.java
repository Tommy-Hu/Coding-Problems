package Tommy.CCC.Junior;

import java.io.*;
import java.util.*;

public class J4_2018
{
    static int CollCount = 0;
    static List<List<Integer>> AllRows = new ArrayList<>();

    static List<List<String>> Answer = new ArrayList<>();

    public static void main(String[] args) throws IOException
    {
        //Read in Coll Count
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CollCount = Integer.parseInt(reader.readLine());

        //Read in All Lists
        for (int i = 0; i < CollCount; i++)
        {
            String oneLine = reader.readLine();
            List<Integer> oneRow = new ArrayList<>();
            for (int j = 0; j < CollCount; j++)
            {
                oneRow.add(Integer.parseInt(oneLine.split(" ")[j]));
            }
            AllRows.add(oneRow);
        }

        //Alter the Lists and print it out
        AlterList();
//        System.out.print("\n\n\n");
        PrintOutAnswer();
    }

    /**
     * Should return a number less than or equal to 3 (<=3)
     */
    static void AlterList()
    {
        boolean answerFound = false;
        while (!answerFound)
        {
            if (IsCollumOK() && IsRowOK())
            {
                answerFound = true;
                break;
            }

            RotateListBy90();
        }
    }

    /**
     * Print out the Answer
     */
    static void PrintOutAnswer()
    {
        String ans = "";
        for (int i = 0; i < CollCount; i++)
        {
            String row = "";
            for (int j = 0; j < CollCount; j++)
            {
                row += (" " + AllRows.get(i).get(j));
            }
            row = row.substring(1);
            ans += "\n"+row;
        }

        System.out.print(ans.substring(1));
    }

    private static boolean IsRowOK()
    {
        for (int i = 0; i < CollCount; i++)
        {
            int lastNum = 0;
            for (int j = 0; j < CollCount; j++)
            {
                if (AllRows.get(i).get(j) > lastNum)
                {
                    lastNum = AllRows.get(i).get(j);
                } else
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean IsCollumOK()
    {
        for (int i = 0; i < CollCount; i++)
        {
            int lastNum = 0;
            for (int j = 0; j < CollCount; j++)
            {
                if (AllRows.get(j).get(i) > lastNum)
                {
                    lastNum = AllRows.get(j).get(i);
                } else
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static void RotateListBy90()
    {
        List<List<Integer>> before = new ArrayList<>();
        before.addAll(AllRows);
        AllRows.clear();

        for (int j = 0; j < CollCount; j++)
        {
            List<Integer> oneRow = new ArrayList<>();
            for (int i = CollCount - 1; i >= 0; i--)
            {
                oneRow.add(before.get(i).get(j));
            }
            AllRows.add(oneRow);
        }
//        System.out.print(AllRows);
    }
}
