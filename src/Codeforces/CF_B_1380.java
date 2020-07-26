import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CF_B_1380
{
    public static void main(String[] args) throws IOException
    {
        int t = readInt();
        for (int __ = 0; __ < t; __++)
        {
            String s = br.readLine();
            int RCount = s.length() - s.replaceAll("R", "").length();
            int SCount = s.length() - s.replaceAll("S", "").length();
            int PCount = s.length() - s.replaceAll("P", "").length();
            int max = Integer.max(Integer.max(RCount, SCount), PCount);
            System.out.println(RCount == max ? "P".repeat(s.length()) : (SCount == max ? "R".repeat(s.length()) : "S".repeat(s.length())));
        }
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
