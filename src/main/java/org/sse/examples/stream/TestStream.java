package org.sse.examples.stream;

import java.util.Random;
import java.util.stream.Stream;

public class TestStream
{
    public static void main(String[] args)
    {
        {
            int a = 5;
            var str = " " + ++a + ++a + (++a + ++a) + (a + (a + a--)) + a;
            System.out.println(str);
            // 6717278
        }

        {
            var a = 10;
            var b = a;
            var str = "8" + --a + (++b * 2) + (b-- * 2) + a-- + (a - 1) + (--a - a--) + a + --b;

            System.out.println(str);
            // 89222297069
        }

        var sb = Stream.<Integer>builder();

        sb.add(1).add(2).add(3);
        var s = sb.build();
        s.forEach(System.out::println);

        random();
    }

    static void random()
    {
        (new Random())
                .ints()
                .limit(10)
                .forEach(System.out::println);
    }

}
