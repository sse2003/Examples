package org.sse.examples.leetcode;

public class S4_MedianOfTwoSortedArrays
{
    public static void main(String[] arg)
    {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double result = findMedianSortedArrays(nums1, nums2);
        assert (result == 2.0);

        nums1 = new int[]{1,2};
        nums2 = new int[]{3,4};
        result = findMedianSortedArrays(nums1, nums2);
        assert (result == 2.5);

        nums1 = new int[]{0,0};
        nums2 = new int[]{0,0};
        result = findMedianSortedArrays(nums1, nums2);
        assert (result == 0);

        nums1 = new int[]{};
        nums2 = new int[]{1};
        result = findMedianSortedArrays(nums1, nums2);
        assert (result == 1);

        nums1 = new int[]{2};
        nums2 = new int[]{};
        result = findMedianSortedArrays(nums1, nums2);
        assert (result == 2);

    }

    static int s1;
    static int s2;
    static int i1;
    static int i2;
    static int m;
    static int c;

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        s1 = nums1.length;
        s2 = nums2.length;
        i1 = 0;
        i2 = 0;

        m = (s1+s2) / 2;
        c = (s1+s2) % 2 ; // if 0 then a+b/2 else a

        if (c == 0)
            m--;

        while (i1 + i2 < m)
        {
            get(nums1, nums2);
        }

        if (c == 0)
        {
            double v1 = get(nums1, nums2);
            double v2 = get(nums1, nums2);
            return (v1+v2)/2;
        } else
        {
            return (double) get(nums1, nums2);
        }

    }

    public static int get(int[] nums1, int[] nums2)
    {
        if (i1 >= s1)
            return nums2[i2++];

        if (i2 >= s2)
            return nums1[i1++];

        if (nums1[i1] < nums2[i2])
            return nums1[i1++];

        if(nums1[i1] > nums2[i2])
            return nums2[i2++];

        return nums1[i1++];
    }
}
