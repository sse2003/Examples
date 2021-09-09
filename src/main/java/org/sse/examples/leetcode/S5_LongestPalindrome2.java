package org.sse.examples.leetcode;

public class S5_LongestPalindrome2
{
    public static void main(String[] args)
    {
        assert(longestPalindrome("babad").equals("bab"));
        assert(longestPalindrome("cbbd").equals("bb"));
        assert(longestPalindrome("a").equals("a"));
        assert(longestPalindrome("ac").equals("a"));
        assert(longestPalindrome("bb").equals("bb"));
        assert(longestPalindrome("ccc").equals("ccc"));
        assert(longestPalindrome("abcda").equals("a"));
        assert(longestPalindrome("abacab").equals("bacab"));

        assert(longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa").equals("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
    }

    public static String longestPalindrome(String s)
    {
        if (s.length() == 0)
            return "";

        int l = 0, r = 0;
        for(int i = 0; i < s.length(); i++)
        {
            int len1 = findAroundCenter(s, i, i);
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1))
            {
                int len2 = findAroundCenter(s, i, i + 1);

                if (len2 > len1)
                    len1 = len2;
            }

            if (r - l + 1 < len1)
            {
                l = i - (len1 - 1) / 2 ;
                r = i + len1 / 2;
            }
        }

        return s.substring(l, r + 1);
    }

    public static int findAroundCenter(String s, int l, int r)
    {
        int L, R;

        for (L = l, R = r; L >= 0 && R < s.length(); L--, R++)
        {
            if (s.charAt(L) != s.charAt(R))
            {
                break;
            }
        }

        return R - L + 1 - 2;
    }
}

//package org.sse.examples.leetcode;
//
//public class S5_LongestPalindrome2
//{
//    public static void main(String[] args)
//    {
//        assert(longestPalindrome("babad").equals("bab"));
//        assert(longestPalindrome("cbbd").equals("bb"));
//        assert(longestPalindrome("a").equals("a"));
//        assert(longestPalindrome("ac").equals("a"));
//        assert(longestPalindrome("bb").equals("bb"));
//        assert(longestPalindrome("ccc").equals("ccc"));
//        assert(longestPalindrome("abcda").equals("a"));
//        assert(longestPalindrome("abacab").equals("bacab"));
//
//        assert(longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa").equals("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
//    }
//
//    public static String longestPalindrome(String s)
//    {
//        if (s.length() == 0)
//            return "";
//
//        int l = 0, r = 0;
//        for(int i = 0; i < s.length(); i++)
//        {
//            Data d1 = findAroundCenter(s, i, i);
//            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1))
//            {
//                Data d2 = findAroundCenter(s, i, i + 1);
//                d1 = d1.getSize() > d2.getSize() ? d1 : d2;
//            }
//
//            if (r - l + 1 < d1.getSize())
//            {
//                l = d1.l;
//                r = d1.r;
//            }
//        }
//
//        return s.substring(l, r + 1);
//    }
//
//    public static Data findAroundCenter(String s, int l, int r)
//    {
//        int L, R;
//
//        for (L = l, R = r; L >= 0 && R < s.length(); L--, R++)
//        {
//            if (s.charAt(L) != s.charAt(R))
//            {
//                break;
//            }
//        }
//
//        return new Data(L+1, R-1);
//    }
//
//    static class Data
//    {
//        int l;
//        int r;
//
//        Data(int l, int r)
//        {
//            this.l = l;
//            this.r = r;
//        }
//
//        int getSize()
//        {
//            return r - l + 1;
//        }
//    }
//}
