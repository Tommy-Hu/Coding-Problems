package Tommy.CCC.Junior;

import java.util.Scanner;

public class J3_2008
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //region Arrays
        char[] line1 = new char[]{
                'A',
                'B',
                'C',
                'D',
                'E',
                'F'
        };
        char[] line2 = new char[]{
                'G',
                'H',
                'I',
                'J',
                'K',
                'L'
        };
        char[] line3 = new char[]{
                'M',
                'N',
                'O',
                'P',
                'Q',
                'R'
        };
        char[] line4 = new char[]{
                'S',
                'T',
                'U',
                'V',
                'W',
                'X'
        };
        char[] line5 = new char[]{
                'Y',
                'Z',
                ' ',
                '-',
                '.',
                '\n'
        };
        //endregion
        char[] operators = sc.nextLine().toCharArray();

        int ans = 0;
        int currentRowIndex = 0;
        int currentColumnIndex = 0;
        for (char c: operators)
        {
            if (contains(line1, c))
            {
                ans += currentRowIndex;
                currentRowIndex = 0;
                int index = getIndex(line1, c);
                ans += Math.abs(currentColumnIndex - index);
                currentColumnIndex = index;
            }
            if (contains(line2, c))
            {
                ans += Math.abs(1 - currentRowIndex);
                currentRowIndex = 1;
                int index = getIndex(line2, c);
                ans += Math.abs(currentColumnIndex - index);
                currentColumnIndex = index;
            }
            if (contains(line3, c))
            {
                ans += Math.abs(2 - currentRowIndex);
                currentRowIndex = 2;
                int index = getIndex(line3, c);
                ans += Math.abs(currentColumnIndex - index);
                currentColumnIndex = index;
            }
            if (contains(line4, c))
            {
                ans += Math.abs(3 - currentRowIndex);
                currentRowIndex = 3;
                int index = getIndex(line4, c);
                ans += Math.abs(currentColumnIndex - index);
                currentColumnIndex = index;
            }
            if (contains(line5, c))
            {
                ans += 4 - currentRowIndex;
                currentRowIndex = 4;
                int index = getIndex(line5, c);
                ans += Math.abs(currentColumnIndex - index);
                currentColumnIndex = index;
            }
        }

        ans += 4 - currentRowIndex;
        ans += 5 - currentColumnIndex;

        System.out.println(ans);
    }

    private static int getIndex(char[] line, char c)
    {
        int i = 0;
        for (char f: line)
        {
            if (f == c)
            {
                return i;
            }
            i++;
        }
        return -1;
    }

    static boolean contains(char[] arr, char c)
    {
        for (char f: arr)
        {
            if (f == c)
            {
                return true;
            }
        }
        return false;
    }
}
