package org.sse.examples.leetcode;

import java.util.HashSet;

public class S3_LongestSubstringWithoutRepeatingCharacters
{

    public int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        HashSet<Character> seq = new HashSet<Character>();
        int result = 0;
        int lastAddIndex = 0;


        for (int i = 0; i < s.length(); i++)
        {
            Character c = chars[i];
            if (seq.contains(c))
            {
                if (seq.size() > result)
                    result = seq.size();

                seq.clear();
                i = lastAddIndex++;
                continue;
            }

            seq.add(c);
        }

        if (seq.size() > result)
            result = seq.size();

        seq.clear();


        return result;
    }

}
