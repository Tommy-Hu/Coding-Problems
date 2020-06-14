//package Junior;
//
//import HelperClasses.Vector2;
//
//import java.util.*;
//
//public class J4_2011
//{
//    static List<Vector2> coords = new ArrayList<>();
//
//    public static void main(String[] args)
//    {
//        Scanner s = new Scanner(System.in);
//
//        coords.add(new Vector2(0, -1));
//        coords.add(new Vector2(0, -3));
//        coords.add(new Vector2(3, -3));
//        coords.add(new Vector2(3, -5));
//        coords.add(new Vector2(5, -5));
//        coords.add(new Vector2(5, -3));
//        coords.add(new Vector2(7, -3));
//        coords.add(new Vector2(7, -7));
//        coords.add(new Vector2(-1, -7));
//        coords.add(new Vector2(-1, -5));
//        //0,-1|0,-3|3,-3|3,-5|5,-5|5,-3|7,-3|7,-7|-1,-7|-1,-5
//
//        while (true)
//        {
//            String line = s.nextLine();
//            Vector2 vec = coords.get(coords.size() - 1);
//            int lastX = vec.x;
//            int lastY = vec.y;
//            String[] command = line.split(" ");
//            int lineCommandAmount = Integer.parseInt(command[1]);
//            String commandOperation = command[0];
//            if (commandOperation.equals("q"))
//            {
//                break;
//            }
//            Vector2 vector = new Vector2(lastX, lastY);
//            boolean isSafe = true;
//            switch (commandOperation)
//            {
//                case "l":
//                    for (int i = 0; i < lineCommandAmount; i++)
//                    {
//                        vector.x--;
//                        Vector2 v = vector.duplicate();
//                        if (contains(v))
//                        {
//                            isSafe = false;
//                            vector.x -= lineCommandAmount - i - 1;
//                            break;
//                        }
////                        coords.add(v);
//                    }
//
//                    break;
//                case "r":
//                    for (int i = 0; i < lineCommandAmount; i++)
//                    {
//                        vector.x++;
//                        Vector2 v = vector.duplicate();
//                        if (contains(v))
//                        {
//                            isSafe = false;
//                            vector.x += lineCommandAmount - i - 1;
//                            break;
//                        }
////                        coords.add(v);
//                    }
//                    break;
//                case "u":
//                    for (int i = 0; i < lineCommandAmount; i++)
//                    {
//                        vector.y++;
//                        Vector2 v = vector.duplicate();
//                        if (contains(v))
//                        {
//                            isSafe = false;
//                            vector.y += lineCommandAmount - i - 1;
//                            break;
//                        }
////                        coords.add(v);
//                    }
//                    break;
//                default:
//                    for (int i = 0; i < lineCommandAmount; i++)
//                    {
//                        vector.y--;
//                        Vector2 v = vector.duplicate();
//                        if (contains(v))
//                        {
//                            isSafe = false;
//                            vector.y -= lineCommandAmount - i - 1;
//                            break;
//                        }
////                        coords.add(v);
//                    }
//                    break;
//            }
//
//            if (!isSafe)
//            {
//                System.out.println(vector.x + " " + vector.y + " DANGER");
//                return;
//            }
//            else
//            {
//                System.out.println(vector.x + " " + vector.y + " safe");
//            }
//            coords.add(vector);
//        }
//    }
//
//    static boolean contains(Vector2 v)
//    {
//        for (int i = 0; i < coords.size() - 1; i++)
//        {
//            if (Vector2.Overlaps(v, coords.get(i), coords.get(i + 1)))
//            {
//                return true;
//            }
//        }
//        return false;
//    }
//}
//
//
