package Junior;

import java.util.Scanner;

public class J4_2009
{
    private static final String[] message = {"WELCOME", "TO", "CCC", "GOOD", "LUCK", "TODAY"};
    private static int w = 0;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();

        String line = "";
        for (int i = 0; i < message.length; i++)
        {
            String word = message[i];
            line += word + ".";

            if (line.length() > w)
            {
                if (line.endsWith("."))
                {
                    line = line.substring(0, line.length() - 1);
                    if (line.length() == w)
                    {
                        System.out.println(line);
                        line = "";
                        continue;
                    }
                }
                i--;

                int c = 0;
                String f = line.split("\\.")[0];
                for (int j = 0; j < message.length; j++)
                {
                    if (message[j].equals(f))
                    {
                        c = j;
                        break;
                    }
                }
                System.out.println(formatLine(line, c, c));

                line = "";
            }
            else if (line.length() == w)
            {
                System.out.println(line.substring(0, line.length() - 1).replaceFirst("\\.", ".."));
                line = "";
            }
            else
            {
                if (i + 1 == message.length)
                {
                    if (line.startsWith(message[i]))
                    {
                        int total = w - line.length();
                        for (int j = 0; j < total; j++)
                        {
                            line += ".";
                        }
                        System.out.println(line);
                        return;
                    }
                    else
                    {
                        int c = 0;
                        String f = line.split("\\.")[0];
                        for (int j = 0; j < message.length; j++)
                        {
                            if (message[j].equals(f))
                            {
                                c = j;
                                break;
                            }
                        }
                        System.out.println(formatLine(line, c, c));
                        return;
                    }
                }
            }
        }
    }

    private static String formatLine(String line, int addIndex, final int startIndex)
    {
        boolean isGood = true;
        String f;
        f = line.replaceAll("\\.", "");
        for (int i = 0; i < message.length; i++)
        {
            if (f.equals(message[i]))
            {
                isGood = false;
                break;
            }
        }


        if (line.endsWith(".") && isGood)
        {
            line = line.substring(0, line.length() - 1);
            return formatLine(line, addIndex, startIndex);
        }
        if (line.length() > w)
        {
            String[] split = line.split("\\.");
            line = line.replace(split[split.length - 1], "");
            return formatLine(line, addIndex, startIndex);
        }
        else if (line.length() == w)
        {
            return line;
        }
        else if (!isGood)
        {
            line += ".";
            return formatLine(line, addIndex, startIndex);
        }
        else
        {
            int ci = line.indexOf(message[addIndex]) + message[addIndex].length();//?
            if (ci < line.length() - 1)
            {
                addIndex++;
                line = line.substring(0, ci) + "." + line.substring(ci);
            }
            else
            {
                addIndex = startIndex;
            }
            return formatLine(line, addIndex, startIndex);
        }

    }
}
