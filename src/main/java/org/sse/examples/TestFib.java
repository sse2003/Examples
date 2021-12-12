package org.sse.examples;

import java.math.BigInteger;
import java.util.stream.Stream;

public class TestFib
{
    public static int lastValue1;
    public static int lastValue2;

    public static void main(String[] args)
    {
        TestFib t1 = new TestFib();

        t1.getFibona4iStream()
                .skip(4)
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    public void clear()
    {
        lastValue1 = 0;
        lastValue2 = 1;
    }

    public int getNext()
    {
        int result = lastValue1 + lastValue2;
        lastValue1 = lastValue2;
        lastValue2 = result;
        return result;
    }

    public Stream<BigInteger[]> getFibona4iStream()
    {
        return Stream.iterate(new BigInteger[]{BigInteger.valueOf(0), BigInteger.valueOf(1)}, t -> new BigInteger[]{t[1], t[1].add(t[0])});
    }

    public Stream<long[]> getFibona4iStream2()
    {
        return Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]});
    }

    public Stream<Long> getFibona4iStream3()
    {
        return Stream.iterate(0l, t -> t + 1);
    }

}
