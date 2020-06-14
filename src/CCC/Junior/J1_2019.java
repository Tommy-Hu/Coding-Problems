package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1_2019
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int apple = 0;
        int banana = 0;

        apple = Integer.parseInt(reader.readLine()) * 3;
        apple += Integer.parseInt(reader.readLine()) * 2;
        apple += Integer.parseInt(reader.readLine());

        banana = Integer.parseInt(reader.readLine()) * 3;
        banana += Integer.parseInt(reader.readLine()) * 2;
        banana += Integer.parseInt(reader.readLine());

        if (apple > banana)
        {
            System.out.print("A");
        }
        else if (banana > apple)
        {
            System.out.print("B");
        }
        else
        {
            System.out.print("T");
        }
    }
}
