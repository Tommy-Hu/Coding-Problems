//package Junior;
//
//import Vector2;
//
//class J3_2017
//{
//    static int fuel;
//    static Vector2 startingPos;
//    static Vector2 destPos;
//
//    public static void main(String[] args)
//    {
//        if (CalculateIsPossible())
//        {
//            System.out.print("Y");
//        }
//        else
//        {
//            System.out.print("N");
//        }
//    }
//
//    private static boolean CalculateIsPossible()
//    {
//        if (Math.abs(startingPos.y - destPos.y) == fuel && startingPos.x == destPos.x)
//        {
//            return true;
//        }
//        if (Math.abs(startingPos.x - destPos.x) == fuel && startingPos.y == destPos.y)
//        {
//            return true;
//        }
//
//        if (Math.abs(startingPos.x - destPos.x) + Math.abs(startingPos.y - destPos.y) > fuel)
//        {
//            return false;
//        }
//
//        if ((Math.abs(startingPos.y - destPos.y) + Math.abs(startingPos.x - destPos.x)) % 2 == 0)
//        {
//            if (fuel % 2 != 0)
//            {
//                return false;
//            }
//        }
//        else
//        {
//            if (fuel % 2 == 0)
//            {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}
