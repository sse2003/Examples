package org.sse.examples;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerProducer2<T>
{
    private BlockingQueue<T> queue;

    public ConsumerProducer2(int maxSize)
    {
        queue = new LinkedBlockingQueue(maxSize);
    }

    public static void main(String[] args)
    {
        System.out.println("Starting...");

        ConsumerProducer2<String> cp = new ConsumerProducer2<>(4);

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

    public void produce(T value) throws InterruptedException
    {
        queue.put(value);

        System.out.println("--> " + value);
    }

    public T consume() throws InterruptedException
    {
        return queue.take();
    }
}
