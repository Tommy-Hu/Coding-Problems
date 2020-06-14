package Senior;

import java.util.HashSet;
import java.util.Scanner;

public class S2_2006
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        String line3 = sc.nextLine();

        HashSet<KeyValuePair<Character, Character>> kvps = new HashSet<>();

        for (int i = 0; i < line1.length(); i++)
        {
            char a = line1.charAt(i);
            char b = line2.charAt(i);

            KeyValuePair<Character, Character> keyValuePair = new KeyValuePair<Character, Character>(b, a);

            kvps.add(keyValuePair);
        }
        for (int i = 0; i < line3.length(); i++)
        {
            char c = line3.charAt(i);
            line3 = line3.substring(0, i) + getChar(c, kvps) + line3.substring(i + 1);
        }
        System.out.println(line3);
    }

    private static char getChar(char c, HashSet<KeyValuePair<Character, Character>> kvps)
    {
        for (KeyValuePair<Character, Character> k: kvps)
        {
            if (c == k.key)
            {
                return k.value;
            }
        }
        return '.';
    }

    static class KeyValuePair<key, value>
    {
        public key key;
        public value value;

        public KeyValuePair(key key, value value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
