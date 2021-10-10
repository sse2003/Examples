package org.sse.examples.leetcode;

public class S10_RegExpMatching_2
{
    public static void main(String[] args)
    {
        assert (isMatch("vaz", ".*a*"));
        assert (isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"));

        assert (!isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));
        assert (isMatch("aaaaaaaaaaaaac", "a*a*a*a*a*a*a*a*a*a*c"));
        assert (isMatch("ba", ".*a*a"));
        assert (isMatch("bbbba", ".*a*a"));
        assert (!isMatch("abcd", "d*"));
        assert (!isMatch("ab", ".*c"));
        assert (isMatch("a", "ab*"));
        assert (isMatch("aaa", "ab*ac*a"));
        assert (isMatch("aab", "c*a*b"));
        assert (isMatch("aa", "a*"));
        assert (!isMatch("aaa", "aaaa"));
        assert (!isMatch("aa", "a"));
        assert (isMatch("aa", "a."));
        assert (isMatch("aa", ".a"));
        assert (isMatch("ab", ".*"));
        assert (!isMatch("mississippi", "mis*is*p*."));
        assert (isMatch("mississippi", "mis*is*ip*."));
        assert (isMatch("ssissippi", "s*is*ip*."));
        assert (isMatch("aaa", "a*a"));
    }


    public static boolean isMatch(String s, String p)
    {
        if (p.isEmpty()) return s.isEmpty();

        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));

        if (p.length() > 1)
        {
            if (p.charAt(1) == '*')
            {
                if (firstMatch)
                    return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
                else
                    return isMatch(s, p.substring(2));

            }

            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

        return firstMatch && (p.length() == s.length());
    }
}
