package org.sse.examples.leetcode;

public class S7_ReverseInteger
{
    public static void main(String []args)
    {
        S7_ReverseInteger sol = new S7_ReverseInteger();

        assert(sol.reverse(123) == 123);
        assert(sol.reverse(-123) == -123);
        assert(sol.reverse(0) == 0);
        assert(sol.reverse(1534236469) == 1056389759);
        assert(sol.reverse(2147483641) == 1463847412);

    }

    public int reverse(int x)
    {
        long l = x;
        long result = 0;
        boolean sign = l > 0;
        l = Math.abs(l);

        while (l > 0)
        {
            long ost = l % 10;
            result = result * 10 + ost;
            l /= 10;
        }

        if (result > 0x7fffffff)
            return 0;

        if (!sign)
            result = -result;

        return (int) result;
    }


}
