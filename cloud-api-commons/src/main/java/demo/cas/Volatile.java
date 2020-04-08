package demo.cas;

/**
 * @author wyg_edu
 * @version 1.0
 * @date 2020/4/8 19:27
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Volatile关键字
 * 1、可见性
 * 2、不保证原子性
 * AtomicInteger关键字保证int的原子性
 */
public class Volatile {
    public static volatile AtomicInteger value = new AtomicInteger();
    public static void add(){
        value.incrementAndGet();
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Runnable task = () -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            };
            new Thread(task).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(value);

    }
}
