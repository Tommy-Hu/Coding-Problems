package Tommy.CCC.Junior;

import java.util.*;

public class J4_2008
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true)
        {
            String line = sc.nextLine();
            if (line.equals("0"))
            {
                break;
            }
            Stack<String> stack = new Stack<>();

            for (int i = line.length() - 1; i >= 0; i--)
            {
                char c = line.charAt(i);
                if (c == ' ')
                {
                    continue;
                }
                if (isOperator(c))
                {
                    //pop two from stack to combine them with the char, and then push them.
                    String a = stack.pop();
                    String b = stack.pop();

                    stack.push(a + " " + b + " " + c);
                }
                else
                {
                    //push it to the stack
                    stack.push(c + "");
                }
            }

            System.out.println(stack.pop());
        }
    }

    static boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
