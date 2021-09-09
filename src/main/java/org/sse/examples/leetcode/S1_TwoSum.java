package org.sse.examples.leetcode;

import java.util.Arrays;

public class S1_TwoSum
{
    public static void main(String[] args)
    {
        int i[] = {2,7,11,15};
        int o[] = {0,1};
        int r[] = twoSum(i, 9);

        assert (Arrays.equals(r, o));
    }

    public static int[] twoSum(int[] nums, int target) {

        int len = nums.length;

        for (int i1 = 0; i1 < len; i1++)
        {
            for (int i2 = 0; i2 < len; i2++)
            {
                if (i1 == i2) continue;

                if (nums[i1] + nums[i2] == target)
                    return new int[]{i1, i2};
            }
        }

        return null;
    }
}
