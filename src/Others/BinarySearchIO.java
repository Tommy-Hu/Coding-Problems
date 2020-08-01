public class BinarySearchIO
{
    public static void main(String[] args)
    {
        System.out.println(solve(new int[]{5, 5, 5, 6, 7}));
    }

    public static boolean solve(int[] nums)
    {
        if (nums.length < 2)
        {
            return false;
        }
        if (nums.length == 3)
        {
            return (nums[0] == nums[1] && nums[1] == nums[2]) || (nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2]);
        }
        int lastNum = nums[0];
        int contiNums = 0;

        for (int i = 0; i < nums.length; i++)
        {
            int num = nums[i];
            if (num == lastNum)
            {
                contiNums++;
            }
            else
            {
                if (i + 2 < nums.length && num + 1 == nums[i + 1] && num + 2 == nums[i + 2])
                {
                    i += 3;
                    continue;
                }
                if (contiNums == 1) { return false; }
                contiNums = 1;
            }
            lastNum = num;
        }
        return true;
    }
}
