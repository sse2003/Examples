package org.sse.examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConsumerProducer<T>
{
    private int maxSize;
    private Queue<T> queue = new LinkedList<>();

    public ConsumerProducer(int maxSize)
    {
        this.maxSize = maxSize;
    }

    public static void main(String[] args)
    {
        System.out.println("Starting...");

        ConsumerProducer<String> cp = new ConsumerProducer<>(2);

        Executor e = Executors.newFixedThreadPool(8);
        e.execute(() -> {
            for (int i = 0; i < 16; i++)
            {
                try
                {
                    System.out.println("<-- " + cp.consume());
                } catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        e.execute(() -> {
            for (int i = 0; i < 16; i++)
            {
                try
                {
                    cp.produce("" + i);
                } catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

    public synchronized void produce(T value) throws InterruptedException
    {
        if (queue.size() == maxSize)
            wait();

        System.out.println("--> " + value);

        queue.add(value);
        notify();
    }

    public synchronized T consume() throws InterruptedException
    {
        if (queue.isEmpty())
            wait();

        T result = queue.remove();

        notify();

        return result;
    }
}
