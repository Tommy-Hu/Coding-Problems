package Senior;

import java.util.Scanner;

public class S2_2003
{
    enum RymeType
    {
        perfect, even, cross, shell, free
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int verseCount = s.nextInt();
        int finishedCt = 0;
        String[] poemSec = new String[4];
        s.nextLine();//skip empty space
        for (int i = 0; i < 4 * verseCount && finishedCt < verseCount; i++)
        {
            String str = s.nextLine();
            poemSec[i] = str;
            if ((i + 1) % 4 == 0)
            {
                System.out.println(GetRymeType(poemSec).toString());
                poemSec = new String[4];
                i = -1;
                finishedCt++;
            }
        }
    }

    static RymeType GetRymeType(String[] fourLines)
    {
        String s1 = GetSyllable(fourLines[0]);
        String s2 = GetSyllable(fourLines[1]);
        String s3 = GetSyllable(fourLines[2]);
        String s4 = GetSyllable(fourLines[3]);

        if (isSame(s1, s2) && isSame(s3, s4))
        {
            if (isSame(s2, s3))
            {
                return RymeType.perfect;
            }
            else
            {
                return RymeType.even;
            }
        }
        else if (isSame(s1, s3))
        {
            if (isSame(s2, s4))
            {
                return RymeType.cross;
            }
            else
            {
                return RymeType.free;
            }
        }
        else if (isSame(s1, s4))
        {
            if (isSame(s2, s3))
            {
                return RymeType.shell;
            }
            else
            {
                return RymeType.free;
            }
        }
        else
        {
            return RymeType.free;
        }
    }

    static boolean isSame(String s1, String s2)
    {
        if (s1.indexOf("y") != s1.length() - 1)
        {
            String[] split = s1.split("y");
            s1 = split[split.length - 1];
        }
        if (s2.indexOf("y") != s2.length() - 1)
        {
            String[] split = s2.split("y");
            s2 = split[split.length - 1];
        }

        if (s1.endsWith("y"))
        {
            if (!s2.endsWith("y"))
            {
                s1.substring(0, s1.length() - 1);
            }
        }
        if (s2.endsWith("y"))
        {
            if (!s1.endsWith("y"))
            {
                s2.substring(0, s2.length() - 1);
            }
        }

        return (s1.endsWith(s2) || s2.endsWith(s1));
    }

    static String GetSyllable(String line)
    {
        line = line.toLowerCase();

        String[] splits = line.split(" ");
        String lastWord = splits[splits.length - 1];

        if ((!lastWord.contains("a") && !lastWord.contains("e") && !lastWord.contains("i") && !lastWord.contains("o") && !lastWord.contains("u")))
        {
            return lastWord;
        }


        String syls = "";
        boolean isLastSyl = false;
        boolean foundSyl = false;

        for (int i = lastWord.length() - 1; i >= 0; i--)
        {
            Character d = lastWord.charAt(i);
            if ((d.equals('a') || d.equals('e') || d.equals('i') || d.equals('o') || d.equals('u') || d.equals('y')))
            {
                if (!foundSyl)
                {
                    isLastSyl = true;
                    foundSyl = true;
                    syls = d.toString() + syls;
                }
                else if (isLastSyl)
                {
                    isLastSyl = true;
                    syls = d.toString() + syls;
                }
            }
            else if (foundSyl)
            {
                break;
            }
        }

        return syls.equals("") ? lastWord : syls;
    }
}