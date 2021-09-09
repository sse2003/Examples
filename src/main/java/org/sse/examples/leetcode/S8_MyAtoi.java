package org.sse.examples.leetcode;

public class S8_MyAtoi
{
    public static void main(String []args)
    {
        S8_MyAtoi sol = new S8_MyAtoi();

        assert (sol.myAtoi("12345") == 12345);
        assert (sol.myAtoi("5") == 5);
        assert (sol.myAtoi("-5") == -5);
        assert (sol.myAtoi("+5") == 5);
        assert (sol.myAtoi("+-5") == 0);
        assert (sol.myAtoi("" + (1l + Integer.MAX_VALUE)) == Integer.MAX_VALUE);
        assert (sol.myAtoi("00000-42a1234") == 0);
        assert (sol.myAtoi("9223372036854775808") == Integer.MAX_VALUE);
        assert (sol.myAtoi("-91283472332") == Integer.MIN_VALUE);
    }

    private String nums = "0123456789-+";
    private enum Type {Space, Sign, Data};


    public int myAtoi(String s) {
        Type type = Type.Space;

        long result = 0;
        boolean neg = false;

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (type == Type.Space)
            {
                if (c == ' ')
                    continue;

                if (c == '-' || c == '+')
                    type = Type.Sign;

                if (c >= '0' && c <= '9')
                    type = Type.Data;
            }

            if (type == Type.Sign)
            {
                if (c == '-')
                    neg = true;

                type = Type.Data;

                continue;
            }

            if (c >= '0' && c <= '9')
            {
                result = result * 10 + (c - '0');
                if (!neg && result > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;

                if (neg && (-result) < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;

            } else break;
        }

        if (neg)
            result = -result;

        return (int) result;
    }

//    private int makeResult(long result, boolean neg)
//    {
//        if (neg)
//            result = -result;
//
//        if (result > Integer.MAX_VALUE)
//            result = Integer.MAX_VALUE;
//
//        if (result < Integer.MIN_VALUE)
//            result = Integer.MIN_VALUE;
//
//
//        return (int) result;
//    }

//    private int find(String s, char c)
//    {
//        return s.indexOf(c);
//    }
}
