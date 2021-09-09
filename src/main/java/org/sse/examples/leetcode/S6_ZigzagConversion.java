package org.sse.examples.leetcode;

import java.util.ArrayList;

public class S6_ZigzagConversion
{
    public static void main(String []arg)
    {
        S6_ZigzagConversion sol = new S6_ZigzagConversion();

        assert(sol.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        assert(sol.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
        assert(sol.convert("A", 1).equals("A"));
    }

    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> list = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++)
            list.add(new StringBuilder());

        int ai = 0;
        boolean reverse = false;

        for (int i = 0; i < s.length(); i++)
        {
            list.get(ai).append(s.charAt(i));

            if (!reverse)
            {
                if (ai++ == numRows - 1)
                {
                    reverse = !reverse;
                    ai = numRows - 2;
                    if (ai < 0) ai = 0;
                }
            } else {
                if (ai-- == 0)
                {
                    reverse = !reverse;
                    ai = 1;
                    if (ai >= numRows) ai = numRows - 1;
                }
            }
        }

        String result = "";
        for (int i = 0; i < numRows; i++)
            result += list.get(i).toString();

        return result;
    }

}
