package org.sse.examples.stream;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

// Run with VM Options: -ea
public class TestSortableDistinctStream
{
    static List<Integer> SOURCE = List.of(11, 3, 2, 5, 4, 1, 14, 12, 13, 11);

    public static void main(String args[])
    {
        testStream(true);
        testStream(false);
    }

    static void testStream(boolean isParallel)
    {
        System.out.println("Starting test, is parallel: " + isParallel);

        var stream = SOURCE.stream();
        if (isParallel) stream = stream.parallel();

        var result = stream
                .map(v -> new Wrapper(v % 10, v))
                .peek(v -> System.out.println("origin: " + v))
                .sorted()
                .peek(v -> System.out.println("sorted: " + v))
                .map(v -> v) // !!! Так работает
                .distinct()
                .peek(v -> System.out.println("distinct: " + v))
                .toList();

        System.out.println("result: " + result);
        System.out.println();

        assert (result.size() == 5);
    }

    @Value
    @AllArgsConstructor
    static class Wrapper implements Comparable<Wrapper>
    {
        // Key
        Integer value;

        // Priority with ASC sorting
        @EqualsAndHashCode.Exclude
        Integer priority;

        @Override
        public int compareTo(Wrapper o)
        {
            return priority.compareTo(o.priority); // ASC
        }

        @Override
        public String toString()
        {
            return "Wrapper{" +
                    "value=" + value +
                    ", priority=" + priority +
                    '}';
        }
    }
}
