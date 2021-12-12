package org.sse.examples;

import java.util.stream.Stream;

public class TestStream
{

    public static void main(String[] args)
    {
        var sb = Stream.<Integer>builder();


        sb.add(1).add(2).add(3);
        var s = sb.build();
        s.forEach(System.out::println);
    }

}
