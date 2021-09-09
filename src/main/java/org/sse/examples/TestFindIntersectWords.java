package org.sse.examples;

import java.util.*;

public class TestFindIntersectWords
{
    public static void main(String[] args)
    {
        String s1 = "hello hello world";
        String s2 = "hello world";

        assert(check(s1, s2));
        assert(!check(s2, s1));

        s1 = "hello hello world many worlds";
        s2 = "hello world";

        assert(check(s1, s2));
        assert(!check(s2, s1));

        s1 = "hello hello world many worlds";
        s2 = "hello my world";

        assert(!check(s1, s2));
        assert(!check(s2, s1));

        s1 = "hello world";
        s2 = "hello world";

        assert(check(s1, s2));
        assert(check(s2, s1));
    }

    private static boolean check(String s1, String s2)
    {
        HashMap<String, Integer> m1 = new HashMap<>();
        HashMap<String, Integer> m2 = new HashMap<>();

        for(String s: s1.split(" "))
        {
            Integer cnt = m1.get(s);
            if (cnt != null)
                cnt++;
            else
                cnt = 1;

            m1.put(s, cnt);
        }

        for(String s: s2.split(" "))
        {
            Integer cnt = m1.get(s);
            if (cnt == null)
                return false;

            Integer cnt2 = m2.get(s);
            if (cnt2 != null)
                cnt2++;
            else
                cnt2 = 1;

            if (cnt2 > cnt)
                return false;

            m2.put(s, cnt2);
        }

        Collections.sort(new LinkedList<String>(), (o1, o2) -> 0);

        return true;
    }
}
