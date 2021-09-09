package org.sse.examples.leetcode;

public class S5_LongestPalindrome
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

    private static final int ERROR = -1;

    public static String longestPalindrome(String s) {

        char[] source = s.toCharArray();

        boolean all = true;
        for (int i = 1; i < source.length; i++)
        {
            if(source[0] != source[i])
            {
                all = false;
                break;
            }
        }

        if (all)
            return s.substring(0, source.length);

        if (source.length == 2)
            return s.substring(0, 1);

        String result = s.substring(0, 1);

        int lIndex = 0;
        boolean except;

        for (int rIndex = source.length - 1; rIndex >= 0; rIndex--)
        {
            except = false;
            char r = source[rIndex];

            lIndex = findChar(source, r, 0, false);
            if (lIndex == ERROR)
            {
                continue;
            }

            while(lIndex < rIndex && !except)
            {
                int lIndex2 = lIndex + 1;

                for (int rIndex2 = rIndex - 1; rIndex2 >= 0; rIndex2--, lIndex2++)
                {
                    if (lIndex2 >= source.length)
                        break;

                    if(source[lIndex2] != source[rIndex2])
                        break;

                    if (lIndex2 >= rIndex2)
                    {
                        String result2 = s.substring(lIndex, rIndex + 1);
                        if (result2.length() >= result.length())
                        {
                            result = result2;
                            if (result.length() >= source.length)
                                return result;

                            except = true;
                            break;
                        }
                    }
                }

                lIndex = findChar(source, r, lIndex + 1, false);

                if (lIndex == ERROR)
                {
                    break;
                }
            }

        }

        return result;
    }

    static int findChar(char[] source, char find, int startIndex, boolean reverse)
    {
        if (!reverse)
        {
            for (int i = startIndex; i < source.length; i++)
                if (source[i] == find) return i;
        }
        else
        {
            for (int i = startIndex; i >= 0; i--)
                if (source[i] == find) return i;
        }

        return ERROR;

    }

}
