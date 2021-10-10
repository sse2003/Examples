package org.sse.examples.leetcode;

public class S10_RegExpMatching
{
    public static void main(String[] args)
    {
        assert (isMatch("aaa", "a*a"));

        assert (!isMatch("ab", ".*c"));
        assert (!isMatch("aaa", "aaaa"));
        assert (!isMatch("aa", "a"));
        assert (isMatch("aa", "a*"));
        assert (isMatch("ab", ".*"));
        assert (isMatch("aab", "c*a*b"));
        assert (!isMatch("mississippi", "mis*is*p*."));
        assert (isMatch("mississippi", "mis*is*ip*."));
        assert (isMatch("ssissippi", "s*is*ip*."));
    }

    static String ss;
    static int si;

    public static class Element
    {
        Character element;
        int minCount;
        int maxCount;
        int size;
        Element parent = null;
        Element child = null;

        Element(String s, int pos)
        {
            size = 1;
            minCount = 1;
            maxCount = 1;

            if (pos < s.length())
            {
                element = s.charAt(pos);
                if (pos < s.length() - 1)
                {
                    char next = s.charAt(pos + 1);
                    switch (next)
                    {
                        case '*':
                            minCount = 0;
                            maxCount = Integer.MAX_VALUE;
                            size = 2;
                            break;
                        default:
                            break;
                    }
                }
            } else
            {
                element = null;
            }
        }

        Element match(Character c)
        {
            if (element == '.' || element == c)
            {
                if (--maxCount > 0)
                    return this;
                return child;
            }
            if (element != c && minCount == 0)
                if (maxCount != Integer.MAX_VALUE)
                    return child.match(c);
                else
                    return child;

            return null;
        }

        private static Element build(String s, int pos)
        {
            Element element = new Element(s, pos);
            if (pos + element.size < s.length())
            {
                element.child = Element.build(s, pos + element.size);
                element.child.parent = element;
            }
            return element;
        }

        static Element build(String s)
        {
            return Element.build(s, 0);
        }
    }

    static Character getNextSourceChar()
    {
        if (si < ss.length())
            return ss.charAt(si++);

        else return null;
    }

//    public static boolean isMatch(String text, String pattern)
//    {
//        if (pattern.isEmpty()) return text.isEmpty();
//        boolean first_match = (!text.isEmpty() &&
//                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
//
//        if (pattern.length() >= 2 && pattern.charAt(1) == '*')
//        {
//            return (isMatch(text, pattern.substring(2)) ||
//                    (first_match && isMatch(text.substring(1), pattern)));
//        } else
//        {
//            return first_match && isMatch(text.substring(1), pattern.substring(1));
//        }
//    }

    public static boolean isMatch(String s, String p)
    {
        ss = s;
        si = 0;

        Character sChar = getNextSourceChar();
        Element pElement = Element.build(p);

        while (sChar != null && pElement != null)
        {
            pElement = pElement.match(sChar);
            sChar = getNextSourceChar();
        }

        return sChar == null && (pElement == null || (pElement.child == null && pElement.maxCount > 1));
    }
}
