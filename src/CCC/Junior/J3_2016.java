package Junior;

import java.util.*;

public class J3_2016
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String word = s.next();
        String rword = "";
        for (int i = 0; i < word.length(); i++)
        {
            rword = word.charAt(i) + rword;
        }

        if (word.length() == 1)
        {
            System.out.println(1);
        }

        List<String> wordSubs = getAllSubStrings(word);
        List<String> rwordSubs = getAllSubStrings(rword);

        int longestCount = 0;
        for (int i = 0; i < wordSubs.size(); i++)
        {
            for (int j = 0; j < rwordSubs.size(); j++)
            {
                String wi = wordSubs.get(i);
                String rwj = rwordSubs.get(j);
                if (wi.equals(rwj) && wi.length() > longestCount)
                {
                    longestCount = wi.length();
                }
            }
        }

        System.out.println(longestCount);
    }

    public static List<String> getAllSubStrings(String str)
    {
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < str.length(); i++)
        {
            for (int j = i + 1; j <= str.length(); j++)
            {
                strs.add(str.substring(i, j));
            }
        }
        return strs;
    }
}