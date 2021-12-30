package org.sse.examples;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConsumerProducer2<T>
{
    private int maxSize;
    private LinkedList<T> queue = (LinkedList<T>) Collections.synchronizedCollection(new LinkedList<>());

    public ConsumerProducer2(int maxSize)
    {
        this.maxSize = maxSize;
    }

    public static void main(String[] args)
    {
        System.out.println("Starting...");

        ConsumerProducer2<String> cp = new ConsumerProducer2<>(4);

        Executor e = Executors.newFixedThreadPool(8);
        e.execute(() -> {
            for (int i = 0; i < 16; i++)
            {
                System.out.println("<-- " + cp.consume());
            }
        });

        e.execute(() -> {
            for (int i = 0; i < 16; i++)
            {
                cp.produce("" + i);
            }
        });
    }

    public void produce(T value)
    {
        while (queue.size() >= maxSize)
        {
        }

        System.out.println("--> " + value);

        queue.add(value);
    }

    public T consume()
    {
        while (queue.isEmpty())
        {
        }

        return queue.remove();
    }
}
