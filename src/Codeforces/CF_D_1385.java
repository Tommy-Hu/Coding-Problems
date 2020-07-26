import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_D_1385
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            readInt();
            String string = br.readLine();
            System.out.println(getCount(string, 'a'));
        }
    }

    private static int getCount(String string, char suppose)
    {
        if (string.length() == 1)
        {
            return suppose == string.charAt(0) ? 0 : 1;
        }
        char nextS = (char) ((int) suppose + 1);

        String firstHalf = string.substring(0, string.length() / 2);
        String secondHalf = string.substring(string.length() / 2);

        return Integer.min(
                getCount(firstHalf, nextS) + secondHalf.replace(Character.toString(suppose), "").length(),
                getCount(secondHalf, nextS) + firstHalf.replace(Character.toString(suppose), "").length());
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int readInt() throws IOException
    {
        while (st == null || !st.hasMoreTokens())
        {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
}
